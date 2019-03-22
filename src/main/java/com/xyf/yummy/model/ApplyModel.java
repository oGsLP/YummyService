package com.xyf.yummy.model;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/19
 * @Time: 14:37
 * @Package: com.xyf.yummy.model
 */
public class ApplyModel extends MerchantInfo {
    private int MerId;
    private String cdkey;

    public int getMerId() {
        return MerId;
    }

    public void setMerId(int merId) {
        MerId = merId;
    }

    public String getCdkey() {
        return cdkey;
    }

    public void setCdkey(String cdkey) {
        this.cdkey = cdkey;
    }
}
