package com.xyf.yummy.model.enums;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 17:44
 * @Package: com.xyf.yummy.model.enums
 */
public enum MerchantTypeEnum {
    FAST_FOOD("snack","快餐"),
    HOME_COOKING("home","家常菜"),
    PASTRY_SHOP("cake","糕点小吃"),
    CONVENIENCE_SHOP("cvs","便利店"),
    GARDEN_STUFF("fav","水果蔬菜"),
    OTHER("other","其他")
    ;

    private String str;
    private String name;

    MerchantTypeEnum(String str, String name) {
        this.str=str;
        this.name=name;
    }

    public static MerchantTypeEnum getTypByStr(String str){
        for(MerchantTypeEnum merchantType : MerchantTypeEnum.values()){
            if(merchantType.str.equals(str)){
                return merchantType;
            }
        }
        return null;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
