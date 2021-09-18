package com.example.leetcode.test;

import java.util.HashMap;

public class s494 {

    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,1};
//        int[] nums = {1000};
        int[] nums = {0,0,0,0,0,0,0,0,1};
//        int[] nums = {100};
//        int target = 3;
//        int target = -1000;
        int target = 1;
//        int target = -200;

        System.out.println(findTargetSumWays(nums, target));

    }

//    给你一个整数数组 nums 和一个整数 target 。
//
//    向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
//
//    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
//    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/target-sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//    // dp table 方法
//    public static int findTargetSumWays(int[] nums, int target) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//
//        int fin = sum + Math.abs(target);
//        if (fin%2==1 || sum<target) {
//            return 0;
//        }
//        return subsets(nums, fin/2);
//    }

//    private static int subsets(int[] nums, int fin) {
//        int sz = nums.length;
//        int[][] dp = new int[sz+1][fin+1];
//
////        for (int i = 0; i <= fin; i++) {
////            dp[0][i] = 0;
////        }
//        for (int i = 0; i <= sz; i++) {
//            dp[i][0] = 1;
//        }
//
//        for (int i = 1; i <= sz; i++) {
//            for (int j = 0; j <= fin; j++) {
//                if (j >= nums[i-1]) {
//                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
//                }else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[sz][fin];
//    }

    // 降维
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int fin = sum + Math.abs(target);
        if (fin%2==1 || sum<target) {
            return 0;
        }
        return subsets(nums, fin/2);
    }
    private static int subsets(int[] nums, int fin) {
        int sz = nums.length;
        int[] dp = new int[fin+1];

        dp[0] = 1;

        for (int i = 1; i <= sz; i++) {
            for (int j = fin; j >= 0; j--) {
                if (j >= nums[i-1]) {
                    dp[j] = dp[j] + dp[j-nums[i-1]];
                }else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[fin];
    }


//    // 备忘录法（回溯）
//    public static int findTargetSumWays(int[] nums, int target) {
//        int n = nums.length;
//        if (n==0) {
//            return 0;
//        }
//        return dp(nums, target, 0);
//    }
//
//    public static HashMap<String, Integer> memo = new HashMap<>();
//
//    public static int dp(int[] nums, int rest, int i){
//        if (i==nums.length) {
//            if (rest==0) {
//                return 1;
//            }
//            return 0;
//        }
//        String s = i+","+rest;
//        if (memo.containsKey(s)) {
//            return memo.get(s);
//        }
//
//        int sum1 = dp(nums, rest-nums[i], i+1);
//        int sum2 = dp(nums, rest+nums[i], i+1);
//
//        int sum = sum1+sum2;
//        memo.put(s, sum);
//        return sum;
//    }




}
