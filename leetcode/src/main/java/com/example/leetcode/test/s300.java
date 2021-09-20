package com.example.leetcode.test;

import java.util.Arrays;

public class s300 {

    public static void main(String[] args) {
        int[] s = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(s));
    }

//    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//    子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // dp table法
    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

//        // 自己写的版本，反而耗时更短
//        dp[0] = 1;
//        for (int i = 0; i < n; i++) {
//            int res = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[j]<nums[i]) {
//                    res = Math.max(res, dp[j]);
//                }
//            }
//            dp[i] = res + 1;
//        }

        // 耗时更长一点
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int res_max = 0;
        for (int i = 0; i < n; i++) {
            res_max = Math.max(res_max, dp[i]);
        }

        return res_max;

    }

    // patience game纸牌游戏法
    public static int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] tops = new int[n];
//        int piles = -1;
//
//        for (int i = 0; i < n; i++) {
//            int target = nums[i];
//            int left = 0;
//            int right = piles;
//            while (left<=right){
//                int mid = left + (right - left)/2;
////                if (tops[mid] < target) {
////                    left = mid + 1;
////                } else if (tops[mid] > target) {
////                    right = mid - 1;
////                }else {
////                    right = mid - 1;
////                }
//                if (tops[mid] < target) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//            if ( left>piles) {
//                piles++;
//            }
//            tops[left] = target;
//        }
//
//        return piles+1;

        int n = nums.length;
        int[] tops = new int[n];
        int piles = 0;

        for (int target : nums) {
            int left = 0;
            int right = piles - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (tops[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left >= piles) {
                tops[left] = target;
                piles++;
            } else {
                tops[left] = target;
            }

        }

        return piles;

    }



}
