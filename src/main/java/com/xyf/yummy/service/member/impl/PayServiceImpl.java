package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.dao.MemberPaymentMapper;
import com.xyf.yummy.entity.MemberPayment;
import com.xyf.yummy.service.member.PayService;
import com.xyf.yummy.util.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean pay(int pay_id, double price) {
        if(paymentMapper.getBalance(pay_id)>=price)
            return paymentMapper.updateBalance(pay_id, price)==1;
        else return false;
    }

    @Override
    public boolean refund(int pay_id, double price) {
        return paymentMapper.updateBalance(pay_id,price*-1)==1;
    }
}
