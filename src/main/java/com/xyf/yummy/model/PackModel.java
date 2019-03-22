package com.xyf.yummy.model;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.entity.sub.DishInPack;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/11
 * @Time: 15:11
 * @Package: com.xyf.yummy.model
 */
public class PackModel {

    private String name;
    private double price;
    private Date deadline;
    private List<DishInPack> dishes;


    public Pack to_Pack(int mer_id){
        Pack pack = new Pack();
        pack.setMerId(mer_id);
        pack.setName(name);
        pack.setPrice(price);
        pack.setDeadline(deadline);
        pack.setDishes(dishes);
        return pack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public List<DishInPack> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishInPack> dishes) {
        this.dishes = dishes;
    }
}
