package com.deng.wj.untils;

import java.util.Random;

public class StringUtils {
    public static String getRandomString(int length){
        String base="abcdefghijklmnopqrstuvwxyz123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<length;i++){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
