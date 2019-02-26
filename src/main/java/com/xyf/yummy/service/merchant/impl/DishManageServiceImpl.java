package com.xyf.yummy.service.merchant.impl;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.service.merchant.DishManageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:25
 * @Package: com.xyf.yummy.service.merchant.impl
 */
@Service(value = "dishManageService")
public class DishManageServiceImpl implements DishManageService {
    @Override
    public List<Dish> getDishes(int mer_id) {
        return null;
    }

    @Override
    public boolean addDish(Dish dish) {
        return false;
    }

    @Override
    public boolean modifyDish(Dish dish) {
        return false;
    }

    @Override
    public boolean deleteDish(int dish_id) {
        return false;
    }

    @Override
    public List<Pack> getPacks(int mer_id) {
        return null;
    }

    @Override
    public boolean addPack(Pack pack) {
        return false;
    }

    @Override
    public boolean modifyPack(Pack pack) {
        return false;
    }

    @Override
    public boolean deletePack(int pack_id) {
        return false;
    }
}
