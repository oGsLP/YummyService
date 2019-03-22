package com.xyf.yummy.service.admin.impl;

import com.xyf.yummy.dao.DealMapper;
import com.xyf.yummy.dao.MemberMapper;
import com.xyf.yummy.dao.MerchantDiscountMapper;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.MerchantDiscount;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.service.admin.MemberDataGatherService;
import com.xyf.yummy.service.admin.MerchantDataGatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:22
 * @Package: com.xyf.yummy.service.admin.impl
 */
@Service(value = "merchantDataGatherService")
public class MerchantDataGatherServiceImpl implements MerchantDataGatherService {

    @Autowired
    private MerchantDiscountMapper discountMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private DealMapper dealMapper;

    @Override
    public double getRefund(int merchantId) {
        return dealMapper.getRefund(merchantId, DealStateEnum.REFUNDED);
    }

    @Override
    public double getComplete(int merchantId) {
        return dealMapper.getComplete(merchantId,DealStateEnum.RECEIVED);
    }

    @Override
    public double getTotal(int merchantId) {
        return dealMapper.getTotal(merchantId,DealStateEnum.RECEIVED);
    }

    @Override
    public List<Member> getMostUsually(int merchantId) {
        return memberMapper.getMostUsuallyMembers(merchantId);
    }

    @Override
    public MerchantDiscount getDiscount(int merchantId) {
        return discountMapper.getDiscountByMerchantId(merchantId);
    }

    @Override
    public void setDiscount(MerchantDiscount discount) {
        discountMapper.updateByPrimaryKeySelective(discount);
    }
}
