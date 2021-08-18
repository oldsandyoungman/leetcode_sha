package com.example.leetcode.test;

import java.util.Arrays;

public class s645 {
    public static void main(String[] args) {

//        int[] a = {1,2,2,4};
//        int[] a = {1,1};
        int[] a = {2,3,3,4,5,6};
        System.out.println(Arrays.toString(findErrorNums(a)));

    }

//    234456

//    集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
//
//    给定一个数组 nums 代表了集合 S 发生错误后的结果。
//
//    请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

    public static  int[] findErrorNums(int[] nums) {

        Arrays.sort(nums);

        int[] a = {-1, -1};
        int sum = 0;
        boolean flag = false;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - i - 1;
            sum = sum + nums[i];
            if(!flag){
                if(nums[i] == 1){
                    a[1] = i+1;
                    flag = true;
                }else{
                    if(nums[i] == -1){
                        a[0] = i;
                        flag = true;
                    }
                }

            }
        }

        if(sum>0){
            a[0] = a[1] + sum;
        }else{
            if(sum<0){
                a[1] = a[0] - sum;
            }
        }

//        boolean flag = true;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            if(flag){
//                if(nums[i] < i+1){
//                    a[0] = nums[i];
//                    flag = false;
//                }else {
//                    if(nums[i] > i+1){
//                        a[1] = i+1;
//                    }
//                    flag = false;
//                }
//            }else{
//                if(nums[i] == i+1){
//                    if(nums[i-1] < i){
//                        a[1] = i;
//                        return a;
//                    }else{
//                        a[0] = nums[i-1];
//                        return a;
//                    }
//                }
//            }
//
//        }



        return a;
    }

}
