package com.example.leetcode.test;

import java.util.Arrays;

public class s931 {

    public static void main(String[] args) {
        int[][] s = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(s));
    }


//    给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
//    下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1)
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//    public static int minFallingPathSum(int[][] matrix) {
//        int n = matrix.length;
//        memo = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                memo[i][j] = 66666;
//            }
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            res = Math.min(res, dp_sha(matrix, n-1, i));
//        }
//
//        return res;
//
//    }
//
//    public static int[][] memo;
//
//    private static int dp_sha(int[][] matrix, int i, int j) {
//        if (i<0 || j<0 || j>=matrix[0].length) {
//            return Integer.MAX_VALUE;
//        }
//        if (i==0) {
////            memo[i][j] = matrix[i][j];
//            return matrix[i][j];
//        }
//        if (memo[i][j]!=66666){
//            return memo[i][j];
//        }
//        memo[i][j] = matrix[i][j] + min_sha(dp_sha(matrix,i-1,j), dp_sha(matrix,i-1,j-1), dp_sha(matrix,i-1,j+1));
//        return memo[i][j];
//    }
//
//    private static int min_sha(int i, int j, int k) {
//        return Math.min(i,Math.min(j,k));
//    }




//    //    备忘录方法
//    public static int minFallingPathSum(int[][] matrix) {
//
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        memo = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                memo[i][j] = 10001;
//            }
//        }
//
//        int res = 10001;
//        for (int i = 0; i < n; i++) {
//            res = Math.min(res, traverse(matrix, m-1, i));
//        }
//        return res;
//
//    }
//    public static int[][] memo;
//    public static int traverse(int[][] matrix, int i, int j){
//
//        printspace(count_n++);
//        System.out.print("i="+i+",j="+j+'\n');
//
//
//        if (j<0 || j>=matrix[0].length) {
//            printspace(--count_n);
//            System.out.print("res=10001"+'\n');
//            return 10001;
//        }
//        if (i==0){
//            printspace(--count_n);
//            System.out.print("res="+matrix[0][j]+'\n');
//            return matrix[0][j];
//        }
//        if (memo[i][j]!=10001) {
//            printspace(--count_n);
//            System.out.print("res="+memo[i][j]+'\n');
//            return memo[i][j];
//        }
//        int res = 10001;
//        for (int k = j-1; k <= j+1; k++) {
//            res = Math.min(res, traverse(matrix, i-1, k));
//        }
//
//        res += matrix[i][j];
//        memo[i][j] = res;
//
//        printspace(--count_n);
//        System.out.print("res="+res+'\n');
//
//        return res;
//
//    }




    //    dp table方法
    public static int minFallingPathSum(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (n==1) {
            int s = 0;
            for (int[] ints : matrix) {
                s += ints[0];
            }
            return s;
        }

        int[][] dp = new int[m][n];

        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        for (int i = 1; i < m; i++) {

            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + matrix[i][0];

            for (int j = 1; j < n-1; j++) {

                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])) + matrix[i][j];

            }

            dp[i][n-1] = Math.min(dp[i-1][n-1], dp[i-1][n-2]) + matrix[i][n-1];

        }

        int res = 10001;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m-1][i]);
        }

        return res;

    }













    public static int count_n = 0;

    public static void printspace(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }




}
