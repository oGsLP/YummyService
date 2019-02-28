package com.xyf.yummy.service.member;

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
     * @param pay_id
     * @param price
     * @return
     */
    boolean pay(int pay_id, double price);


    /**
     *
     * @param pay_id
     * @param price
     * @return
     */
    boolean refund(int pay_id, double price);

}
