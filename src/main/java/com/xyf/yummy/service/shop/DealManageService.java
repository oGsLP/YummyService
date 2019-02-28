package com.xyf.yummy.service.shop;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Deal;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:52
 * @Package: com.xyf.yummy.service.shop
 */
public interface DealManageService {


    /**
     *
     * @param memberAddress
     * @param merchantAddress
     * @param time
     * @return
     */
    boolean checkDistance(Address memberAddress, Address merchantAddress, int time);

    /**
     *
     * @param deal
     * @return
     */
    boolean generateDeal(Deal deal);//to modify

    /**
     *
     * @param id
     * @return
     */
    boolean confirmDeal(int id);

    /**
     *
     * @param id
     * @return
     */
    boolean cancelDeal(int id);

    /**
     *
     * @param id
     * @return
     */
    boolean payDeal(int id);

    /**
     *
     * @param id
     * @return
     */
    boolean refundDeal(int id);

    /**
     *
     * @param id
     * @return
     */
    boolean completeDeal(int id);

}
