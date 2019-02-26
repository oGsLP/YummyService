package com.xyf.yummy.service.merchant.impl;

import com.xyf.yummy.model.MerchantInfo;
import com.xyf.yummy.service.merchant.MerchantManageService;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:25
 * @Package: com.xyf.yummy.service.merchant.impl
 */
@Service(value = "merchantManageService")
public class MerchantManageServiceImpl implements MerchantManageService {
    @Override
    public String apply() {
        return null;
    }

    @Override
    public String login(String cdkey, String password) {
        return null;
    }

    @Override
    public boolean submitInfo(MerchantInfo info) {
        return false;
    }

    @Override
    public MerchantInfo getInfo(String cdkey) {
        return null;
    }
}
