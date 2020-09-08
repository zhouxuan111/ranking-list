package com.zx.util;

import java.util.Date;

/**
 * @author zhouxuan
 * @date 2020/8/12 10:28
 */
public class ScoreUtil {

    /**
     * 活动结束时间
     */
    private static Date end = new Date(1599576261563L);

    public static double getScore(Integer score, Date start) {

        System.out.println(end);

        long time = end.getTime() - start.getTime();

        String s = score + "." + time;

        return Double.valueOf(s);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
