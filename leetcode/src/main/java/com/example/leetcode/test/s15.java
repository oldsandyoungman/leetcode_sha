package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s15 {

    public static void main(String[] args) {

//        int[] nums = new int[]{2,7,11,15};
        int[] nums = new int[]{-1,0,1,2,-1,-4};
//        int[] nums = new int[]{};
//        int[] nums = new int[]{0};
        System.out.println(threeSum(nums));

    }

//    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//    注意：答案中不可以包含重复的三元组。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/3sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        int target = 0;

//        while (i<n-2) {
////            int now = nums[i];
//            List<List<Integer>> temp = twoSum(nums, i+1, target-nums[i]);
//            for (List<Integer> integers : temp) {
//                integers.add(nums[i]);
//                res.add(integers);
//            }
//            while (i<n-2 && nums[i]==nums[i+1]) {
//                i++;
//            }
//
//        }


        for (int j = 0; j < n; j++) {
//            int now = nums[i];
            List<List<Integer>> temp = twoSum(nums, j+1, target-nums[j]);
            for (List<Integer> integers : temp) {
                integers.add(nums[j]);
                res.add(integers);
            }
            while (j<n-2 && nums[j]==nums[j+1]) {
                j++;
            }

        }

        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int n = nums.length;
        int i = start;
        int j = n-1;

        List<List<Integer>> res = new ArrayList<>();

        while ( i<j ) {
            int left = nums[i];
            int right = nums[j];
            int sum = left + right;

            if (sum<target){
                i++;
                while ( i<j && left==nums[i]) {
                   i++;
                }
            } else if (sum>target) {
                j--;
                while ( i<j && right==nums[j]) {
                    j--;
                }
            } else if ( sum==target ) {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
                i++;
                while (i<j && left==nums[i]) {
                    i++;
                }
                j--;
                while ( i<j && right==nums[j]) {
                    j--;
                }
            }
        }
        return res;

    }



    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<List<Integer>> res2 = twoSum2(nums, i+1, -nums[i]);
            for (List<Integer> integers : res2) {
                integers.add(nums[i]);
                res.add(integers);
            }

            while (i<n-2 && nums[i]==nums[i+1]) {
                i++;
            }

        }

        return res;

    }




    public static List<List<Integer>> twoSum2(int[] nums, int start, int target) {

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        int left = start;
        int right = n-1;

        while (left<right){
            int templ = nums[left];
            int tempr = nums[right];
            int sum = templ+tempr;
            if (sum<target){
                left++;
                while (left<right && nums[left]==templ){
                    left++;
                }
            }else if (sum>target){
                right--;
                while (right>left && nums[right]==tempr){
                    right--;
                }
            }else {
                List<Integer> r = new ArrayList<>();
                r.add(nums[left]);
                r.add(nums[right]);
                res.add(r);
                left++;
                while (left<right && nums[left]==templ){
                    left++;
                }
                right--;
                while (right>left && nums[right]==tempr){
                    right--;
                }
            }
        }

        return res;

    }


}
