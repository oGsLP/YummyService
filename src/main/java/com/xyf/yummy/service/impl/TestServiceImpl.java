package com.xyf.yummy.service.impl;

import com.xyf.yummy.dao.MemberMapper;
import com.xyf.yummy.dao.TestUserMapper;
import com.xyf.yummy.entity.Member;
import com.xyf.yummy.entity.TestUser;
import com.xyf.yummy.model.MyResult;
import com.xyf.yummy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/20
 * @Time: 16:23
 * @Package: com.xyf.yummy.service.impl
 */
@Service(value = "testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestUserMapper userDao;
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public MyResult login(TestUser user) {
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
}
