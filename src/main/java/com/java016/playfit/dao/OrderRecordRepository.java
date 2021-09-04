package com.java016.playfit.dao;

import com.java016.playfit.model.OrderRecord;
import com.java016.playfit.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRecordRepository extends JpaRepository<OrderRecord, Integer> {

    @Override
    List<OrderRecord> findAllById(Iterable<Integer> integers);

    @Override
    Page<OrderRecord> findAll(Pageable pageable);

    Page<OrderRecord> findAllByUserId(User user, Pageable pageable);

    List<OrderRecord> findAllByTradeAmt(Integer integer);

    Long countByUserId(User loginUser);
}
