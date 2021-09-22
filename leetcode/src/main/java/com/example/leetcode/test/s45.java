package com.example.leetcode.test;

public class s45 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

//    给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//    假设你总是可以到达数组的最后一个位置。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/jump-game-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if (end==i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }


}
