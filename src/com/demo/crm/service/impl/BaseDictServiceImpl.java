package com.demo.crm.service.impl;

import com.demo.crm.mapper.BaseDictMapper;
import com.demo.crm.pojo.BaseDict;
import com.demo.crm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> selectDictByTypeCode(String typecode) {
        return baseDictMapper.selectDictByTypeCode(typecode);
    }
}
