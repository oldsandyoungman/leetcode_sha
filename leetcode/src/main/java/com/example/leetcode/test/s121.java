package com.example.leetcode.test;

public class s121 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
//        System.out.println(maxProfit(prices));
        System.out.println(maxProfit3(prices));
        System.out.println(maxProfit5(prices));
        System.out.println(maxProfit6(prices));
    }


//    给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
//    你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
//        }
//
//        return dp[prices.length-1][0];


//        int[][] dp = new int[prices.length][2];
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }

        return dp_i_0;



    }


//    public static int maxProfit(int[] prices) {
//
//        int n = prices.length;
//        int[][] dp = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            if (i - 1 == -1) {
//                dp[i][0] = 0;
//                // 解释：
//                //   dp[i][0]
//                // = max(dp[-1][0], dp[-1][1] + prices[i])
//                // = max(0, -infinity + prices[i]) = 0
//                dp[i][1] = -prices[i];
//                //解释：
//                //   dp[i][1]
//                // = max(dp[-1][1], dp[-1][0] - prices[i])
//                // = max(-infinity, 0 - prices[i])
//                // = -prices[i]
//                continue;
//            }
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//        }
//        return dp[n - 1][0];
//
//    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        int min_sha = Integer.MIN_VALUE/2;

        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = min_sha;
        dp[0][1][1] = min_sha;

        for (int i = 1; i < n; i++) {
//            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][0][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]+prices[i]);
//            dp[i][1][1] = min_sha;

        }

        return Math.max(dp[n-1][1][0], 0);

    }


    public static int maxProfit4(int[] prices) {
        int n = prices.length;
        int min_sha = Integer.MIN_VALUE/2;

//        int dp00 = 0;
        int dp01 = -prices[0];
        int dp10 = min_sha;
//        int dp11 = min_sha;

        for (int i = 1; i < n; i++) {
//            dp[i][0][0] = 0;
            dp10 = Math.max(dp10, dp01+prices[i]);
            dp01 = Math.max(dp01, -prices[i]);

//            dp[i][1][1] = min_sha;

        }

        return Math.max(dp10,0);

    }


    // 最完整版
    public static int maxProfit5(int[] prices) {
        int n = prices.length;
        // dp[i][j]:
        // i: 第i天结束
        // j: 是否持有股票（0：不持有）
        // k: 还有几次交易机会
        int[][][] dp = new int[n][2][2];

        // base case
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -10001;
        dp[0][0][0] = -10001;
        dp[0][0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = Math.max(dp[i-1][0][0],dp[i-1][1][0]+prices[i]);
//            dp[i][0][1] = 0;
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1]-prices[i]);
            dp[i][1][1] = -10001;
        }

        return Math.max(dp[n-1][0][0], dp[n-1][0][1]);

    }

    // 压缩空间版
    public static int maxProfit6(int[] prices) {
        int n = prices.length;
        // dp[i][j]:
        // i: 第i天结束
        // j: 是否持有股票（0：不持有）
        // k: 还有几次交易机会

        // 本质上只需要4个变量空间存储
        // dp10: 持有股票+没有购买机会
        // dp11: 持有股票+有购买机会
        // dp00: 未持有股票+没有购买机会
        // dp01: 未持有股票+有购买机会
        // base case
        int dp10 = -prices[0];
        int dp11 = -10001;
        int dp00 = -10001;
        int dp01 = 0;

        for (int i = 1; i < n; i++) {
            dp00 = Math.max(dp00,dp10+prices[i]);
//            dp[i][0][1] = 0;
            dp10 = Math.max(dp10, dp01-prices[i]);
//            dp[i][1][1] = -10001;
        }

        return Math.max(dp00, dp01);

    }


}
