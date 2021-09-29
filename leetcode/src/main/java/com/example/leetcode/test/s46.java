package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        List<List<Integer>> list2 = permute2(nums);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
        for (List<Integer> integers : list2) {
            System.out.println(integers);
        }
    }

//    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。


    public static List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        List<Integer> track = new LinkedList<>();
        traverse(nums,track);
        return list;
    }

    public static List<List<Integer>> list;

    public static void traverse(int[] nums, List<Integer> track){
        if (track.size()==nums.length) {
            List<Integer> res = new LinkedList<>(track);
            list.add(res);
            return;
        }

        for (int num : nums) {
            if (!track.contains(num)) {
                track.add(num);
                traverse(nums,track);
                track.remove(track.size()-1);
            }
        }

    }




    public static List<List<Integer>> permute2(int[] nums) {
        res = new LinkedList<>();
        List<Integer> done = new LinkedList<>();
        backtrack(done, nums);
        return res;
    }
    public static List<List<Integer>> res;
    public static void backtrack(List<Integer> done, int[] nums){
        if (done.size()==nums.length) {
            res.add(new LinkedList<>(done));
            return;
        }

        for (int num : nums) {
            if (!done.contains(num)){
                done.add(num);
                backtrack(done, nums);
                done.remove(done.size()-1);
            }
        }

    }



}
