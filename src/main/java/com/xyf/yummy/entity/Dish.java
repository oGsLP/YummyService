package com.xyf.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xyf.yummy.model.enums.DishTypeEnum;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"handler"})
public class Dish implements Serializable {
    private Integer id;

    private Integer merId;

    private String name;

    private Double price;

    private Integer supply;

    private DishTypeEnum kind;

    private Date deadline;

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

    public Integer getSupply() {
        return supply;
    }

    public void setSupply(Integer supply) {
        this.supply = supply;
    }

    public DishTypeEnum getKind() {
        return kind;
    }

    public void setKind(DishTypeEnum kind) {
        this.kind = kind;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}