package com.xyf.yummy.model;

import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.model.enums.DishTypeEnum;

import java.util.Date;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/11
 * @Time: 14:47
 * @Package: com.xyf.yummy.model
 */
public class DishModel {
    private String name;
    private double price;
    private int supply;
    private String type;
    private Date deadline;

    public DishModel(String name, double price, int supply, String type, Date deadline) {
        this.name = name;
        this.price = price;
        this.supply = supply;
        this.type = type;
        this.deadline = deadline;
    }

    public Dish to_Dish(int mer_id){
        Dish dish = new Dish();
        dish.setMerId(mer_id);
        dish.setName(this.name);
        dish.setPrice(this.price);
        dish.setSupply(this.supply);
        dish.setDeadline(this.deadline);
        for(DishTypeEnum typeEnum: DishTypeEnum.values()){
            if(typeEnum.toString().equals(this.type)){
                dish.setKind(typeEnum);
                break;
            }
        }
        return dish;
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

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
