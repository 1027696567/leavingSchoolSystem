package com.example.service.impl;

import com.example.service.ResultTranslate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ResultTranslateImpl implements ResultTranslate {

    @Override
    public String translateActive(Object value) {
        String result = null;
        if (!Objects.isNull(value)) {
            result = Objects.equals(value, 1) ? "启用" : "禁用";
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
}
