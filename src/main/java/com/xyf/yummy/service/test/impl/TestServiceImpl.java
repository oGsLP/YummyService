package com.xyf.yummy.service.test.impl;

import com.xyf.yummy.dao.*;
import com.xyf.yummy.entity.*;
import com.xyf.yummy.model.ModelBean;
import com.xyf.yummy.model.enums.DealStateEnum;
import com.xyf.yummy.model.enums.MemValEnum;
import com.xyf.yummy.service.test.TestService;
import com.xyf.yummy.util.VertificationCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:23
 * @Package: com.xyf.yummy.service.shop.impl
 */
@Service(value = "testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private PackMapper packMapper;
    @Autowired
    private MemberDiscountMapper memberDiscountMapper;
    @Autowired
    private DealMapper dealMapper;
    @Autowired
    private MerchantMapper merchantMapper;
    @Override
    public ModelBean login() {
//        System.out.println();
//        List<TestUser> list=new ArrayList<>();
//        TestUser testUser=userDao.selectByPrimaryKey(2);
        ModelBean result=new ModelBean();
//        if(testUser.getUsername().equals(user.getUsername())){
//            result.setCode(0);
//            result.setMsg("login success");
//            result.setList(list);
//            result.setObject(testUser);
//        }
//        else {
//            result.setCode(1);
//            result.setMsg("login failed");
//        }
        Member member = memberMapper.selectByPrimaryKey(1);
        result.setCode(0);
        result.setMsg("connected");
        result.setList(null);
        result.setObject(member);
        return result;
    }

    @Override
    public List<Address> getAddress(int id) {
        return addressMapper.findAddressesByMemberId(1);
    }

    @Override
    public void addDish(Dish dish) {
        dishMapper.insert(dish);
    }

    @Override
    public Dish getDish(int dish_id) {
        return dishMapper.selectByPrimaryKey(dish_id);
    }

    @Override
    public void addPack(Pack pack) {
        packMapper.insert(pack);
    }

    @Override
    public void testPKBack(int id, Address address) {
        if(address.getId()!=null)
            System.out.println("Not null");
        else System.out.println("null");
        addressMapper.insertSelective(address);
        System.out.println(address.getId());
        addressMapper.addMemberAddress(id, address.getId());
    }

    @Override
    public String getSixCode() {
        return VertificationCodeGenerator.getInstance().getVertificationCode();
    }

    @Override
    public MemValEnum checkAccount(String email) {
        return memberMapper.checkAccount(email);
    }

    @Override
    public Integer getIdByEmail(String email) {
        return memberMapper.getIdByEmail(email);
    }

    @Override
    public void cancelMember(int id) {
        memberMapper.cancelAccount(id,MemValEnum.CANCELLED);
    }

    @Override
    public List<MemberDiscount> getDiscounts() {
        return memberDiscountMapper.getDiscounts();
    }

    @Override
    public List<Dish> getDishesByTime(Date date, int id) {
        return dishMapper.getCurrentDishes(date,id);
    }

    @Override
    public Pack getPack(int pack_id) {
        return packMapper.selectByPrimaryKey(pack_id);
    }

    @Override
    public Deal getDealByState(DealStateEnum stateEnum) {
        return dealMapper.getDealsByState(stateEnum).get(0);
    }

    @Override
    public List<Merchant> getUsu(int mem_id) {
        return merchantMapper.getMostUsuallyMerchants(mem_id);
    }


}
