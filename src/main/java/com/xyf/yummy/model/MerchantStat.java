package com.xyf.yummy.model;

import com.xyf.yummy.entity.Member;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/21
 * @Time: 20:11
 * @Package: com.xyf.yummy.model
 */
public class MerchantStat {
    private double total;
    private double refund;
    private double complete;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getRefund() {
        return refund;
    }

    public void setRefund(double refund) {
        this.refund = refund;
    }

    public double getComplete() {
        return complete;
    }

    public void setComplete(double complete) {
        this.complete = complete;
    }

}
