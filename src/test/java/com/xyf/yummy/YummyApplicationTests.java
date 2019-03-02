package com.xyf.yummy;

import com.xyf.yummy.entity.Address;
import com.xyf.yummy.entity.Dish;
import com.xyf.yummy.entity.MemberDiscount;
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


        System.out.println(PasswordEncryption.getEncryption().encrypt_md5_16bits("123312"));

        System.out.println(testService.checkAccount("1144313@qwer.com")==null?"null":"not null");

        System.out.println(testService.getIdByEmail("11443213@qwer.com"));

        for(MemberDiscount memberDiscount:testService.getDiscounts()){
            System.out.println(memberDiscount.getLevel().getName()+"||"+memberDiscount.getMin()+"||"+memberDiscount.getDiscount());
        }

        System.out.println(testService.getDishesByTime(new Date(),1).size());
        System.out.println(testService.getDishesByTime(new Date(System.currentTimeMillis() + 60 * 60 * 1000),1).size());

        System.out.println(testService.getPack(1).getDishes().size());
        System.out.println(testService.getPack(1).getDishes().get(1).getDish().getName());
    }

}
