package com.example.leetcode.test;

import java.util.Arrays;

public class s34 {
    public static void main(String[] args) {
//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {1,2,3,3,3,3,4,5,9};
        System.out.println(Arrays.toString(searchRange(nums, 3)));
    }

//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//    如果数组中不存在目标值 target，返回 [-1, -1]。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length==0) {
            return new int[]{-1,-1};
        }
        int res1;
        int res2;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left<=right) {
            mid = left + (right-left)/2;
            if (nums[mid]<target) {
                left = mid + 1;
            } else if (nums[mid]>target) {
                right = mid - 1;
            } else if (nums[mid]==target) {
                break;
            }
        }

        if (nums[mid]!=target) {
            return new int[]{-1,-1};
        }

        int left1 = left;
        int right1 = mid - 1;

        while (left1<=right1) {
            int mid1 = left1 + (right1-left1)/2;
            if (nums[mid1]<target) {
                left1 = mid1 + 1;
            } else if (nums[mid1]>target) {
                right1 = mid1 - 1;
            } else if (nums[mid1]==target) {
                right1 = mid1 - 1;
            }
        }

        if (left1==nums.length || nums[left1]!=target) {
            res1 = mid;
        }else {
            res1 = left1;
        }


        int left2 = mid + 1;
        int right2 = right;

        while (left2<=right2){
            int mid2 = left2 + (right2-left2)/2;
            if (nums[mid2]<target) {
                left2 = mid2 + 1;
            } else if (nums[mid2]>target) {
                right2 = mid2 - 1;
            } else if (nums[mid2]==target) {
                left2 = mid2 + 1;
            }
        }

        if (right2==-1 || nums[right2]!=target){
            res2 = mid;
        }else {
            res2 = right2;
        }

        return new int[]{res1,res2};


    }

}
