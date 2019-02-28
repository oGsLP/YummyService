package com.xyf.yummy.service.shop.impl;

import com.xyf.yummy.dao.DishMapper;
import com.xyf.yummy.dao.MerchantMapper;
import com.xyf.yummy.dao.PackMapper;
import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.service.shop.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:24
 * @Package: com.xyf.yummy.service.shop.impl
 */
@Service(value = "shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private MerchantMapper merchantMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private PackMapper packMapper;

    @Override
    public List<Merchant> getMerchants() {
        return merchantMapper.getAllMerchants();
    }

    @Override
    public List<Dish> getCurrentDishes(int mer_id) {
        return dishMapper.getCurrentDishes(new Date(), mer_id);
    }

    @Override
    public List<Pack> getCurrentPacks(int mer_id) {
        return packMapper.getCurrentPacks(new Date(), mer_id);
    }
}
