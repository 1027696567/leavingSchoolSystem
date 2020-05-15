package com.example.service;

import java.util.Date;
import java.util.List;

public interface ResultTranslate {

    String translateActive(Object value);

    String translateStatus(byte value);

    String translateAuditStatus(byte value);

    String translateCancelStatus(byte value);
    /**
     * 组织部转送状态
     * */
    String translatePassStatus(byte value);
}
