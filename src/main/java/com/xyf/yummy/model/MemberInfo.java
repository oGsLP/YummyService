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

    private String phone;
    private String name;

    public MemberInfo() {
    }

    public MemberInfo(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public MemberInfo(Member member){
        this.phone=member.getPhone();
        this.name=member.getName();
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
