package com.totoro.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-03 23:09
 */
public class TokenUtil {

     public static String getToken(){
         String token = RandomStringUtils.random(10);
         return token;
     }
}
