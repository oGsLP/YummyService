package com.xyf.yummy;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.model.enums.DishTypeEnum;
import com.xyf.yummy.service.test.TestService;
import com.xyf.yummy.util.CDKeyGenerator;
import com.xyf.yummy.util.PasswordEncryption;
import com.xyf.yummy.util.UUIDGenerator;
import com.xyf.yummy.util.VertificationCodeGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YummyApplicationTests {

    @Autowired
    TestService testService;


    @Test
    public void contextLoads() {

        System.out.println(testService.getAddress(1).size());

        System.out.println(VertificationCodeGenerator.getInstance().getVertificationCode());

        System.out.println(new Date());

        System.out.println(testService.getDish(1).getDeadline());

        Address address=new Address();
        address.setLatitude(5.5);
        address.setLongitude(8.8);
        address.setNote("dasd");
        testService.testPKBack(1,address);
    }

}
