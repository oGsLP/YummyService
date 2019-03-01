package com.xyf.yummy.service.admin.impl;

import com.xyf.yummy.dao.MemberDiscountMapper;
import com.xyf.yummy.entity.MemberDiscount;
import com.xyf.yummy.model.MerchantInfo;
import com.xyf.yummy.service.admin.AdminManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:59
 * @Package: com.xyf.yummy.service.admin.impl
 */
@Service(value = "adminManageService")
public class AdminManageServiceImpl implements AdminManageService {

    @Autowired
    private MemberDiscountMapper memberDiscountMapper;

    @Override
    public double getRatio() {
        return 0;
    }

    @Override
    public List<Double> getRatios() {
        return null;
    }

    @Override
    public void modifyRatio(double ratio) {

    }

    @Override
    public List<MemberDiscount> getMemberDiscounts() {
        return memberDiscountMapper.getDiscounts();
    }

    @Override
    public void modifyMemberDiscounts(List<MemberDiscount> discounts) {
        for(MemberDiscount discount: discounts){
            memberDiscountMapper.updateByPrimaryKeySelective(discount);
        }
    }

    @Override
    public List<MerchantInfo> getApplies() {
        return null;
    }

    @Override
    public void failApply(int mer_id) {

    }

    @Override
    public void passApply(int mer_id) {

    }
}
