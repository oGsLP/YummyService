package com.xyf.yummy.service.admin.impl;

import com.xyf.yummy.dao.DealMapper;
import com.xyf.yummy.dao.MemberConsumptionMapper;
import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.MemberConsumption;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.service.admin.MemberDataGatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:21
 * @Package: com.xyf.yummy.service.admin.impl
 */
@Service(value = "memberDataGatherService")
public class MemberDataGatherServiceImpl implements MemberDataGatherService {

    @Autowired
    private MemberConsumptionMapper consumptionMapper;
    @Autowired
    private MerchantMapper merchantMapper;
    @Override
    public MemberConsumption getConsumption(int memberId) {
        return consumptionMapper.getConsumptionByMemberId(memberId);
    }

    @Override
    public List<Merchant> getMostUsually(int memberId) {
        return merchantMapper.getMostUsuallyMerchants(memberId);
    }
}
