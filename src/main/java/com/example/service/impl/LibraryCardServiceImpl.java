package com.example.service.impl;

import com.example.mapper.*;
import com.example.model.*;
import com.example.service.LibraryCardService;
import com.example.service.ResultTranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class LibraryCardServiceImpl implements LibraryCardService {
    @Autowired
    private LibraryCardMapper libraryCardMapper;
    @Autowired
    private ResultTranslate resultTranslate;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private LibraryCardAuditResMapper libraryCardAuditResMapper;
    @Override
    public List<LibraryCardInfo> findByUsername(String username) {
        List<LibraryCardInfo> libraryCardInfos = libraryCardMapper.selectByUsername(username);
        if (libraryCardInfos.size()>0){
            libraryCardInfos.forEach(libraryCardInfo -> {
                libraryCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(libraryCardInfo.getStatus()));
                libraryCardInfo.setTranslateIssueDate(DateFormat.getDateInstance().format(libraryCardInfo.getIssueDate()));
                //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
                if (!Objects.isNull(libraryCardInfo.getLibraryCardAuditResStatus())) {
                    libraryCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(libraryCardInfo.getLibraryCardAuditResStatus()));
                }
            });

            return libraryCardInfos;
        } else {
            return null;
        }
    }

    @Override
    public Result updateLibraryCardStatus(LibraryCard libraryCard) {
        libraryCard.setCancelDate(new Date());
        if (libraryCardMapper.updateByPrimaryKeySelective(libraryCard) == 1){
            if (!Objects.isNull(libraryCard.getCreateUser())&&Objects.isNull(libraryCardAuditResMapper.selectByLibraryCardId(libraryCard.getId()))) {
                LibraryCardAuditRes libraryCardAuditRes = new LibraryCardAuditRes();
                libraryCardAuditRes.setStuInfoId(libraryCard.getStuInfoId());
                libraryCardAuditRes.setLibraryCardId(libraryCard.getId());
                libraryCardAuditRes.setStatus((byte) 0);
                libraryCardAuditResMapper.insertSelective(libraryCardAuditRes);
            }
            return Result.success();
        } else {
            return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
        }
    }

    @Override
    public List<LibraryCardInfo> findByCondition(Byte status, Long stuId, Long classId, Byte libraryCardAuditResStatus) {
        List<LibraryCardInfo> libraryCardInfos = libraryCardMapper.selectByCondition(status,stuId,classId,libraryCardAuditResStatus);
        libraryCardInfos.forEach(libraryCardInfo -> {
            libraryCardInfo.setCancelStatus(resultTranslate.translateCancelStatus(libraryCardInfo.getStatus()));
            libraryCardInfo.setTranslateIssueDate(DateFormat.getDateInstance().format(libraryCardInfo.getIssueDate()));
            //stuCardInfo.setTranslateReissueDate(DateFormat.getDateInstance().format(stuCardInfo.getReissueDate()));
            if (!Objects.isNull(libraryCardInfo.getLibraryCardAuditResStatus())) {
                libraryCardInfo.setAuditStatusName(resultTranslate.translateAuditStatus(libraryCardInfo.getLibraryCardAuditResStatus()));
            }
        });
        return libraryCardInfos;
    }

    @Override
    public Result updateLibraryCardAuditRes(LibraryCardAuditRes libraryCardAuditRes) {
        libraryCardAuditRes.setCreateTime(new Date());
        if (libraryCardAuditResMapper.updateByPrimaryKeySelective(libraryCardAuditRes) == 1) {
            return Result.success();
        } else {
            libraryCardAuditRes.setCreateTime(new Date());
            libraryCardAuditResMapper.insertSelective(libraryCardAuditRes);
            return Result.success();
        }
    }

}
