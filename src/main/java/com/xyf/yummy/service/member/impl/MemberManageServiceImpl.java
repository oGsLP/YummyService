package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.model.MemberInfo;
import com.xyf.yummy.service.member.MemberManageService;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:23
 * @Package: com.xyf.yummy.service.member.impl
 */
@Service(value = "memberManageService")
public class MemberManageServiceImpl implements MemberManageService {
    @Override
    public MemberInfo getInfo() {
        return null;
    }

    @Override
    public boolean modifyInfo(MemberInfo info) {
        return false;
    }

    @Override
    public boolean addAddress(Address address) {
        return false;
    }

    @Override
    public boolean deleteAddress(int id) {
        return false;
    }

    @Override
    public boolean modifyAddress(Address address) {
        return false;
    }
}
