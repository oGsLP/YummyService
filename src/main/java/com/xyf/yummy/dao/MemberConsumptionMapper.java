package com.xyf.yummy.dao;

import com.xyf.yummy.entity.MemberConsumption;

public interface MemberConsumptionMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(MemberConsumption record);

    int insertSelective(MemberConsumption record);

    MemberConsumption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberConsumption record);

    int updateByPrimaryKey(MemberConsumption record);

    /**
     *
     * @param mem_id
     * @return
     */
    MemberConsumption getConsumptionByMemberId(Integer mem_id);
}