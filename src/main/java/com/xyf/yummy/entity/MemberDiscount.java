package com.xyf.yummy.entity;

import com.xyf.yummy.model.enums.MemLvEnum;

import java.io.Serializable;

public class MemberDiscount implements Serializable {
    private Integer id;

    private MemLvEnum level;

    private Double min;

    private Double discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemLvEnum getLevel() {
        return level;
    }

    public void setLevel(MemLvEnum level) {
        this.level = level;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}