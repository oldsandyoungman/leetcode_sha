package com.example.leetcode.labuladong;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class ling_yi_bei_bao {

    public static void main(String[] args) {

        int N = 3, W = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};

        System.out.println(max_sha(wt, val, N, W));

    }

//    01背包问题

//    // 备忘录方法
//    public static int max_sha(int[] w, int[] val){
//        int n_w = w.length;
//        int n_val = val.length;
//        memo = new int[n_w][n_val];
//
//
//
//    }
//    public static int[][] memo;
//    public static int dp(int[] w, int[] val, ){
//
//    }


    public static int max_sha(int[] wt, int[] val, int N, int W){
        int n_w = wt.length;
        int n_val = val.length;

        int[][] dp = new int[N+1][W+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
//                System.out.println(i-1);
                if (j<wt[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]]+val[i-1]);
                }
            }
        }

        return dp[N][W];
    }

}
