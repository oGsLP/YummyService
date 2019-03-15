package com.xyf.yummy.service.shop;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Deal;
import com.xyf.yummy.model.enums.DealStateEnum;

import java.util.List;

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
     * @return
     */
    List<Deal> getDeals();

    /**
     *
     * @param mem_id
     * @return
     */
    List<Deal> getMemberDeals(int mem_id);

    /**
     *
     * @param mem_id
     * @param state
     * @return
     */
    List<Deal> getMemberDeals(int mem_id, DealStateEnum state);

    /**
     *
     * @param mer_id
     * @return
     */
    List<Deal> getMerchantDeals(int mer_id);

    /**
     *
     * @param mer_id
     * @param state
     * @return
     */
    List<Deal> getMerchantDeals(int mer_id, DealStateEnum state);

    /**
     *
     * @param state
     * @return
     */
    List<Deal> getTypeDeals(DealStateEnum state);


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
