package com.example.leetcode.test;

import java.util.Arrays;

public class s611 {
    public static void main(String[] args) {
        int[] a = new int[]{2,2,3,4};
        System.out.println(triangleNumber(a));

    }

//    给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

    public static int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int res = 0;

        for(int i=nums.length-1;i>=2;i--){
            int m = 0;
            int n = i-1;
            while (m<n){
                if (nums[m]+nums[n]>nums[i]) {
                    res += n-m;
                    n--;
                }else {
                    m++;
                }
            }
        }





        return res;
    }
}
