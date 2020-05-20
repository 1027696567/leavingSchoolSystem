package com.example.service.impl;

import com.example.mapper.SysUserMapper;
import com.example.model.SysUser;
import com.example.service.ResultTranslate;
import com.example.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Override
    public List<SysUser> findAllUser() {
        List<SysUser> sysUsers = sysUserMapper.selectAllUser();
        sysUsers.forEach(sysUser -> {
            sysUser.setActiveName(resultTranslate.translateActive(sysUser.getStatus()));
        });
        return sysUsers;
    }
}
