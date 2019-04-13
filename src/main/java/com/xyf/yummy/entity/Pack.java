package com.xyf.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xyf.yummy.entity.sub.DishInPack;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(value = {"handler"})
public class Pack implements Serializable {
    private Integer id;

    private Integer merId;

    private String name;

    private Double price;

    private Date deadline;

    private List<DishInPack> dishes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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