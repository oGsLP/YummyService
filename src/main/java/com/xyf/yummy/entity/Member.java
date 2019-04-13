package com.xyf.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xyf.yummy.model.enums.MemLvEnum;
import com.xyf.yummy.model.enums.MemValEnum;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(value = {"handler"})
public class Member implements Serializable {
    private Integer id;

    private String email;

    private String password;

    private String phone;

    private String name;

    private MemLvEnum level;

    private List<Address> addresses = null ;

    private MemValEnum validation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public MemLvEnum getLevel() {
        return level;
    }

    public void setLevel(MemLvEnum level) {
        this.level = level;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public MemValEnum getValidation() {
        return validation;
    }

    public void setValidation(MemValEnum validation) {
        this.validation = validation;
    }
}