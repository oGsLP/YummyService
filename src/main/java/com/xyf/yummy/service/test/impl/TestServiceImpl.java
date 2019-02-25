package com.xyf.yummy.service.test.impl;

import com.xyf.yummy.dao.AddressMapper;
import com.xyf.yummy.dao.MemberMapper;
import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.model.MyResult;
import com.xyf.yummy.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public MyResult login() {
//        System.out.println();
//        List<TestUser> list=new ArrayList<>();
//        TestUser testUser=userDao.selectByPrimaryKey(2);
        MyResult result=new MyResult();
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
}
