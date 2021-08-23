package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s18 {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,0,-1,0,-2,2};
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(fourSum(nums, 8));
    }

//    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
//
//            0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    你可以按 任意顺序 返回答案 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/4sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4,0,target);
    }

    public static List<List<Integer>> nSum(int[] nums, int nn, int start, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (nn == 2) {

            int lo = start;
            int hi = n - 1;

            while (lo < hi) {
                int left = nums[lo];
                int right = nums[hi];
                int sum = left + right;
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    temp.add(right);
                    res.add(temp);
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }

        } else {

            for (int i = start; i < n - nn + 1; i++) {
                List<List<Integer>> temp = nSum(nums, nn - 1, i + 1, target - nums[i]);
                for (List<Integer> integers : temp) {
                    integers.add(nums[i]);
                    res.add(integers);
                }
                while (i < n - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }

        }

        return res;
    }

}
