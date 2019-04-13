package com.xyf.yummy.entity;

import java.io.Serializable;
import java.util.Date;

public class Profit implements Serializable {
    private Integer id;

    private Double ratio;

    private Date effectDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }
}