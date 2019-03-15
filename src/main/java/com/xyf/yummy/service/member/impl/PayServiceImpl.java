package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.dao.*;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.MemberDiscount;
import com.xyf.yummy.entity.MemberPayment;
import com.xyf.yummy.model.enums.MemLvEnum;
import com.xyf.yummy.service.member.PayService;
import com.xyf.yummy.util.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:24
 * @Package: com.xyf.yummy.service.member.impl
 */
@Service(value = "payService")
public class PayServiceImpl implements PayService {
    private PasswordEncryption encryption = PasswordEncryption.getEncryption();
    @Autowired
    private MemberPaymentMapper paymentMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberConsumptionMapper consumptionMapper;
    @Autowired
    private MemberDiscountMapper discountMapper;
    @Autowired
    private DealMapper dealMapper;

    @Override
    public MemberPayment getPayment(int mem_id) {
        return paymentMapper.findPaymentByMemberId(mem_id);
    }

    @Override
    public boolean addPayment(int mem_id, String account, String password) {
        MemberPayment payment = new MemberPayment();
        payment.setAccount(account);payment.setMemId(mem_id);payment.setPassword(encryption.encrypt_md5_16bits(password));
        return paymentMapper.insertSelective(payment)==1;
    }

    @Override
    public boolean checkPayment(int mem_id, String account, String password) {
        return paymentMapper.checkAccount(mem_id,account,encryption.encrypt_md5_16bits(password))!=null;
    }

    @Override
    public boolean pay(int mem_id, int deal_id) {
        return this.payByPayId(paymentMapper.findPaymentByMemberId(mem_id).getId(),dealMapper.selectByPrimaryKey(deal_id).getFinalPrice());
    }

    @Override
    public boolean refund(int mem_id, int deal_id) {
        return this.refundByPayId(paymentMapper.findPaymentByMemberId(mem_id).getId(),dealMapper.selectByPrimaryKey(deal_id).getFinalPrice());
    }


    private boolean payByPayId(int pay_id, double price) {
        if(paymentMapper.getBalance(pay_id)>=price)
            return paymentMapper.updateBalance(pay_id, price)==1&&refreshLevel(pay_id);
        else return false;
    }


    private boolean refundByPayId(int pay_id, double price) {
        return paymentMapper.updateBalance(pay_id,price*-1)==1&&refreshLevel(pay_id);
    }

    private boolean refreshLevel(int pay_id) {
        List<MemberDiscount> discounts = discountMapper.getDiscounts();
        MemberPayment payment = paymentMapper.selectByPrimaryKey(pay_id);
        Member member = memberMapper.selectByPrimaryKey(payment.getMemId());
        double consumption = consumptionMapper.getConsumptionByMemberId(member.getId()).getSum();
        MemLvEnum lvEnum = MemLvEnum.BRONZE;
        for(MemberDiscount discount: discounts){
            if(discount.getMin()<=consumption)
                lvEnum=discount.getLevel();
        }
        if(member.getLevel()!=lvEnum){
            member.setLevel(lvEnum);
            memberMapper.updateByPrimaryKeySelective(member);
        }
        return true;
    }
}
