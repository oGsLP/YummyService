package com.xyf.yummy.service.admin;

import com.xyf.yummy.entity.Deal;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:53
 * @Package: com.xyf.yummy.service
 */
public interface MemberDataGatherService {

    List<Deal> getDeals(int mem_id);

}
