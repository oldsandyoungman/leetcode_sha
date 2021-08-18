package com.example.leetcode.test;

import java.lang.Math;

public class s1344 {
    //    给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
    public static void main(String[] args) {
        System.out.println(angleClock(1,57));
    }

    public static double angleClock(int hour, int minutes) {

        double m = 360 * minutes / 60.0;

        if (hour==12){
            hour = 0;
        }

        double h1 = hour * 360 / 12.0;

        double h2 = m / 12.0;
        double h = h1 + h2;

        double x = Math.abs(h - m);

        if (x >180){
            x = 360 - x;
        }

        return x;

    }
}

