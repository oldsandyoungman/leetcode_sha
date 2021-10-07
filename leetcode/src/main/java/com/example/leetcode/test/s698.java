package com.example.leetcode.test;

import java.util.Arrays;

public class s698 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
//        int[] nums = new int[]{3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};
        int k = 4;
//        int k = 5;


        System.out.println(canPartitionKSubsets(nums, k));
        System.out.println(canPartitionKSubsets2(nums, k));
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

    // 每个桶来选择数
    public static boolean canPartitionKSubsets2(int[] nums, int k) {
        int n = nums.length;
        if (k>n) {
            return false;
        }

        // 下面两种方法时间上没啥区别

//        // 排序减少回溯的个数
//        Arrays.sort(nums);
//        int[] nums_r = new int[n];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            nums_r[i] = nums[n-1-i];
//            sum += nums[i];
//        }
//        if (sum%k!=0) {
//            return false;
//        }
//        int target = sum/k;
//        int[] buckets = new int[k];
//        boolean[] used = new boolean[n];
//        return backtrack2(k, 0, nums_r, 0, used, target);


//        //正常操作
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%k!=0) {
            return false;
        }
        int target = sum/k;
        int[] buckets = new int[k];
        boolean[] used = new boolean[n];

        return backtrack2(k, 0, nums, 0, used, target);




    }

    public static boolean backtrack2(int k, int bucket, int[] nums, int start, boolean[] used, int target){
        if (k==0) {
            return true;
        }

        if (bucket==target) {
            return backtrack2(k-1, 0, nums, 0, used, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (bucket+nums[i]>target) {
                continue;
            }

            bucket += nums[i];
            used[i] = true;

            if (backtrack2(k, bucket, nums, i+1, used, target)) {
                return true;
            }

            bucket -= nums[i];
            used[i] = false;

        }

        return false;

    }




}
