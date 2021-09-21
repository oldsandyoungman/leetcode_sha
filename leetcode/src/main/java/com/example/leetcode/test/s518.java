package com.example.leetcode.test;

public class s518 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, coins));
        System.out.println(change3(amount, coins));
        System.out.println(change4(amount, coins));
    }

//    给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
//
//    请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
//
//    假设每一种面额的硬币有无限个。 
//
//    题目数据保证结果符合 32 位带符号整数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/coin-change-2
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int change2(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }

            }
        }

        return dp[n][amount];

    }

    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i-1]<=j) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }

            }
        }

        return dp[amount];

    }


    // dp table 方法
    public static int change3(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[n][amount];


    }


    // 降维 方法
    public static int change4(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j>=coins[i-1]) {
                    dp[j] = dp[j] + dp[j-coins[i-1]];
                }
            }
        }

        return dp[amount];


    }


}
