package com.xyf.yummy.service.member;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/3/20
 * @Time: 22:37
 * @Package: com.xyf.yummy.service.member
 */
public interface MailService {
    void sendCode(String email, String code);
}
