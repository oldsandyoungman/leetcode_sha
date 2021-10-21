package com.example.leetcode.daily.jian_zhi_offer_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s035 {

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        timePoints.add("00:00");
        System.out.println(findMinDifference(timePoints));

    }

//    给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

    public static int findMinDifference(List<String> timePoints) {

        int n = timePoints.size();
        int[] t = new int[n];

        for (int i = 0; i < timePoints.size(); i++) {
            int shi = Integer.parseInt(timePoints.get(i).substring(0,2));
            int fen = Integer.parseInt(timePoints.get(i).substring(3,5));
            int res = shi*60+fen;
            t[i] = res;
        }

        Arrays.sort(t);
        int min_sha = 24*60 + t[0] - t[n-1];
        for (int i = 1; i < n; i++) {
            int cur = t[i] - t[i-1];
            min_sha = Math.min(min_sha, cur);
        }

        return min_sha;

    }

}
