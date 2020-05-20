package com.example.service.impl;

import com.example.service.ResultTranslate;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.time.DateUtils;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ResultTranslateImpl implements ResultTranslate {

    @Override
    public String translateActive(Object value) {
        String result = null;
        if (!Objects.isNull(value)) {
            result = Objects.equals(value, (byte)1) ? "启用" : "禁用";
        }
        return result;
    }

    @Override
    public String translateStatus(byte value) {
        String result = null;
        if (!Objects.isNull(value)) {
            switch (value){
                case 1:
                    result = "已上架";
                    break;
                case -1:
                    result = "未上架";
                    break;
            }
        }
        return result;
    }

    @Override
    public String translateAuditStatus(byte value) {
        String result = null;
        if (!Objects.isNull(value)) {
            switch (value){
                case 0:
                    result = "待审核";
                    break;
                case 1:
                    result = "审核通过";
                    break;
                case -1:
                    result = "审核不通过";
                    break;
            }
        }
        return result;
    }

    @Override
    public String translateCancelStatus(byte value) {
        String result = null;
        if (!Objects.isNull(value)) {
            switch (value){
                case 0:
                    result = "正常";
                    break;
                case 1:
                    result = "待注销";
                    break;
                case -1:
                    result = "已注销";
                    break;
            }
        }
        return result;
    }

    @Override
    public String translatePassStatus(byte value) {
        String result = null;
        if (!Objects.isNull(value)) {
            switch (value){
                case 0:
                    result = "正常";
                    break;
                case 1:
                    result = "申请转送";
                    break;
                case -1:
                    result = "同意转送";
                    break;
            }
        }
        return result;
    }

    @Override
    public String translatePayStatus(byte value) {
        String result = null;
        if (!Objects.isNull(value)) {
            switch (value){
                case 1:
                    result = "已缴清";
                    break;
                case -1:
                    result = "未缴清";
                    break;
            }
        }
        return result;
    }

    @Override
    public String translateKeyStatus(byte value) {
        String result = null;
        if (!Objects.isNull(value)) {
            switch (value){
                case 1:
                    result = "已归还";
                    break;
                case -1:
                    result = "未归还";
                    break;
            }
        }
        return result;
    }
}
