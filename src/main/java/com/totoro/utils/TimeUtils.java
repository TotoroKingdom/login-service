package com.totoro.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-09 21:50
 */
public class TimeUtils {

    /**
     * 计算几天剩余多少秒
     */
    public static Integer todayResidue(){
        LocalTime now = LocalTime.now();
        LocalTime max = LocalTime.MAX;
        Duration duration = Duration.between(now, max);
        long millis = duration.toMillis();
        int result = (int) millis;
        return result;
    }
}
