package com.wangcai.dao;

import com.wangcai.model.Lable;

public interface LableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lable record);

    int insertSelective(Lable record);

    Lable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lable record);

    int updateByPrimaryKey(Lable record);
}