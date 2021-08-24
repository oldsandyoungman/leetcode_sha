package com.example.leetcode.test;

import java.util.Arrays;

public class s416 {

    public static void main(String[] args) {

        int[] nums = {1,5,10,6};
//        System.out.println(canPartition2(nums));
        System.out.println(canPartition(nums));

    }

//    给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



    public static boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2==1) {
            return false;
        }
        int goal = sum/2;
        boolean[][] dp = new boolean[n+1][goal+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }
//        for (int i = 1; i < goal+1; i++) {
//            dp[0][i] = false;
//        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < goal+1; j++) {
                if (nums[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][goal];

    }


    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2==1) {
            return false;
        }
        int goal = sum/2;
//        boolean[][] dp = new boolean[n+1][goal+1];
//
//        for (int i = 0; i < n+1; i++) {
//            dp[i][0] = true;
//        }
//        for (int i = 1; i < goal+1; i++) {
//            dp[0][i] = false;
//        }

//        for (int i = 1; i < n+1; i++) {
//            for (int j = 1; j < goal+1; j++) {
//                if (nums[i-1]>j) {
//                    dp[i][j] = false;
//                }else {
//                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
//                }
//            }
//        }

        boolean[] dp = new boolean[goal+1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = goal; j > 0; j--) {
                if (nums[i-1]<=j) {
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                }
            }
        }




        return dp[goal];


    }


}
