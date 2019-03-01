package com.xyf.yummy.service.admin;

import com.xyf.yummy.entity.MemberDiscount;
import com.xyf.yummy.model.MerchantInfo;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:52
 * @Package: com.xyf.yummy.service
 */
public interface AdminManageService {

    /**
     *
     * @return
     */
    double getRatio();

    /**
     *
     * @return
     */
    List<Double> getRatios();

    /**
     *
     * @param ratio
     */
    void modifyRatio(double ratio);

    /**
     *
     * @return
     */
    List<MemberDiscount> getMemberDiscounts();

    /**
     *
     * @param discounts
     */
    void modifyMemberDiscounts(List<MemberDiscount> discounts);

    /**
     *
     * @return
     */
    List<MerchantInfo> getApplies();

    /**
     *
     * @param mer_id
     */
    void failApply(int mer_id);

    /**
     *
     * @param mer_id
     */
    void passApply(int mer_id);
}
