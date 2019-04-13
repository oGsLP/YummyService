package com.xyf.yummy.dao;

import com.xyf.yummy.entity.MemberDiscount;

import java.util.List;

public interface MemberDiscountMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(MemberDiscount record);

    int insertSelective(MemberDiscount record);

    MemberDiscount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberDiscount record);

    int updateByPrimaryKey(MemberDiscount record);

    /**
     * 获得所有用户优惠政策
     * @return
     */
    List<MemberDiscount> getDiscounts();
}