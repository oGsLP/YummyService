package com.xyf.yummy.service.test;

import com.xyf.yummy.entity.*;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.model.enums.MemValEnum;

import java.util.Date;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:23
 * @Package: com.xyf.yummy.service
 */
public interface TestService {
    ModelBean login();

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

    List<Dish> getDishesByTime(Date date, int id);

    Pack getPack(int pack_id);

    Deal getDealByState(DealStateEnum stateEnum);

}
