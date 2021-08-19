package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        for (List<Integer> integers : list) {
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



}
