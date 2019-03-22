package com.xyf.yummy.service.admin;

import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.enums.*;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:52
 * @Package: com.xyf.yummy.service
 */
public interface AdminDataGatherService {

    /**
     *
     * @param verEnum
     * @return
     */
    List<Merchant> getMerchantsByVertification(MerchantVerEnum verEnum);

    /**
     *
     * @param typeEnum
     * @return
     */
    List<Merchant> getMerchantsByType(MerchantTypeEnum typeEnum);

    /**
     *
     * @param valEnum
     * @return
     */
    List<Member> getMembersByValidation(MemValEnum valEnum);

    /**
     *
     * @param lvEnum
     * @return
     */
    List<Member> getMembersByLevel(MemLvEnum lvEnum);

    /**
     *
     * @param stateEnum
     * @return
     */
    List<Deal> getDealsByState(DealStateEnum stateEnum);

    /**
     *
     * @return
     */
    double getProfit();
}
