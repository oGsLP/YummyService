package com.xyf.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xyf.yummy.model.enums.MerchantTypeEnum;
import com.xyf.yummy.model.enums.MerchantVerEnum;

import java.io.Serializable;
@JsonIgnoreProperties(value = {"handler"})
public class Merchant implements Serializable {
    private Integer id;

    private String cdkey;

    private String name;

    private MerchantTypeEnum type;

    private String password;

    private Integer adId;

    private MerchantDiscount discount;

    private Address address;

    private MerchantVerEnum vertification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCdkey() {
        return cdkey;
    }

    public void setCdkey(String cdkey) {
        this.cdkey = cdkey == null ? null : cdkey.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public MerchantTypeEnum getType() {
        return type;
    }

    public void setType(MerchantTypeEnum type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public MerchantDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(MerchantDiscount discount) {
        this.discount = discount;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MerchantVerEnum getVertification() {
        return vertification;
    }

    public void setVertification(MerchantVerEnum vertification) {
        this.vertification = vertification;
    }
}