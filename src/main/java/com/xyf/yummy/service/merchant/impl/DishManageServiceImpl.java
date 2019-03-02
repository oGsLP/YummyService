package com.xyf.yummy.service.merchant.impl;

import com.xyf.yummy.dao.DishMapper;
import com.xyf.yummy.dao.PackMapper;
import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.entity.sub.DishInPack;
import com.xyf.yummy.service.merchant.DishManageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private PackMapper packMapper;

    @Override
    public List<Dish> getDishes(int mer_id) {
        return dishMapper.getDishes(mer_id);
    }

    @Override
    public boolean addDish(Dish dish) {
        return dishMapper.insertSelective(dish)==1;
    }

    @Override
    public boolean modifyDish(Dish dish) {
        return dishMapper.updateByPrimaryKeySelective(dish)==1;
    }

    @Override
    public boolean deleteDish(int dish_id) {
        return dishMapper.deleteByPrimaryKey(dish_id)==1;
    }

    @Override
    public List<Pack> getPacks(int mer_id) {
        return packMapper.getPacks(mer_id);
    }

    @Override
    public boolean addPack(Pack pack) {
        int sign = packMapper.insertSelective(pack);
        if(sign==1){
            for (DishInPack dish: pack.getDishes()
                 ) {
                sign*=packMapper.addDishPack(pack.getId(),dish.getDish().getId(),dish.getNum());
            }
        }
        return sign==1;
    }
    // ....
    @Override
    public boolean modifyPack(Pack pack) {
        int sign = packMapper.updateByPrimaryKey(pack);
        sign*=packMapper.deleteDishPack(pack.getId());
        if(sign>0){
            for (DishInPack dish: pack.getDishes()
            ) {
                sign*=packMapper.addDishPack(pack.getId(),dish.getDish().getId(),dish.getNum());
            }
        }
        return sign==1;
    }

    @Override
    public boolean deletePack(int pack_id) {
        return packMapper.deleteDishPack(pack_id)>0&&packMapper.deleteByPrimaryKey(pack_id)==1;
    }

}
