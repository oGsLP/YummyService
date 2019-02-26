package com.xyf.yummy.util;

import java.util.Random;
import java.util.UUID;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/26
 * @Time: 11:14
 * @Package: com.xyf.yummy.util
 */
public class UUIDGenerator {
    private static UUIDGenerator instance;
    private UUIDGenerator(){}
    public static UUIDGenerator getInstance(){
        if(instance==null)
            instance=new UUIDGenerator();
        return instance;
    }

    public String getUUID_number_16bits(){
        int first = new Random(10).nextInt(8) + 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return first + String.format("%015d", hashCodeV);
    }

    public String getUUID_str_16bits(){
        return UUID.randomUUID().toString().replace("-", "").substring(8,24);
    }
}
