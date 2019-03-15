package com.xyf.yummy.model.enums;

import com.xyf.yummy.entity.Deal;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 17:50
 * @Package: com.xyf.yummy.model.enums
 */
public enum DealStateEnum {

    SET_UP(1,"已创建"),
    CANCELLED(2,"已取消"),
    ACCOUNT_PAID(3,"已付款"),
    REFUNDED(4,"已退款"),
    RECEIVED(5,"已收货")

    ;

    DealStateEnum(int id, String name){
        this.id=id;
        this.name=name;
    }

    public static DealStateEnum getJsonEnum(String state){
        DealStateEnum result = null;
        for(DealStateEnum stateEnum: DealStateEnum.values())
            if(stateEnum.toString().equals(state))
                result=stateEnum;
        return result;
    }

    public static DealStateEnum getStateById(int id){
        for(DealStateEnum dealState : DealStateEnum.values()){
            if(dealState.getId()==id){
                return dealState;
            }
        }
        return null;
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
