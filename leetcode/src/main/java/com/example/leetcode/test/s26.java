package com.example.leetcode.test;

public class s26 {

    public static void main(String[] args) {

        int[] a = {1,1,2,3,4,5,5,6};

//        System.out.println(removeDuplicates(a));
        int temp = removeDuplicates(a);
        for (int i = 0; i < temp; i++) {
            System.out.println(a[i]);
        }

    }

//    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
//
//    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

//    public static int removeDuplicates(int[] nums) {
//
//        if(nums.length==0){
//            return 0;
//        }
//
//        int slow = 0;
//        int fast = 0;
//
//        while (fast<nums.length){
//
//            if (nums[fast]!=nums[slow]) {
//                slow++;
//                nums[slow] = nums[fast];
//            }
//            fast++;
//
//        }
//
//        return slow+1;
//
//
//    }


    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int slow = 0;
        int fast = 0;

        while (fast<nums.length){
            if (nums[slow]!=nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow+1;
    }

}
