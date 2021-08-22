package com.example.leetcode.test;

import java.util.Arrays;

public class s188 {

    public static void main(String[] args) {
        int k = 2;
//        int[] prices = {2,4,1};
        int[] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(k, prices));
//        System.out.println(maxProfit_k_2(prices));
    }


//    给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit(int k, int[] prices) {
        if (prices.length==0 || k==0){
            return 0;
        }

        int n =prices.length;
        if (k>n/2){
            return maxProfit_k_inf(prices);
        }
        int[][][] dp = new int[n][k+1][2];
        int min_sha = Integer.MIN_VALUE/2;

        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = min_sha;
            dp[0][i][1] = min_sha;
        }

        for (int i = 1; i < n; i++) {
//            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][0][1],-prices[i]);
            for (int j = 1; j < k; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0]-prices[i]);
            }
            dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k-1][1]+prices[i]);
            dp[i][k][1] = min_sha;
        }

        int max_sha = 0;
        for (int i = 0; i <= k; i++) {
            max_sha = Math.max(max_sha, dp[n-1][i][0]);
        }

        System.out.println(Arrays.deepToString(dp));

        return max_sha;

    }

    public static int maxProfit_k_inf(int[] prices) {

        int n = prices.length;
        int[][] dp = new int[n][2];
        int min_sha = Integer.MIN_VALUE / 2;

        int dp0 = 0;
        int dp1 = -prices[0];


        for (int i = 1; i < n; i++) {
            int temp = dp0;
            dp0 = Math.max(temp, dp1 + prices[i]);
            dp1 = Math.max(dp1, temp - prices[i]);

        }

        return Math.max(dp0, 0);

    }


//    public static int maxProfit_k_2(int[] prices) {
//        int n = prices.length;
//        int[][][] dp = new int[n][3][2];
//
//        dp[0][0][0] = 0;
//        dp[0][0][1] = -prices[0];
//        dp[0][1][0] = Integer.MIN_VALUE/2;
//        dp[0][1][1] = Integer.MIN_VALUE/2;
//        dp[0][2][0] = Integer.MIN_VALUE/2;
//        dp[0][2][1] = Integer.MIN_VALUE/2;
//
//        for (int i = 1; i < n; i++) {
//            dp[i][0][0] = 0;
//            dp[i][0][1] = Math.max(dp[i-1][0][1], -prices[i]);
//            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]+prices[i]);
//            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][1][0]-prices[i]);
//            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][1][1]+prices[i]);
//            dp[i][2][1] = Integer.MIN_VALUE/2;
//        }
//
//        System.out.println(Arrays.deepToString(dp));
//
//        return Math.max(Math.max(dp[n-1][2][0], dp[n-1][1][0]), 0);
//
//    }

}
