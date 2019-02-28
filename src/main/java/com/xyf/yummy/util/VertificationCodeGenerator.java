package com.xyf.yummy.util;

import java.util.Random;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/27
 * @Time: 17:42
 * @Package: com.xyf.yummy.util
 */
public class VertificationCodeGenerator {
    private static VertificationCodeGenerator generator;
    private VertificationCodeGenerator(){}
    public static VertificationCodeGenerator getInstance(){
        if(generator==null)
            generator=new VertificationCodeGenerator();
        return generator;
    }

    public String getVertificationCode(){
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }

    public void sendCode(String email,String code){
        //
    }
}
