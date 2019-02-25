package com.xyf.yummy.service.member.impl;

import com.xyf.yummy.service.member.MemberLoginService;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:37
 * @Package: com.xyf.yummy.service.member.impl
 */

@Service(value = "memberLoginService")
public class MemberLoginServiceImpl implements MemberLoginService {
    @Override
    public boolean register(String email, String password) {
        return false;
    }

    @Override
    public boolean checkKey(String email, String key) {
        return false;
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public void cancelAccount(String email) {

    }
}
