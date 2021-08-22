package com.example.leetcode.test;

public class s122 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

//    给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int maxProfit(int[] prices) {

//        int[][] dp = new int[prices.length][2];
//
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
//        }
//        return dp[prices.length-1][0];

        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(temp, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp-prices[i]);
        }
        return dp_i_0;
    }

//    public static int maxProfit(int[] prices) {
//        int n = prices.length;
//        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            int temp = dp_i_0;
//            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
//            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
//        }
//        return dp_i_0;
//    }

}
