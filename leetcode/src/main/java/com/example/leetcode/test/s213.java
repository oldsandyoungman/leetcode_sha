package com.example.leetcode.test;

public class s213 {

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }

//    你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
//
//    给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/house-robber-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n==1){
            return nums[0];
        }

        return Math.max(dp(nums, 0, n-2), dp(nums, 1, n-1));

    }

    public static int dp(int[] nums, int start, int end){
        int i1 = 0;
        int i2 = 0;
        int res = 0;

        for (int i = end; i >= start; i--) {
            res = Math.max(nums[i]+i2, i1);
            i2 = i1;
            i1 = res;
        }
        return res;
    }

}
