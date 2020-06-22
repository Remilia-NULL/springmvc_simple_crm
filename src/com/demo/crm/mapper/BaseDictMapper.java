package com.demo.crm.mapper;

import com.demo.crm.pojo.BaseDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDictMapper {
    public List<BaseDict> selectDictByTypeCode(@Param("typecode")String typecode);
}
