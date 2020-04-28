package com.example.service.impl;

import com.example.mapper.SysMenuMapper;
import com.example.mapper.SysRoleMapper;
import com.example.mapper.SysUserMapper;
import com.example.mapper.SysUserRoleMapper;
import com.example.model.*;
import com.example.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.*;

/**
 * @description
 * @author chen
 * */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    /**
     * 用户拥有的角色Id
     **/
    private List<Integer> roleId;

    /**
     * 登录接口
     * */
    @Override

    public Serializable userLogin(HttpServletResponse response, String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token1 = new UsernamePasswordToken(username,password);
        try {
            subject.login(token1);
        }catch (IncorrectCredentialsException e) {
            response.setStatus(202);
            return e.getMessage();
        }catch (UnknownAccountException e) {
            response.setStatus(202);
            return e.getMessage();
        }catch (LockedAccountException e) {
            response.setStatus(203);
            return e.getMessage();
        }catch (Exception e) {
            e.printStackTrace();
        }
        Serializable token = subject.getSession().getId();
        return token;
    }
    /**
     * 获取用户角色
     */
    @Override
    public Set<String> getRoles(String username) {
        List<SysRole> sysRoles = sysRoleMapper.selectByUserName(username);
        Set<String> roles = new HashSet<>();
        for (int id = 0; id < sysRoles.size(); id++) {
            String roleName = sysRoles.get(id).getRoleName();
            if (StringUtils.isEmpty(roleName)) {
                continue;
            }
            roles.add(roleName);
        }
        return roles;
    }

    /**
     * 获取用户权限
     **/
    @Override
    public Set<String> getPermissions(String username) {
        List<SysMenu> sysMenus =  sysMenuMapper.selectByUserName(username);
        Set<String> permsSet = new HashSet<>();
        for (int i = 0; i < sysMenus.size(); i++) {
            String perm = sysMenus.get(i).getPerms();
            if (StringUtils.isEmpty(perm)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
        }
        return permsSet;
    }


    /**
     * 获取权限菜单
     */
    @Override
    public Map<String, List> getMenu() {
        //获取menu菜单
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        List<SysMenu> sysMenus = sysMenuMapper.selectByUserNameAndType(user.getUsername(),1);
        //按要求转换菜单格式
        //routerDatas保存路由信息
        RouterData routerData = new RouterData();
        List<RouterData> routerDatas = new ArrayList<>();
        //navbar保存顶栏信息
        List<NavData> navbar = new ArrayList<>();
        //childrens保存二级路由信息
        List<RouterData.Children> childrens = new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for (int i = 0; i < sysMenus.size(); i++) {
            //判断是否为顶栏
            if (sysMenus.get(i).getNavbarId() == 0) {
                NavData navData = new NavData();
                navData.setIcon(sysMenus.get(i).getIcon());
                navData.setIndex(sysMenus.get(i).getName());
                navData.setTitle(sysMenus.get(i).getName());
                navbar.add(navData);
                //判断是否是第一顶栏
                if (sysMenus.get(i).getMenuId() == 1) {
                    for (int s = 0; s < sysMenus.size(); s++) {
                        if (sysMenus.get(s).getNavbarId() == 1 && sysMenus.get(s).getParentId() == 0) {
                            RouterData.Children children = new RouterData.Children();
                            children.setPath("/"+sysMenus.get(s).getUrl());
                            children.setName(sysMenus.get(s).getUrl());
                            children.setComponent(sysMenus.get(s).getUrl());
                            childrens.add(children);
                        }
                    }
                } else if (sysMenus.get(i).getMenuId() == 2) {
                    Map<String,List> routerChildren = getRouterChildren(sysMenus,2);
                    map.put("navDatas1", routerChildren.get("navDatas"));
                    childrens.add((RouterData.Children) routerChildren.get("children").get(0));
                } else if (sysMenus.get(i).getMenuId() == 3) {
                    Map<String,List> routerChildren = getRouterChildren(sysMenus,3);
                    map.put("navDatas2", routerChildren.get("navDatas"));
                    childrens.add((RouterData.Children) routerChildren.get("children").get(0));
                } else if (sysMenus.get(i).getMenuId() == 4) {
                    Map<String,List> routerChildren = getRouterChildren(sysMenus,4);
                    map.put("navDatas3", routerChildren.get("navDatas"));
                    childrens.add((RouterData.Children) routerChildren.get("children").get(0));
                }
            }
        }
        routerData.setName("dashboard");
        routerData.setPath("/");
        routerData.setComponent("dashboard");
        routerData.setChildren(childrens);
        routerDatas.add(routerData);
        map.put("routerData", routerDatas);
        return map;
    }

    /**
     * 根据顶栏位置获取侧栏
     * */
    public Map<String,List> getRouterChildren(List<SysMenu> sysMenus,Integer orderNum) {
        Map<String, List> map = new HashMap<>();
        //childrens保存二级路由信息
        List<RouterData.Children> childrens = new ArrayList<>();
        //navData1保存第二顶栏的侧边栏
        List<NavData> navDatas = new ArrayList<>();
        //childrens1保存三级路由信息
        List<RouterData.Children.Childrens> childrens1 = new ArrayList<>();
        RouterData.Children children = new RouterData.Children();
        children.setPath("/menu"+orderNum+"_item0");
        children.setName("menu"+orderNum+"_item0");
        children.setComponent("menu"+orderNum+"_item0");
        for (int s = 0; s < sysMenus.size(); s++) {
            if (sysMenus.get(s).getNavbarId().equals(orderNum) && sysMenus.get(s).getParentId() == 0) {
                //navData1保存侧栏信息
                NavData navData1 = new NavData();
                navData1.setIcon(sysMenus.get(s).getIcon());
                navData1.setIndex(sysMenus.get(s).getName());
                navData1.setTitle(sysMenus.get(s).getName());
                //subs保存侧栏的子栏信息
                List<NavData.Subs> subs = new ArrayList<>();
                for (int x = 0; x < sysMenus.size(); x++) {
                    if (sysMenus.get(x).getNavbarId().equals(orderNum) && sysMenus.get(x).getParentId().equals(sysMenus.get(s).getMenuId())) {
                        RouterData.Children.Childrens children1 = new RouterData.Children.Childrens();
                        children1.setPath("/"+sysMenus.get(x).getUrl());
                        children1.setName(sysMenus.get(x).getUrl());
                        children1.setComponent(sysMenus.get(x).getUrl());
                        childrens1.add(children1);
                        NavData.Subs sub = new NavData.Subs();
                        sub.setTitle(sysMenus.get(x).getName());
                        sub.setIndex("/" + sysMenus.get(x).getUrl());
                        subs.add(sub);
                    }
                }
                navData1.setSubs(subs);
                navDatas.add(navData1);
            }
        }
        children.setChildren(childrens1);
        childrens.add(children);
        map.put("navDatas", navDatas);
        map.put("children", childrens);
        return map;
    }

    /**
     * 角色管理界面
     * 获取所有用户以及角色

    @Override
    public List<UserInfo> getUserList() {
        List<UserInfo> userInfos = new ArrayList<>();
        List<SysUser> users = sysUserMapper.selectAllUser();
        List<SysUserRole> userRoles = sysRoleMapper.selectAllInfo();
        List<SysRole> roles = sysRoleMapper.selectAllRole();
        for (int i = 0; i < users.size(); i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(users.get(i).getUserId());
            userInfo.setUsername(users.get(i).getUsername());
            userInfo.setRealName(users.get(i).getRealName());
            userInfo.setEmail(users.get(i).getEmail());
            userInfo.setMobile(users.get(i).getMobile());
            if (users.get(i).getStatus() == 1) {
                userInfo.setStatus("启用");
            } else {
                userInfo.setStatus("禁用");
            }
            List<String> roleName = new ArrayList<>();
            List<Long>  roleId = new ArrayList<>();
            for (int s = 0; s < userRoles.size(); s++) {
                if (userRoles.get(s).getUserId().equals(users.get(i).getUserId())) {
                    for (int x = 0; x < roles.size(); x++) {
                        if (roles.get(x).getRoleId() == userRoles.get(s).getRoleId().intValue()) {
                            roleName.add(roles.get(x).getRoleName());
                            roleId.add(roles.get(x).getRoleId());
                        }
                    }
                }
            }
            userInfo.setRoleName(String.join("，", roleName));
            userInfo.setRoleId(roleId);
            userInfos.add(userInfo);
        }
        return userInfos;
    }
     * */

    /**
     * 禁用用户账号
    @Override
    public void deleteUser(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setStatus((byte) 0);
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
     * */

    /**
     * 路由demo

    @Override
    public Map<String, List> routerDemo() {
        NavData navData = new NavData();
        navData.setIcon("/static/images/money.png");
        navData.setIndex("sales");
        NavData.Subs sub = new NavData.Subs();
        sub.setIndex("/menu1_item1");
        sub.setTitle("选项1");
        List<NavData.Subs> subs = new ArrayList<>();
        subs.add(sub);
        navData.setSubs(subs);
        navData.setTitle("菜单一");
        List<NavData> navDatas = new ArrayList<>();
        navDatas.add(navData);
        RouterData.Children children = new RouterData.Children();
        children.setComponent("menu1_item1");
        children.setName("menu1_item1");
        children.setPath("menu1_item1");
        List<RouterData.Children> childrens = new ArrayList<>();
        childrens.add(children);
        RouterData routerData = new RouterData();
        routerData.setChildren(childrens);
        routerData.setComponent("dashboard");
        routerData.setName("main");
        routerData.setPath("/");
        List<RouterData> routerDatas = new ArrayList<>();
        routerDatas.add(routerData);
        Map<String, List> map = new HashMap<>();
        map.put("navData", navDatas);
        map.put("routerData", routerDatas);
        return map;
    }
     * */
/*
    @Override
    public Integer register(SysUser sysUser) {
        // 按用户名获取salt值
        ByteSource salt = ByteSource.Util.bytes(sysUser.getUsername());
        // 获取加密后的密码
        String newPs = new SimpleHash("MD5", sysUser.getPassword(), salt.toHex(),1).toHex();
        sysUser.setCreateTime(new Date());
        sysUser.setStatus((byte) 1);
        sysUser.setPassword(newPs);
        sysUser.setSalt(salt.toHex());
        SysUser sysUser1 = sysUserMapper.selectByUserName(sysUser.getUsername());
        if (sysUser1 == null) {
            sysUserMapper.insertSelective(sysUser);
            Long userId = sysUserMapper.selectIdByUserName(sysUser.getUsername());
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId((long) 4);
            sysUserRoleMapper.insertSelective(sysUserRole);
            return 1;
        } else {
            return 0;
        }
    }
    */
/*
    @Override
    public Integer updateRole(UserInfo userInfo) {
        sysUserRoleMapper.deleteByUserId(userInfo.getUserId());
        List<Long> roleIds = userInfo.getRoleId();
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(userInfo.getUserId());
        for (int i = 0; i < roleIds.size(); i++) {
            sysUserRole.setRoleId(roleIds.get(i));
            sysUserRoleMapper.insertSelective(sysUserRole);
            System.out.println(sysUserRole);
        }
        return 1;
    }
    */
}

