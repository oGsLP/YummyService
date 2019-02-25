package com.xyf.yummy.util;

import com.mysql.jdbc.Buffer;

import java.io.*;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 16:57
 * @Package: com.xyf.yummy.util
 */
public class CDKeyGenerator {
    private static volatile CDKeyGenerator instance;
    private static final String cdkeyCounterPath="src/main/java/com/xyf/yummy/util/store/cdkeyCounter";

    // 私有化构造函数
    private CDKeyGenerator() {}

    // 双重检查锁
    public static CDKeyGenerator getInstance() {
        if (instance == null) {
            synchronized(CDKeyGenerator.class){
                if(instance == null){
                    instance = new CDKeyGenerator();
                }
            }
        }
        return instance;
    }

    private int getCounter(){
        int counter = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(cdkeyCounterPath));
            counter = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

    private void counterAdd(int counter){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(cdkeyCounterPath));
            writer.write(""+counter);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String generate()  {
        // Y-a0001
        int counter=getCounter();
        String cdkey=String.format("%04d", counter%10000);
        if((counter/10000)>=1)
            return null;
        else {
            counterAdd(counter+1);
            return "y19"+cdkey;
        }

    }
}
