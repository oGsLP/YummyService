package com.xyf.yummy.service;

import com.xyf.yummy.entity.TestUser;
import com.xyf.yummy.model.MyResult;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:23
 * @Package: com.xyf.yummy.service
 */
public interface TestService {
    MyResult login(TestUser user);
}
