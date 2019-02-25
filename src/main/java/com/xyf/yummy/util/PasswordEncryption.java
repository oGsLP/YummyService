package com.xyf.yummy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/2/25
 * @Time: 23:18
 * @Package: com.xyf.yummy.util
 */
public class PasswordEncryption {
    private static PasswordEncryption encryption;
    private PasswordEncryption(){}

    public static PasswordEncryption getEncryption(){
        if(encryption==null)
            encryption=new PasswordEncryption();
        return encryption;
    }

    private String encrypt_md5_32bits(String password){
        String result="";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuilder buffer = new StringBuilder("");
            for (byte b1 : b) {
                i = b1;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buffer.append("0");
                buffer.append(Integer.toHexString(i));
            }
            result = buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String encrypt_md5_16bits(String password){
        return encrypt_md5_32bits(password).substring(8,24);
    }
}
