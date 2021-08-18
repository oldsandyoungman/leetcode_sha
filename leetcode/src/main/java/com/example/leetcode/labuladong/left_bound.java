package com.example.leetcode.labuladong;

public class left_bound {

    public static void main(String[] args) {

        int[] a = {1,2,3,3,4,4,4,5,7};

        System.out.println(left_bound(a, 3));

    }

//    找一个数组中某个数的左边界

    public static int left_bound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]<target) {
                left = mid + 1;
            } else if (nums[mid]>target) {
                right = mid - 1;
            } else if (nums[mid]==target) {
                right = mid - 1;
            }
        }

        if (left>=nums.length || nums[left]!=target) {
            return -1;
        }

        return left;

    }

    public static int right_bound(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid]<target) {
                left = mid + 1;
            } else if (nums[mid]>target) {
                right = mid - 1;
            } else if (nums[mid]==target) {
                left = mid + 1;
            }
        }

        if (right<0 || nums[left]!=target) {
            return -1;
        }

        return right;

    }

}
