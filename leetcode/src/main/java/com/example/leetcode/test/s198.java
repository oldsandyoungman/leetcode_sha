package com.example.leetcode.test;

import java.util.Arrays;

public class s198 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
//        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
        System.out.println(rob3(nums));
        System.out.println(rob5(nums));
        System.out.println(rob6(nums));
    }

//    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/house-robber
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int rob2(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(dp[0]+nums[2], dp[1]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-3]+nums[i]);
        }

        System.out.println(Arrays.toString(dp));

        return Math.max(dp[n-1],dp[n-2]);

    }

    public static int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums,0);
    }

    public static int[] memo;

    public static int dp(int[] nums, int index){
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index]!=-1) {
            return memo[index];
        }
        int res1 = dp(nums, index+1);
        int res2 = dp(nums, index+2) + nums[index];
        int res = Math.max(res1, res2);
        memo[index] = res;
        return res;
    }



    public static int rob3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = n-1; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }
        return dp[0];
    }





    public static int rob5(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return nums[0];
        }
        // dp[i]: 以第i家结尾的前面这么多房屋最多能偷到多少钱
        int[] dp = new int[n];

        // base case
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return Math.max(dp[n-1], dp[n-2]);

    }


    public static int rob6(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n+2];

        for (int i = n-1; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], dp[i+2]+nums[i]);
        }

        return dp[0];

    }




}
