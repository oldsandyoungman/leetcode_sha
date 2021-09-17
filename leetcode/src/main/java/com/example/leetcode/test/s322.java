package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Comparator;

public class s322 {

    public static void main(String[] args) {
//        int[] coins = {1,2,5};
        int[] coins = {2147483647};
//        int[] coins = {1};
        System.out.println(coinChange(coins, 2));
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


//    public static int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp, amount+1);
//        dp[0] = 0;
//
//        for (int i = 1; i < amount+1; i++) {
//            int min = amount+1;
//            for (int coin : coins) {
//                if (i>=coin) {
//                    min = Math.min(min, dp[i-coin]+1);
//                }
//            }
//            dp[i] = min;
//        }
//        return (dp[amount]==amount+1)?-1:dp[amount];
//
//    }








////    备忘录方法
////    如果是-1，代表之前没算过
////    如果是10001，代表无法凑出来
////    其它就是可以凑出来，数字即为最小硬币数量
//    public static int[] memo;
//    public static int coinChange(int[] coins, int amount) {
//        memo = new int[amount+1];
//        Arrays.fill(memo, -1);
//        memo[0] = 0;
//        traverse(coins, amount);
//        if (memo[amount]>10000) {
//            return -1;
//        }else {
//            return memo[amount];
//        }
//
//    }
//    public static int traverse(int[] coins, int amount){
////        printspace(count_n++);
////        System.out.print("amount:" + amount + '\n');
//
//        if (amount==0){
//            return 0;
//        }
//        if (memo[amount]!=-1){
////            printspace(--count_n);
////            System.out.print("return:" + memo[amount] + '\n');
//            return memo[amount];
//        }
//        int res = 10001;
//        for (int coin : coins) {
//            if (coin>amount){
//                continue;
//            }
//            res = Math.min(res, 1+traverse(coins, amount-coin));
//        }
//        if (res>10000) {
//            memo[amount] = 10001;
////            printspace(--count_n);
////            System.out.print("return:" + "10001" + '\n');
//            return 10001;
//        }
//        memo[amount] = res;
////        printspace(--count_n);
////        System.out.print("return:" + res + '\n');
//        return res;
//    }


////    dp table法(自己写的)
//    public static int coinChange(int[] coins, int amount) {
//        if (amount==0){
//            return 0;
//        }
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp, amount+1);
//        dp[0] = 0;
//        for (int i = 0; i < amount; i++) {
//            for (int coin : coins) {
//                if (i+coin<=amount && i+coin>0){
//                    dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
//                }
//            }
//        }
//        if (dp[amount]==amount+1) {
//            return -1;
//        }
//        return dp[amount];
//    }

    //    dp table法(官方思路)
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i>=coin) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        if (dp[amount]==amount+1) {
            return -1;
        }
        return dp[amount];
    }










    public static int count_n = 0;

    public static void printspace(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }





}
