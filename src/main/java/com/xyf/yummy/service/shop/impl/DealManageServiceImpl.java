package com.xyf.yummy.service.shop.impl;

import com.xyf.yummy.dao.DealMapper;
import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.service.shop.DealManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:23
 * @Package: com.xyf.yummy.service.shop.impl
 */
@Service(value = "dealManageService")
public class DealManageServiceImpl implements DealManageService {
    @Autowired
    private DealMapper dealMapper;
    @Override
    public boolean checkDistance(Address memberAddress, Address merchantAddress, int time) {
        return false;
    }

    @Override
    public boolean generateDeal(Deal deal) {
        return false;
    }

    @Override
    public boolean confirmDeal(int id) {
        return false;
    }

    @Override
    public boolean cancelDeal(int id) {
        return false;
    }

    @Override
    public boolean payDeal(int id) {
        return false;
    }

    @Override
    public boolean refundDeal(int id) {
        return false;
    }

    @Override
    public boolean completeDeal(int id) {
        return dealMapper.changeState(id, DealStateEnum.RECEIVED)==1;
    }
}
