package com.xyf.yummy.entity.sub;

import com.xyf.yummy.entity.Dish;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/26
 * @Time: 15:35
 * @Package: com.xyf.yummy.entity.sub
 */
public class DealDish {
    private Dish dish;
    private Integer num;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
