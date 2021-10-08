package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Random;

public class s384 {

    public static void main(String[] args) {

    }

//    给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
//
//    实现 Solution class:
//
//    Solution(int[] nums) 使用整数数组 nums 初始化对象
//    int[] reset() 重设数组到它的初始状态并返回
//    int[] shuffle() 返回数组随机打乱后的结果
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/shuffle-an-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


}


class Solution384 {

    public int[] nums_origin;
    public int[] nums;

    public Solution384(int[] nums) {
        this.nums_origin = nums.clone();
        this.nums = nums.clone();
    }

    public int[] reset() {
        int n = nums.length;
        System.arraycopy(this.nums_origin, 0, this.nums, 0, nums.length);
        return nums_origin;
    }

    public int[] shuffle() {
        Random r = new Random();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = r.nextInt(n-i)+i;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}