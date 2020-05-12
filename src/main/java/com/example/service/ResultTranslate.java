package com.example.service;

import java.util.List;

public interface ResultTranslate {

    String translateActive(Object value);

    String translateStatus(byte value);

    String translateAuditStatus(byte value);

    String translateCancelStatus(byte value);
}
