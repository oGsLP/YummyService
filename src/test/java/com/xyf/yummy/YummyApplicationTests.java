package com.xyf.yummy;

import com.xyf.yummy.service.test.TestService;
import com.xyf.yummy.util.CDKeyGenerator;
import com.xyf.yummy.util.PasswordEncryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YummyApplicationTests {

    @Autowired
    TestService testService;
    @Test
    public void contextLoads() {

        System.out.println(testService.getAddress(1).size());

    }

}
