package com.xyf.yummy.service.admin.impl;

import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.service.admin.MemberDataGatherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:21
 * @Package: com.xyf.yummy.service.admin.impl
 */
@Service(value = "memberDataGatherService")
public class MemberDataGatherServiceImpl implements MemberDataGatherService {
    @Override
    public List<Deal> getDeals(int mem_id) {
        return null;
    }
}
