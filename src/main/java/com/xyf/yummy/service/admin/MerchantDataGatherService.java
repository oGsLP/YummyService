package com.xyf.yummy.service.admin;

import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.MerchantDiscount;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:53
 * @Package: com.xyf.yummy.service
 */
public interface MerchantDataGatherService {

    /**
     *
     * @param merchantId
     * @return
     */
    double getRefund(int merchantId);

    /**
     *
     * @param merchantId
     * @return
     */
    double getComplete(int merchantId);

    /**
     *
     * @param merchantId
     * @return
     */
    double getTotal(int merchantId);

    /**
     *
     * @param merchantId
     * @return
     */
    List<Member> getMostUsually(int merchantId);

    /**
     *
     * @param merchantId
     * @return
     */
    MerchantDiscount getDiscount(int merchantId);

    /**
     *
     * @param discount
     */
    void setDiscount(MerchantDiscount discount);

}
