package com.xyf.yummy.entity.sub;

import com.xyf.yummy.entity.Pack;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/26
 * @Time: 15:35
 * @Package: com.xyf.yummy.entity.sub
 */
public class DealPack {
    private Pack pack;
    private Integer num;

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
