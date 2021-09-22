package com.example.leetcode.test;

public class s55 {

    public static void main(String[] args) {

    }

//    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个下标。

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if (farthest<=i){
                return false;
            }
        }
        return farthest>=n-1;
    }

}
