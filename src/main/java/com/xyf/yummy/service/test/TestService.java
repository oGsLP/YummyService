package com.xyf.yummy.service.test;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.model.MyResult;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:23
 * @Package: com.xyf.yummy.service
 */
public interface TestService {
    MyResult login();

    List<Address> getAddress(int id);
}
