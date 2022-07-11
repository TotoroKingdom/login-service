package com.totoro.utils;

import cn.hutool.core.lang.UUID;
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
         return UUID.randomUUID().toString().replaceAll("-","");
    }
}
