package com.xyf.yummy.model.enums;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:53
 * @Package: com.xyf.yummy.model.enums
 */
public enum MemLvEnum {
    BRONZE(1 , "青铜"),
    SILVER(2 , "白银"),
    GOLD(3 , "黄金"),
    PLATINUM(4 , "铂金"),
    DIAMOND(5 , "钻石");

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

    MemLvEnum(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static MemLvEnum getLvById(int id){
        for (MemLvEnum lv : MemLvEnum.values()){
            if(lv.getId() == id){
                return lv;
            }
        }
        return null;
    }
}
