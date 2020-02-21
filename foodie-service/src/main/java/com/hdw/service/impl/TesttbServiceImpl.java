package com.hdw.service.impl;

import com.hdw.mapper.TesttbMapper;
import com.hdw.pojo.Testtb;
import com.hdw.service.TesttbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesttbServiceImpl implements TesttbService {

    @Autowired
    private TesttbMapper testtbMapper;
    @Override
    public Testtb getTesttbById(int id) {
        return testtbMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveTesttb(Testtb testtb) {
        testtbMapper.insert(testtb);
    }
}
