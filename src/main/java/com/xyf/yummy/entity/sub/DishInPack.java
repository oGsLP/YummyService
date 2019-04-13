package com.xyf.yummy.entity.sub;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xyf.yummy.entity.Dish;

import java.io.Serializable;

@JsonIgnoreProperties(value = {"handler"})
public class DishInPack implements Serializable {

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