package com.example.leetcode.test;

public class s27 {
    public static void main(String[] args) {
        int[] a = {1,1,2,3,4,5,5,6};

//        System.out.println(removeDuplicates(a));
        int temp = removeElement(a,5);
        for (int i = 0; i < temp; i++) {
            System.out.println(a[i]);
        }
    }

//    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
//
//    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
//
//    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。


//    public static int removeElement(int[] nums, int val) {
//        int slow = 0;
//        int fast = 0;
//
//        while (fast<nums.length){
//            if(nums[fast]!=val){
//                nums[slow] = nums[fast];
//                slow++;
//            }
//            fast++;
//        }
//
//        return slow;
//
//    }


    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;

        while (fast<nums.length){
            if (nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;


    }


    public static int removeElement2(int[] nums, int val) {

        int n = nums.length;

        int left = 0;
        int right = 0;

        while (right<n){

            if (nums[right]!=val) {
                nums[left] = nums[right];
                left++;
            }
            right++;

        }

        return left;

    }














}
