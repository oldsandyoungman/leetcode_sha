package com.example.leetcode.test;

import java.util.Arrays;

public class s714 {

    public static void main(String[] args) {
//        int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices = {1,3,7,5,10,3};
//        int fee = 2;
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
        System.out.println(maxProfit5(prices, fee));
        System.out.println(maxProfit6(prices, fee));
    }

//    给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
//
//    你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
//
//    返回获得利润的最大值。
//
//    注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        if (n<2){
            return 0;
        }
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0]-fee;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]-fee);
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[n-1][0];

    }


    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n<2){
            return 0;
        }
//        int[][] dp = new int[n][2];

        int dp0 = 0;
        int dp1 = -prices[0]-fee;

        for (int i = 1; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(temp, dp1+prices[i]);
            dp1 = Math.max(dp1, temp-prices[i]-fee);
        }

        return dp0;

    }




    // 最完整版
    public static int maxProfit5(int[] prices, int fee) {
        int n = prices.length;
        // dp[i][j]:
        // i: 第i天结束
        // j: 是否持有股票（0：不持有）
        // k: 还有几次交易机会，这里因为无限次所以省略
        int[][] dp = new int[n][2];

        // base case
        dp[0][1] = -prices[0]-fee;
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][0][1] = 0;
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]-fee);
//            dp[i][1] = -10001;
        }

        return Math.max(dp[n-1][0], 0);

    }

    // 压缩空间版
    public static int maxProfit6(int[] prices, int fee) {
        int n = prices.length;
        // dp[i][j]:
        // i: 第i天结束
        // j: 是否持有股票（0：不持有）
        // k: 还有几次交易机会

        // 本质上只需要2个变量空间存储
        // dp1: 持有股票
        // dp0: 未持有股票
        // base case
        int dp1 = -prices[0]-fee;
        int dp0 = 0;

        for (int i = 1; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(dp0,dp1+prices[i]);
//            dp[i][0][1] = 0;
            dp1 = Math.max(dp1, temp-prices[i]-fee);
//            dp[i][1][1] = -10001;
        }

        return Math.max(dp0, 0);

    }











}
