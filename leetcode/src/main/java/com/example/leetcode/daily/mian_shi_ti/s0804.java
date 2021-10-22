package com.example.leetcode.daily.mian_shi_ti;

import java.util.ArrayList;
import java.util.List;

public class s0804 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

//    幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
//
//    说明：解集不能包含重复的子集

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> now = new ArrayList<>();
        backtrack(nums, 0, now);
        return res;
    }

    public static List<List<Integer>> res = new ArrayList<>();

    public static void backtrack(int[] nums, int start, List<Integer> now){
        if (start==nums.length){
            res.add(new ArrayList<>(now));
            return;
        }

        backtrack(nums, start+1, now);
        now.add(nums[start]);
        backtrack(nums, start+1, now);
        now.remove(now.size()-1);





    }




}
