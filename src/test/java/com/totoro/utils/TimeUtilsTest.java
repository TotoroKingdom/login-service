package com.totoro.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimeUtilsTest {

    @Test
    void todayResidue() {

        LocalTime now = LocalTime.now();

        LocalTime max = LocalTime.MAX;
        Duration duration = Duration.between(now, max);
        long l = duration.toMillis();
        System.out.println(l);
    }
}