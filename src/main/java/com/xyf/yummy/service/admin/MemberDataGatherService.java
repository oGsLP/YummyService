package com.xyf.yummy.service.admin;

import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.entity.MemberConsumption;
import com.xyf.yummy.entity.Merchant;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:53
 * @Package: com.xyf.yummy.service
 */
public interface MemberDataGatherService {

    /**
     *
     * @param memberId
     * @return
     */
    MemberConsumption getConsumption(int memberId);

    /**
     *
     * @param memberId
     * @return
     */
    List<Merchant> getMostUsually(int memberId);
}
