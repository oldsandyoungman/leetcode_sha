package com.example.leetcode.test;

public class s931 {

    public static void main(String[] args) {

    }


//    给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
//
//    下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1)
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = 66666;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp_sha(matrix, n-1, i));
        }

        return res;
        
    }

    public static int[][] memo;

    private static int dp_sha(int[][] matrix, int i, int j) {
        if (i<0 || j<0 || j>=matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i==0) {
//            memo[i][j] = matrix[i][j];
            return matrix[i][j];
        }
        if (memo[i][j]!=66666){
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + min_sha(dp_sha(matrix,i-1,j), dp_sha(matrix,i-1,j-1), dp_sha(matrix,i-1,j+1));
        return memo[i][j];
    }

    private static int min_sha(int i, int j, int k) {
        return Math.min(i,Math.min(j,k));
    }

}
