package com.example.leetcode.test;

public class s53 {

    public static void main(String[] args) {
        int[] a = {-3,4,-1,2,-6,1,4};
        System.out.println(maxSubArray(a));
    }

//    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

//    public static int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
//        }
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < dp.length; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }

}
