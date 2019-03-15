package com.xyf.yummy.service.admin;

import com.xyf.yummy.entity.MemberDiscount;
import com.xyf.yummy.entity.Profit;
import com.xyf.yummy.model.AdminCode;
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
     * @param code
     * @return
     */
    boolean login(AdminCode code);

    /**
     *
     * @return
     */
    double getProfit();

    /**
     *
     * @return
     */
    List<Profit> getProfits();

    /**
     *
     * @param ratio
     */
    void modifyProfit(double ratio);

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
