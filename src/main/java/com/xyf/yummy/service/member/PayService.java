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
     * @param account
     * @param password
     * @return
     */
    boolean addPayment(String account, String password);

    /**
     *
     * @param account
     * @param password
     * @return
     */
    boolean checkPayment(String account, String password);

    /**
     *
     * @param price
     * @return
     */
    boolean pay(double price);

    /**
     *
     * @param price
     * @return
     */
    boolean refund(double price);

}
