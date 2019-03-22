package com.xyf.yummy.service.member;

import com.xyf.yummy.entity.MemberPayment;
import com.xyf.yummy.model.enums.MemLvEnum;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 15:50
 * @Package: com.xyf.yummy.service.member
 */
public interface PayService {

    /**
     *
     * @param mem_id
     * @return
     */
    MemberPayment getPayment(int mem_id);

    /**
     *
     * @param mem_id
     * @param account
     * @param password
     * @return
     */
    boolean addPayment(int mem_id, String account, String password);


    /**
     *
     * @param mem_id
     * @param account
     * @param password
     * @return
     */
    boolean checkPayment(int mem_id, String account, String password);


    /**
     *
     * @param mem_id
     * @param deal_id
     * @return
     */
    boolean pay(int mem_id, int deal_id);


    /**
     *
     * @param mem_id
     * @param deal_id
     * @return
     */
    boolean refund(int mem_id, int deal_id);

    /**
     *
     * @param id
     * @return
     */
    double getDiscountById(int id);


    MemLvEnum getLevelById(int id);

}
