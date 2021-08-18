package com.example.leetcode.test;

import java.util.Arrays;
import java.util.OptionalInt;

public class s453 {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(minMoves(a));
    }

//    给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。


    public static int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            if (num<min) {
                min = num;
            }
        }
        return sum-nums.length*min;
    }
}
