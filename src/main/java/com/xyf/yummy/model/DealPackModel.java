package com.xyf.yummy.model;

import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.entity.sub.DealPack;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/15
 * @Time: 13:59
 * @Package: com.xyf.yummy.model
 */
public class DealPackModel extends Pack {
    private int num;

    public DealPack to_DealPack(){
        DealPack dealPack =new DealPack();
        dealPack.setNum(this.num);
        Pack pack =new Pack();
        pack.setId(this.getId());
        pack.setDeadline(this.getDeadline());
        pack.setDishes(this.getDishes());
        pack.setMerId(this.getMerId());
        pack.setName(this.getName());
        pack.setPrice(this.getPrice());
        dealPack.setPack(pack);
        return dealPack;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
