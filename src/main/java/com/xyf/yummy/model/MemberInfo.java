package com.xyf.yummy.model;

import com.xyf.yummy.entity.Member;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:42
 * @Package: com.xyf.yummy.model
 */
public class MemberInfo {
    private int id;
    private String email;
    private String phone;
    private String name;

    public MemberInfo() {
    }

    public MemberInfo(int id, String email, String phone, String name) {
        this.id=id;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public MemberInfo(Member member){
        this.id=member.getId();
        this.email=member.getEmail();
        this.phone=member.getPhone();
        this.name=member.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
