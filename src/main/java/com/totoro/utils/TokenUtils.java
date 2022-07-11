package com.totoro.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-03 23:09
 */
public class TokenUtils {

     public static String getToken(){
         String token = RandomStringUtils.randomAlphanumeric(18);
         return token;
     }

    public static String getRegisterCode(){
        String token = RandomStringUtils.randomNumeric(6);
        return token;
    }
}
