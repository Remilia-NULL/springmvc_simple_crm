package com.demo.crm.service;

import com.demo.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict> selectDictByTypeCode(String typecode);
}
