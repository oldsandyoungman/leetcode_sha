package com.example.leetcode.labuladong;

import java.util.*;

public class next_greater_number {

    public static void main(String[] args) {

        int[] s = new int[]{2,1,2,4,3};

        System.out.println(Arrays.toString(nextGreaterElement(s)));
        System.out.println(Arrays.toString(nextGreaterElement2(s)));

    }

    private static int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的 next great number
            res[i] = s.empty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }



    private static int[] nextGreaterElement2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for (int i = nums.length-1; i >= 0; i--){

            while (!s.empty() && s.peek() <= nums[i]){
                s.pop();
            }
            res[i] = s.empty()? -1 : s.peek();
            s.push(nums[i]);
        }

        return res;




    }


}
