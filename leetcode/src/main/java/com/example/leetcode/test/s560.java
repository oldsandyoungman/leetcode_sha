package com.example.leetcode.test;

import java.util.HashMap;

public class s560 {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
//        int[] nums = {3,5,2,-2,4,1};
//        int k = 5;
        int k = 2;

        System.out.println(subarraySum(nums, k));
    }


//    给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。


    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
//        int[] preSum = new int[n];

        // map(m,n): 0-i的元素和为 m 的有 n 个
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int ans = 0;
        int sum0i = 0;

        for (int num : nums) {
            sum0i += num;
            int sum0j = sum0i - k;
            if (map.containsKey(sum0j)) {
                ans += map.get(sum0j);
            }
            map.put(sum0i, map.getOrDefault(sum0i, 0) + 1);
        }
        return ans;
    }


}
