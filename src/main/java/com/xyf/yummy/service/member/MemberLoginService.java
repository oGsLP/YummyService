package com.xyf.yummy.service.member;

import com.xyf.yummy.entity.Member;
import com.xyf.yummy.model.MemberLog;

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
     * @param log
     * @return
     */
    boolean register(MemberLog log);


    /**
     *
     * @param email
     * @return
     */
    void getKey(String email);

    /**
     *
     * @param log
     * @return
     */
    Member login(MemberLog log);

    /**
     *
     * @param id
     */
    void cancelAccount(Integer id);

}
