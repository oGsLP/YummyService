package com.xyf.yummy.dao;

import com.xyf.yummy.entity.MerchantDiscount;

public interface MerchantDiscountMapper {

    //
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantDiscount record);

    int insertSelective(MerchantDiscount record);

    MerchantDiscount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantDiscount record);

    int updateByPrimaryKey(MerchantDiscount record);

    /**
     *
     * @param mer_id
     * @return
     */
    MerchantDiscount getDiscountByMerchantId(Integer mer_id);
}