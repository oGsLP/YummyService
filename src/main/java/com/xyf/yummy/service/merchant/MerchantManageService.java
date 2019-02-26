package com.xyf.yummy.service.merchant;

import com.xyf.yummy.entity.Merchant;
import com.xyf.yummy.model.MerchantInfo;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:51
 * @Package: com.xyf.yummy.service
 */
public interface MerchantManageService {

    /**
     *
     * @return
     */
    String apply();

    /**
     *
     * @param cdkey
     * @param password
     * @return
     */
    String login(String cdkey,String password);

    /**
     *
     * @param info
     * @return
     */
    boolean submitInfo(MerchantInfo info);

    /**
     *
     * @param cdkey
     * @return
     */
    MerchantInfo getInfo(String cdkey);


}
