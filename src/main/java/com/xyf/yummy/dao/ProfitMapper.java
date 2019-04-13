package com.xyf.yummy.dao;

import com.xyf.yummy.entity.Profit;

import java.util.List;

public interface ProfitMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(Profit record);

    int insertSelective(Profit record);

    Profit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Profit record);

    int updateByPrimaryKey(Profit record);

    Profit getCurrentProfit();

    List<Profit> getProfits();
}