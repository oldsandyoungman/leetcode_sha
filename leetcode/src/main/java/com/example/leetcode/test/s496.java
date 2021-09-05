package com.example.leetcode.test;

import java.util.*;

public class s496 {

    public static void main(String[] args) {

//        int[] nums1 = {4,1,2};
//        int[] nums1 = {2,4};
        int[] nums1 = {3,1,2,5,4};


//        int[] nums2 = {1,3,4,2};
//        int[] nums2 = {1,2,3,4};
        int[] nums2 = {3,1,2,5,4};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElement2(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElement3(nums1, nums2)));

    }

//    给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
//
//    请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
//
//    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums2.length];
        Deque<Integer> s = new LinkedList<>();

        for (int i = nums2.length-1; i>=0; i--){

            while (!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }

            res[i] = s.isEmpty()?-1:s.peek();
            s.push(nums2[i]);

        }

        int[] fin = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]){
                    fin[i] = res[j];
                }
            }
        }

        return fin;

    }

    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> s = new LinkedList<>();

        for (int i = nums2.length-1; i>=0; i--){

            while (!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }

            map.put(nums2[i], s.isEmpty()?-1:s.peek());
//            res[i] = s.isEmpty()?-1:s.peek();
            s.push(nums2[i]);

        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
//            ans[i] = map.getOrDefault(nums1[i],-1);
            ans[i] = map.get(nums1[i]);
        }
        return ans;

    }



    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                int j = stack.pop();
                map.put(nums2[j],nums2[i]); // 此时nums2[j]<nums2[i]
            }
            stack.push(i); // 下标入栈
        }
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i],-1);
        }
        return ans;

    }



}
