package com.xyf.yummy.service.member;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:35
 * @Package: com.xyf.yummy.service.member
 */
public interface MemberLoginService {

    /**
     *
     * @param email
     * @param password
     * @return
     */
    boolean register(String email, String password);


    /**
     *
     * @param email
     * @return
     */
    String getKey(String email);

    /**
     *
     * @param email
     * @param password
     * @return
     */
    boolean login(String email, String password);

    /**
     *
     * @param email
     */
    void cancelAccount(String email);

}
