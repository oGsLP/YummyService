package com.xyf.yummy.model.enums;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 17:50
 * @Package: com.xyf.yummy.model.enums
 */
public enum DishTypeEnum {

    OTHER("other","其他"),
    STAPLE_FOOD("main","主食"),
    DIM_SUM("dessert","小吃"),
    BEVERAGE("drink","饮品"),
    ;

    private String str ;
    private String name ;

    DishTypeEnum(String str, String name) {
        this.str=str;
        this.name=name;
    }

    public static DishTypeEnum getTypByStr(String str){
        for(DishTypeEnum dishType : DishTypeEnum.values()){
            if(dishType.getStr().equals(str)){
                return dishType;
            }
        }
        return null;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String type) {
        this.str = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }}
