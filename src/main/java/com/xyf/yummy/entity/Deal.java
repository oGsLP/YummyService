package com.xyf.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xyf.yummy.entity.sub.DealDish;
import com.xyf.yummy.entity.sub.DealPack;
import com.xyf.yummy.model.enums.DealStateEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"handler"})
public class Deal implements Serializable {
    private Integer id;

    private Integer memId;

    private Integer merId;

    private Integer adId;

    private Address memberAddress;

    private Double originPrice;

    private Double memDiscount;

    private Integer merDiscount;

    private Double finalPrice;

    private Double profit;

    private Double actualBenefit;

    private DealStateEnum state;

    private Double refund;

    private Integer limitTime;

    private Date setupTime;

    private List<DealDish> dishes;

    private List<DealPack> packs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getMerId() {
        return merId;
    }

    public void setMerId(Integer merId) {
        this.merId = merId;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Address getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(Address memberAddress) {
        this.memberAddress = memberAddress;
    }

    public Double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Double originPrice) {
        this.originPrice = originPrice;
    }

    public Double getMemDiscount() {
        return memDiscount;
    }

    public void setMemDiscount(Double memDiscount) {
        this.memDiscount = memDiscount;
    }

    public Integer getMerDiscount() {
        return merDiscount;
    }

    public void setMerDiscount(Integer merDiscount) {
        this.merDiscount = merDiscount;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getActualBenefit() {
        return actualBenefit;
    }

    public void setActualBenefit(Double actualBenefit) {
        this.actualBenefit = actualBenefit;
    }

    public DealStateEnum getState() {
        return state;
    }

    public void setState(DealStateEnum state) {
        this.state = state;
    }

    public Double getRefund() {
        return refund;
    }

    public void setRefund(Double refund) {
        this.refund = refund;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    public Date getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(Date setupTime) {
        this.setupTime = setupTime;
    }

    public List<DealDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<DealDish> dishes) {
        this.dishes = dishes;
    }

    public List<DealPack> getPacks() {
        return packs;
    }

    public void setPacks(List<DealPack> packs) {
        this.packs = packs;
    }
}