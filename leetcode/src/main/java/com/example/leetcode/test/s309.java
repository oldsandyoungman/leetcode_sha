package com.example.leetcode.test;

public class s309 {

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit5(prices));
        System.out.println(maxProfit6(prices));
    }

//    给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n<2){
            return 0;
        }
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(0,dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0]-prices[1]);

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);

        }
        return dp[n-1][0];

    }

//    public static int maxProfit2(int[] prices) {
//        int n = prices.length;
//        if (n==0){
//            return 0;
//        }
//        int[][] dp = new int[n][2];
//
//        int dp0 = Math.max(0,prices[1]-prices);
//        int dp1 = ;
//
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        dp[1][0] = Math.max(0,dp[0][1]+prices[1]);
//        dp[1][1] = Math.max(dp[0][1], dp[0][0]-prices[1]);
//
//        for (int i = 2; i < n; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
//
//        }
//        return dp[n-1][0];
//    }




    // 最完整版
    public static int maxProfit5(int[] prices) {
        int n = prices.length;
        if (n<2){
            return 0;
        }
        // dp[i][j]:
        // i: 第i天结束
        // j: 是否持有股票（0：不持有）
        // k: 还有几次交易机会，这里因为无限次所以省略
        int[][] dp = new int[n][2];

        // base case
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        dp[1][0] = Math.max(0,prices[1]-prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][0][1] = 0;
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
//            dp[i][1] = -10001;
        }

        return Math.max(dp[n-1][0], 0);

    }

    // 压缩空间版
    public static int maxProfit6(int[] prices) {
        int n = prices.length;
        if (n<2){
            return 0;
        }
        // dp[i][j]:
        // i: 第i天结束
        // j: 是否持有股票（0：不持有）
        // k: 还有几次交易机会

        // 本质上只需要2个变量空间存储
        // dp1: 持有股票
        // dp0: 未持有股票
        // base case
        int dp01 = -prices[0];
        int dp00 = 0;
        int dp10 = Math.max(0,prices[1]-prices[0]);
        int dp11 = Math.max(-prices[0], -prices[1]);

        int qiantian0 = 0;

        for (int i = 2; i < n; i++) {
//            int temp01 = dp01;
//            int temp00 = dp00;
//            int temp11 = dp11;
            int temp10 = dp10;

            dp10 = Math.max(dp10, dp11+prices[i]);
//            dp[i][0][1] = 0;
            dp11 = Math.max(dp11, qiantian0-prices[i]);
//            dp[i][1] = -10001;

//            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
////            dp[i][0][1] = 0;
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
////            dp[i][1] = -10001;

            qiantian0 = temp10;

        }

        return Math.max(dp10, 0);

    }


}
