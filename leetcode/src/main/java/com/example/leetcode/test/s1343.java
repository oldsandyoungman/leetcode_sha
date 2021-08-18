package com.example.leetcode.test;

public class s1343 {
    public static void main(String[] args) {
        /*
         * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
         * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
         */

        int[] arr = new int[]{11,13,17,23,29,31,7,5,2,3};
        int k = 3, threshold = 5;

        int sum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if( i+k-1 <= arr.length-1){
                for (int i1 = 0; i1 < k; i1++) {
                    sum = sum + arr[i+i1];
                }
                if(sum >= threshold * k){
                    count++;
                }
                sum = 0;
            }
        }

        System.out.println(count);

    }
}
