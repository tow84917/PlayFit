package com.java016.playfit.service;

import com.java016.playfit.model.OrderRecord;

import java.util.Map;

public interface OrderRecordService {

    OrderRecord saveOrderRecord(Map<String, Object> paramsMap, Integer userId);

    void page();

    Long findCountByUserId();
}
