package com.xyf.yummy.model;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.sub.DealDish;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/15
 * @Time: 13:59
 * @Package: com.xyf.yummy.model
 */
public class DealDishModel extends Dish {
    private int num;

    public DealDish to_DealDish(){
        DealDish dealDish = new DealDish();
        dealDish.setNum(this.num);
        Dish dish = new Dish();
        dish.setId(this.getId());
        dish.setKind(this.getKind());
        dish.setDeadline(this.getDeadline());
        dish.setSupply(this.getSupply());
        dish.setMerId(this.getMerId());
        dish.setPrice(this.getPrice());
        dish.setName(this.getName());
        dealDish.setDish(dish);
        return dealDish;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
