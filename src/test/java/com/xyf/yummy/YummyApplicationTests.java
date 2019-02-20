package com.xyf.yummy;

import com.xyf.yummy.entity.Member;
import com.xyf.yummy.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YummyApplicationTests {

    @Autowired
    TestService testService;
    @Test
    public void contextLoads() {
        Member member = (Member)testService.login(null).getObject();
        System.out.println(member.getLevel().getName());
        System.out.println(member.getValidation().getName());
    }

}
