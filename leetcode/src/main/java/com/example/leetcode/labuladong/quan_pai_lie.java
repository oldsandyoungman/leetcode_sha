package com.example.leetcode.labuladong;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class quan_pai_lie {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> a = permute(nums);
        for (List<Integer> integers : a) {
            System.out.println(integers);
        }
    }


    /* 主函数，输入一组不重复的数字，返回它们的全排列 */

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        traverse(nums,track);
        return res;
    }

    public static List<List<Integer>> res = new LinkedList<>();

    public static void traverse(int[] nums, LinkedList<Integer> track){

        if (track.size()== nums.length){
            res.add(new LinkedList<>(track));
            return;
        }


        for (int j = 0; j < nums.length; j++) {
            if (track.contains(nums[j])) {
                continue;
            }
            track.add(nums[j]);
            traverse(nums, track);
            track.removeLast();
        }

    }

}
