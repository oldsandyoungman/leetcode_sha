package com.example.leetcode.test;

import java.util.Arrays;

public class s1561 {
    public static void main(String[] args) {
//        int[] a = {2,4,1,2,7,8};
//        int[] a = {2,4,5};
        int[] a = {9,8,7,6,5,1,2,3,4};

        System.out.println(maxCoins(a));

    }

//    有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
//
//    每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
//    Alice 将会取走硬币数量最多的那一堆。
//    你将会取走硬币数量第二多的那一堆。
//    Bob 将会取走最后一堆。
//    重复这个过程，直到没有更多硬币。
//    给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
//
//    返回你可以获得的最大硬币数目。
//


    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int sum = 0;

        int total = piles.length;
        int total_3 = total/3;

        for (int i = total_3; i < total; i=i+2) {
            sum += piles[i];
        }

        return sum;

    }

}
