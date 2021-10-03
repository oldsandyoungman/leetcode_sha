package com.example.leetcode.test;

import java.util.Arrays;

public class s698 {

    public static void main(String[] args) {
//        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int[] nums = new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
//        int k = 4;
        int k = 5;


        System.out.println(canPartitionKSubsets(nums, k));
    }

//    给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

    // 每个数来选择桶
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] nums_r = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums_r[i] = nums[n-1-i];
            sum += nums[i];
        }
        if (sum%k!=0) {
            return false;
        }
        int target = sum/k;
        int[] buckets = new int[k];
        return backtrack(nums_r, 0, k, target, buckets);

    }

    public static boolean backtrack(int[] nums, int start, int k, int target, int[] buckets){
        if (start == nums.length) {
            for (int i = 0; i < k; i++) {
                if (buckets[i]!=target){
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (buckets[i] + nums[start] > target){
                continue;
            }
            buckets[i] += nums[start];
            boolean flag = backtrack(nums, start+1, k, target, buckets);
            if (flag) {
                return true;
            }
            buckets[i] -= nums[start];
        }

        return false;
    }


}
