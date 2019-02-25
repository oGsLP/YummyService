package com.xyf.yummy.model.enums;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 17:49
 * @Package: com.xyf.yummy.model.enums
 */
public enum MerchantVerEnum {

    JUST_REGISTERED(1,"已申请"),
    BEFORE_APPROVAL(2,"待认证"),
    GET_DISAPPROVAL(3,"认证未通过"),
    AFTER_VERTIFICATION(4,"营业中")
    ;


    MerchantVerEnum(int id, String name){
        this.id=id;
        this.name=name;
    }

    public static MerchantVerEnum getVerById(int id){
        for(MerchantVerEnum merchantVer : MerchantVerEnum.values()){
            if(merchantVer.getId()==id){
                return merchantVer;
            }
        }
        return null;
    }

    private int id ;
    private String name ;

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
    }}
