package com.xyf.yummy.service.admin.impl;

import com.xyf.yummy.dao.DealMapper;
import com.xyf.yummy.dao.MemberMapper;
import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.enums.*;
import com.xyf.yummy.service.admin.AdminDataGatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:54
 * @Package: com.xyf.yummy.service.shop.impl
 */
@Service(value = "adminDataGatherService")
public class AdminDataGatherServiceImpl implements AdminDataGatherService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private DealMapper dealMapper;

    @Override
    public List<Merchant> getMerchantsByVertification(MerchantVerEnum verEnum) {
        return merchantMapper.getMerchantOfOneVertification(verEnum);
    }

    @Override
    public List<Merchant> getMerchantsByType(MerchantTypeEnum typeEnum) {
        return merchantMapper.getMerchantOfOneType(typeEnum);
    }

    @Override
    public List<Member> getMembersByValidation(MemValEnum valEnum) {
        return memberMapper.getMemberOfOneValidation(valEnum);
    }

    @Override
    public List<Member> getMembersByLevel(MemLvEnum lvEnum) {
        return memberMapper.getMemberOfOneLevel(lvEnum);
    }

    @Override
    public List<Deal> getDealsByState(DealStateEnum stateEnum) {
        return dealMapper.getDealsByState(stateEnum);
    }

    @Override
    public double getProfit() {
        return dealMapper.getProfit(DealStateEnum.RECEIVED);
    }
}
