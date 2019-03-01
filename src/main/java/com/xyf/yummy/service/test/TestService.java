package com.xyf.yummy.service.test;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.MemberDiscount;
import com.xyf.yummy.entity.Pack;
import com.xyf.yummy.model.MyResult;
import com.xyf.yummy.model.enums.MemValEnum;

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

    void addDish(Dish dish);

    Dish getDish(int dish_id);

    void addPack(Pack pack);

    void testPKBack(int id, Address address);

    String getSixCode();

    MemValEnum checkAccount(String email);

    Integer getIdByEmail(String email);

    void cancelMember(int id);

    List<MemberDiscount> getDiscounts();
}
