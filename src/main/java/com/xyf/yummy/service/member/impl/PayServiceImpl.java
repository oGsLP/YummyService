package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.service.member.PayService;
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
    @Override
    public boolean addPayment(String account, String password) {
        return false;
    }

    @Override
    public boolean checkPayment(String account, String password) {
        return false;
    }

    @Override
    public boolean pay(double price) {
        return false;
    }

    @Override
    public boolean refund(double price) {
        return false;
    }
}
