package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Comparator;

public class s322 {

    public static void main(String[] args) {
//        int[] coins = {1,2,5};
        int[] coins = {2};
//        int[] coins = {1};
        System.out.println(coinChange(coins, 3));
    }

//    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//    你可以认为每种硬币的数量是无限的。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/coin-change
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static int min = Integer.MAX_VALUE;
//    public static int[] memo;
//
//    public static int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        int[] coins2 = new int[coins.length];
//        for (int i = 0; i < coins.length; i++) {
//            coins2[i] = coins[coins.length-i-1];
//        }
//        memo = new int[amount];
//        traverse(coins2, amount, 0);
//        return min==Integer.MAX_VALUE?-1:min;
//    }
//
//    public static void traverse(int[] coins, int amount, int count){
//        if (amount==0){
//            min = Math.min(min, count);
//            return;
//        }
//
//        for (int coin : coins) {
//            if (amount<coin){
//                continue;
//            }
//            traverse(coins, amount-coin, count+1);
//        }
//    }


//    public static int[] memo;
//
//    public static int coinChange(int[] coins, int amount) {
//        if (amount==0) {
//            return 0;
//        }
//        memo = new int[amount+1];
//        Arrays.fill(memo, Integer.MAX_VALUE);
//        traverse(coins, amount);
//        return memo[amount]==Integer.MAX_VALUE?-1:memo[amount];
//    }
//
//    public static int traverse(int[] coins, int amount){
//        if (amount==0){
//            return 0;
//        }
//        if (memo[amount]!=Integer.MAX_VALUE) {
//            return memo[amount];
//        }
//
//        int min = Integer.MAX_VALUE;
//
//        for (int coin : coins) {
//            if (coin>amount) {
//                continue;
//            }
//            int res = 1 + traverse(coins, amount - coin);
//            min = Math.min(min, res);
//        }
//        memo[amount] = min;
//        return memo[amount];
//    }





//    public static int[] memo;
//
//    public static int coinChange(int[] coins, int amount) {
//        if (amount==0) {
//            return 0;
//        }
//        memo = new int[amount+1];
//        Arrays.fill(memo, -666);
//        traverse(coins, amount);
//        return memo[amount];
//    }
//
//    public static int traverse(int[] coins, int amount){
//        if (amount==0){
//            return 0;
//        }
//        if (memo[amount]!=-666) {
//            return memo[amount];
//        }
//
//        int min = Integer.MAX_VALUE;
//
//        for (int coin : coins) {
//            if (coin>amount) {
//                continue;
//            }
//            int res = 1 + traverse(coins, amount - coin);
//            if (res>0) {
//                min = Math.min(min, res);
//            }
//        }
//        memo[amount] = min==Integer.MAX_VALUE?-1:min;
//        return memo[amount];
//    }




//    public static int[] memo;
//
//    public static int coinChange(int[] coins, int amount) {
//        if (amount==0) {
//            return 0;
//        }
//        memo = new int[amount+1];
//        Arrays.fill(memo, -666);
//
//        return traverse(coins, amount);
//    }
//
//    public static int traverse(int[] coins, int amount){
//        if (amount==0){
//            return 0;
//        }
//        if (amount<0) {
//            return -1;
//        }
//        if (memo[amount]!=-666) {
//            return memo[amount];
//        }
//
//        int min = Integer.MAX_VALUE;
//
//        for (int coin : coins) {
//
//            int res = traverse(coins, amount - coin);
//            if (res==-1) {
//                continue;
//            }
//            min = Math.min(min, res+1);
//
//        }
//        memo[amount] = min==Integer.MAX_VALUE?-1:min;
//        return memo[amount];
//    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            int min = amount+1;
            for (int coin : coins) {
                if (i>=coin) {
                    min = Math.min(min, dp[i-coin]+1);
                }
            }
            dp[i] = min;
        }
        return (dp[amount]==amount+1)?-1:dp[amount];

    }

}
