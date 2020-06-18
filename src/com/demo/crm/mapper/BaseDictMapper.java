package com.demo.crm.mapper;

import com.demo.crm.pojo.BaseDict;
import org.apache.ibatis.annotations.Param;

public interface BaseDictMapper {
    public BaseDict selectDictByTypeCode(@Param("typecode")String typecode);
}
