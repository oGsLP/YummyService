package com.xyf.yummy.model;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.sub.DealDish;
import com.xyf.yummy.entity.sub.DealPack;
import com.xyf.yummy.model.enums.DealStateEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/13
 * @Time: 20:45
 * @Package: com.xyf.yummy.model
 */
public class DealModel {

    private Address address;
    private List<DealDishModel> dishes;
    private List<DealPackModel> packs;
    private double sum;
    private double memberDiscount;
    private int merchantDiscount;
    private double total;
    private int limitTime;

    public Deal to_Deal(int memberId, int merchantId){
        Deal deal =new Deal();
        deal.setMemId(memberId);
        deal.setMerId(merchantId);
        deal.setAdId(this.address.getId());
        deal.setMemberAddress(this.address);
        List<DealDish> dealDishes = new ArrayList<>();
        List<DealPack> dealPacks = new ArrayList<>();
        if(this.dishes.size()!=0)
            for (DealDishModel dish : this.dishes) dealDishes.add(dish.to_DealDish());
        if(this.packs.size()!=0)
            for (DealPackModel pack : this.packs) dealPacks.add(pack.to_DealPack());
        deal.setDishes(dealDishes);
        deal.setPacks(dealPacks);
        deal.setOriginPrice(sum);
        deal.setMemDiscount(this.memberDiscount);
        deal.setMerDiscount(this.merchantDiscount);
        deal.setState(DealStateEnum.SET_UP);
        deal.setSetupTime(new Date());
        deal.setFinalPrice(total);
        deal.setLimitTime(limitTime);
        return deal;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<DealDishModel> getDishes() {
        return dishes;
    }

    public void setDishes(List<DealDishModel> dishes) {
        this.dishes = dishes;
    }

    public List<DealPackModel> getPacks() {
        return packs;
    }

    public void setPacks(List<DealPackModel> packs) {
        this.packs = packs;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(double memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public int getMerchantDiscount() {
        return merchantDiscount;
    }

    public void setMerchantDiscount(int merchantDiscount) {
        this.merchantDiscount = merchantDiscount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }
}
