package com.example.service;

public interface ResultTranslate {

    String translateActive(Object value);

    String translateStatus(byte value);

    String translateAuditStatus(byte value);
}
