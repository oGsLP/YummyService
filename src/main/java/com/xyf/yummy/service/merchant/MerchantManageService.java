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
    boolean register(String cdkey, String password);

    /**
     *
     * @param cdkey
     * @param password
     * @return
     */
    Merchant login(String cdkey,String password);

    /**
     *
     * @param mer_id
     * @param info
     * @return
     */
    boolean submitInfo(int mer_id, MerchantInfo info);

    /**
     *
     * @param mer_id
     * @return
     */
    MerchantInfo getInfo(int mer_id);


}
