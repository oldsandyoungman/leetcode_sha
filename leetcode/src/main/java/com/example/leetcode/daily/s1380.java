package com.example.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class s1380 {

    public static void main(String[] args) {
//        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(luckyNumbers(matrix));
        System.out.println(luckyNumbers2(matrix));

    }

//    给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
//
//    幸运数是指矩阵中满足同时下列两个条件的元素：
//
//    在同一行的所有元素中最小
//            在同一列的所有元素中最大
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] hang_min = new int[m];
        int[] lie_max = new int[n];

        for (int i = 0; i < m; i++) {
            int min_sha = matrix[i][0];
            int min_index = 0;
            for (int j = 1; j < n; j++) {
                if (min_sha>matrix[i][j]){
                    min_sha = matrix[i][j];
                    min_index = j;
                }
            }
            hang_min[i] = min_index;
        }
        for (int j = 0; j < n; j++) {
            int max_sha = matrix[0][j];
            int max_index = 0;
            for (int i = 0; i < m; i++) {
                if (max_sha<matrix[i][j]){
                    max_sha = matrix[i][j];
                    max_index = i;
                }
            }
            lie_max[j] = max_index;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (lie_max[hang_min[i]]==i){
                res.add(matrix[i][hang_min[i]]);
            }
        }

        return res;

    }


    public static List<Integer> luckyNumbers2 (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int min_sha = matrix[i][0];
            int min_index = 0;
            for (int j = 1; j < n; j++) {
                if (min_sha>matrix[i][j]){
                    min_sha = matrix[i][j];
                    min_index = j;
                }
            }
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (matrix[j][min_index]>min_sha){
                    flag = false;
                    break;
                }
            }
            if (flag){
                res.add(min_sha);
            }

        }
        return res;

    }

}
