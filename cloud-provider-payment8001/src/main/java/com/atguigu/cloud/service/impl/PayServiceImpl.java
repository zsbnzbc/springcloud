package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;


    @Override
    public int add(Pay pay) {
        // Implementation for adding a payment
        return payMapper.insertSelective(pay); // Placeholder return value
    }

    @Override
    public int detele(Integer id) {
        // Implementation for deleting a payment by ID
        return payMapper.deleteByPrimaryKey(id); // Placeholder return value
    }

    @Override
    public int update(Pay pay) {
        // Implementation for updating a payment
        return payMapper.updateByPrimaryKeySelective(pay); // Placeholder return value
    }

    @Override
    public Pay getById(Integer id) {
        // Implementation for getting a payment by ID
        return payMapper.selectByPrimaryKey(id); // Placeholder return value
    }

    @Override
    public List<Pay> getAll() {
        // Implementation for getting all payments
        return payMapper.selectAll(); // Placeholder return value
    }
}
