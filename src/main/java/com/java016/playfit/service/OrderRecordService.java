package com.java016.playfit.service;

import com.java016.playfit.model.OrderRecord;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface OrderRecordService {

    OrderRecord saveOrderRecord(Map<String, Object> paramsMap, Integer userId);

    void page();

    Long findCountByUserId();

    Page<OrderRecord> findCurrentPage(Map<String, String> paramsMap);
}
