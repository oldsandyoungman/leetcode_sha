package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class s78 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }

//    给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        backtrack(nums, 0, now);
        return res;
    }
    public static List<List<Integer>> res;
    // 方法一
    public static void backtrack(int[] nums, int start, List<Integer> now){
        if (start== nums.length) {
            res.add(new ArrayList<>(now));
            return;
        }

        now.add(nums[start]);
        backtrack(nums, start+1, now);

        now.remove(now.size()-1);
        backtrack(nums, start+1, now);

    }
//    // 方法二
//    public static void backtrack(int[] nums, int start, List<Integer> now){
////        if (start== nums.length) {
////            res.add(new ArrayList<>(now));
////            return;
////        }
//        res.add(new ArrayList<>(now));
//
//        for (int i = start; i < nums.length; i++) {
//            now.add(nums[i]);
//            backtrack(nums, i+1, now);
//            now.remove(now.size()-1);
//        }
//
//    }

}
