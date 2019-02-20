package com.xyf.yummy.model.enums;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 18:03
 * @Package: com.xyf.yummy.model.enums
 */
public enum MemValEnum {
    REGISTERED(1 , "生效中"),
    CANCELLED(0 , "已注销");

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

    MemValEnum(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static MemValEnum getValById(int id){
        for(MemValEnum val : MemValEnum.values()){
            if(val.getId() == id){
                return val;
            }
        }
        return null;
    }
}
