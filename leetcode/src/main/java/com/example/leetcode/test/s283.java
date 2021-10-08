package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Stack;

public class s283 {
    public static void main(String[] args) {

        int[] a = {1,0,2,3,4,0,5,6};

//        System.out.println(removeDuplicates(a));
        moveZeroes3(a);
//        for (int j : a) {
//            System.out.println(j);
//        }
        System.out.println(Arrays.toString(a));
    }

//    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序

    public static void moveZeroes2(int[] nums) {

        int slow = 0;
        int fast = 0;

        while (fast<nums.length){
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow<nums.length){
            nums[slow++] = 0;
        }


    }

    public static void moveZeroes(int[] nums) {

        int slow = 0;
        int fast = 0;

        while (fast<nums.length){
            if (nums[fast]!=0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow<nums.length) {
            nums[slow] = 0;
            slow++;
        }

    }


    public static void moveZeroes3(int[] nums) {

        int n = nums.length;

        int left = 0;
        int right = 0;

        while (right<n){
            if (nums[right]!=0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        while (left<n){
            nums[left]= 0;
            left++;
        }

    }

}

