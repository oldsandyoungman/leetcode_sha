package com.example.leetcode.test;

import java.util.Arrays;

public class s42 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

//    // 备忘录方法
//    public static int trap(int[] height) {
//        int n = height.length;
//        int[] l_max = new int[n];
//        Arrays.fill(l_max, -1);
//        int[] r_max = new int[n];
//        Arrays.fill(r_max, -1);
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            if (l_max[i]==-1){
//                int temp_l_max = 0;
//                for (int j = 0; j < i; j++) {
//                    temp_l_max = Math.max(temp_l_max, height[j]);
//                }
//                l_max[i] = temp_l_max;
//            }
//            if (r_max[i]==-1){
//                int temp_r_max = 0;
//                for (int j = i+1; j < n; j++) {
//                    temp_r_max = Math.max(temp_r_max, height[j]);
//                }
//                r_max[i] = temp_r_max;
//            }
//            int min_height = Math.min(l_max[i], r_max[i]);
//            res += Math.max(min_height-height[i], 0);
//        }
//        return res;
//    }

//    // 备忘录方法 + 精简
//    public static int trap(int[] height) {
//        int n = height.length;
//        int[] l_max = new int[n];
//        int temp_l_max = 0;
//        for (int i = 0; i < n; i++) {
//            temp_l_max = Math.max(temp_l_max, height[i]);
//            l_max[i] = temp_l_max;
//        }
//
//        int[] r_max = new int[n];
//        int temp_r_max = 0;
//        for (int i = n-1; i >= 0; i--) {
//            temp_r_max = Math.max(temp_r_max, height[i]);
//            r_max[i] = temp_r_max;
//        }
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            int min_height = Math.min(l_max[i], r_max[i]);
//            res += Math.max(min_height-height[i], 0);
//        }
//        return res;
//    }

    // 双指针法
    public static int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int l_max = height[0];
        int r_max = height[n-1];
        int res = 0;
        while (left<=right) {

            if (l_max<r_max) {
                l_max = Math.max(l_max, height[left]);
                res += Math.max(l_max-height[left], 0);
                left++;
            }else {
                r_max = Math.max(r_max, height[right]);
                res += Math.max(r_max-height[right], 0);
                right--;
            }

        }

        return res;

    }

}
