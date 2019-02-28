package com.xyf.yummy.service.shop;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.entity.Pack;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:52
 * @Package: com.xyf.yummy.service.shop
 */
public interface ShopService {

    /**
     *
     * @return
     */
    List<Merchant> getMerchants();

    /**
     *
     * @param mer_id
     * @return
     */
    List<Dish> getCurrentDishes(int mer_id);

    /**
     *
     * @param mer_id
     * @return
     */
    List<Pack> getCurrentPacks(int mer_id);

}
