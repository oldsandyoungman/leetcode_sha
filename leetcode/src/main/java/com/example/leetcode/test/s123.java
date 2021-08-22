package com.example.leetcode.test;

import java.util.Arrays;

import static java.lang.Math.max;

public class s123 {

    public static void main(String[] args) {
//        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices = {1,2,3,4,5};
//        System.out.println(maxProfit3(prices));
//        System.out.println(maxProfit4(prices));
        System.out.println(maxProfit5(prices));
//        System.out.println(maxProfit(prices));
//        System.out.println(Integer.MIN_VALUE/2);
    }

//    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit2(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];

//        dp[0][2][0] = Integer.MIN_VALUE/2;
//        dp[0][2][1] = Integer.MIN_VALUE/2;
//        dp[0][1][0] = Integer.MIN_VALUE/2;
//        dp[0][1][1] = -prices[0];

        dp[0][2][0] = 0;
        dp[0][2][1] = Integer.MIN_VALUE/2;
        dp[0][1][0] = 0;
        dp[0][1][1] = Integer.MIN_VALUE/2;

        for (int i = 1; i < prices.length; i++) {
            for (int k = 2; k >= 1; k--) {
//            for (int k = 1; k < 3; k++) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[prices.length-1][2][0];
    }


    public static int maxProfit4(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /*处理 base case */
                    /*处理 base case */
//                    int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
//                    int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
                    dp[i][k][0] = 0;
                    dp[i][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
// 穷举了 n × max_k × 2 个状态，正确。
        return Math.max(dp[n - 1][max_k][0],dp[n-1][max_k-1][0]);

    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                /*处理 base case */
//                    int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
//                    int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
                dp[i][1][0] = 0;
                dp[i][2][0] = 0;
                dp[i][1][1] = Integer.MIN_VALUE;
                dp[i][2][1] = Integer.MIN_VALUE;
                continue;
            }
//            for (int k = max_k; k >= 1; k--) {
//
//                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
//                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
//
//            }
            dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
            dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
            dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]);
        }
// 穷举了 n × max_k × 2 个状态，正确。
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][max_k][0];
    }

    public static int maxProfit3(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][1] = Integer.MIN_VALUE;
        int i = 0;

        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);

            dp[i][2][0] = dp_i20;
            dp[i][2][1] = dp_i21;
            dp[i][1][0] = dp_i20;
            dp[i][1][1] = dp_i21;
            i++;
        }
        System.out.println(Arrays.deepToString(dp));
        return dp_i20;
    }


    public static int maxProfit5(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[][][] dp = new int[prices.length][3][2];
        int MIN_VALUE = Integer.MIN_VALUE / 2;//因为最小值再减去1就是最大值Integer.MIN_VALUE-1=Integer.MAX_VALUE
//        //初始化
//        dp[0][0][0] = 0;//第一天休息
//        dp[0][0][1] = dp[0][1][1] = MIN_VALUE;//不可能
//        dp[0][0][2] = dp[0][1][2] = MIN_VALUE;//不可能
//        dp[0][1][0] = -prices[0];//买股票
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0][0] = 0;
//            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
//            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
//            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
//            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
//            dp[i][1][2] = MIN_VALUE;
//        }
//        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));

        //初始化
        dp[0][0][0] = 0;//第一天休息
        dp[0][1][0] = dp[0][1][1] = MIN_VALUE;//不可能
        dp[0][2][0] = dp[0][2][1] = MIN_VALUE;//不可能
        dp[0][0][1] = -prices[0];//买股票
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][1][0] = Math.max(dp[i - 1][0][1] + prices[i], dp[i - 1][1][0]);
            dp[i][2][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][2][0]);
            dp[i][0][1] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][0][1]);
            dp[i][1][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][1][1]);
            dp[i][2][1] = MIN_VALUE;
        }
        return Math.max(0, Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]));
    }

}
