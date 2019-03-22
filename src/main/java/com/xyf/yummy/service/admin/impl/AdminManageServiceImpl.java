package com.xyf.yummy.service.admin.impl;

import com.xyf.yummy.dao.MemberDiscountMapper;
import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.dao.ProfitMapper;
import com.xyf.yummy.entity.MemberDiscount;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.entity.Profit;
import com.xyf.yummy.model.AdminCode;
import com.xyf.yummy.model.ApplyModel;
import com.xyf.yummy.model.MerchantInfo;
import com.xyf.yummy.model.enums.MerchantVerEnum;
import com.xyf.yummy.service.admin.AdminManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private ProfitMapper profitMapper;

    @Autowired
    private MemberDiscountMapper memberDiscountMapper;

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public boolean login(AdminCode code) {
        return code.getCodeA().equals("1234") && code.getCodeB().equals("abcd")
                && code.getCodeC().equals("1234") && code.getCodeD().equals("abcd")
                && code.getPassword().equals("123456");
    }

    @Override
    public double getProfit() {
        return profitMapper.getCurrentProfit().getRatio();
    }

    @Override
    public List<Profit> getProfits() {
        return profitMapper.getProfits();
    }

    @Override
    public void modifyProfit(double ratio) {
        Profit profit = new Profit();
        profit.setEffectDate(new Date());
        profit.setRatio(ratio);
        profitMapper.insertSelective(profit);
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
    public List<ApplyModel> getApplies() {
        List<Merchant> merchants = merchantMapper.getMerchantOfOneVertification(MerchantVerEnum.BEFORE_APPROVAL);
        List<ApplyModel> applies = new ArrayList<>();
        for(Merchant merchant: merchants){
            ApplyModel apply = new ApplyModel();
            apply.setName(merchant.getName());
            apply.setAddress(merchant.getAddress());
            apply.setType(merchant.getType());
            apply.setVerEnum(merchant.getVertification());
            apply.setMerId(merchant.getId());
            apply.setCdkey(merchant.getCdkey());
            applies.add(apply);
        }
        return applies;
    }

    @Override
    public void failApply(int mer_id) {
        merchantMapper.changeVertification(mer_id, MerchantVerEnum.GET_DISAPPROVAL);
    }

    @Override
    public void passApply(int mer_id) {
        merchantMapper.changeVertification(mer_id, MerchantVerEnum.AFTER_VERTIFICATION);
    }
}
