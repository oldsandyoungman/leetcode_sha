package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class s51 {

    public static void main(String[] args) {

        List<List<String>> list = solveNQueens(4);
        for (List<String> strings : list) {
            System.out.println(strings);
        }
        List<List<String>> list2 = solveNQueens2(4);
        for (List<String> strings : list2) {
            System.out.println(strings);
        }
//        ssss:
//        for (int i = 0; i < 3; i++) {
//            for (int j = 2; j < 7; j++) {
//                System.out.println(j);
//                if (j==4){
//                    break;
//                }
//                if (i==1){
//                    break ssss;
//                }
//
//            }
//
//        }

    }

//    n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//    给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//    每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/n-queens
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static List<List<String>> list;

    public static List<List<String>> solveNQueens(int n) {
        list = new ArrayList<>();
        List<String> panel = new ArrayList<>();
        traverse(panel,0,n);
        return list;
    }

    public static void traverse(List<String> panel, int k, int n){
        if (k==n){
            List<String> res = new ArrayList<>(panel);
            list.add(res);
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                if (panel.get(j).charAt(i)=='Q') {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                continue;
            }
            for (int j = k-1; j >= 0; j--) {
                if (i+j-k>=0) {
                    if (panel.get(j).charAt(i+j-k)=='Q') {
                        flag = false;
                        break;
                    }
                }
                if (i+k-j<n) {
                    if (panel.get(j).charAt(i+k-j)=='Q') {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int m = 0; m < i; m++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int p = i+1; p < n; p++) {
                sb.append('.');
            }
            panel.add(sb.toString());
            traverse(panel, k+1, n);
            panel.remove(panel.size()-1);

        }
    }

    public static List<List<String>> solveNQueens2(int n) {
        res = new LinkedList<>();
        int[][] nums = new int[n][n];
        List<String> panel = new ArrayList<>();
        backtrack(panel, 0, n);

        return res;
    }
    public static List<List<String>> res;
    // Q: 有棋子
    // .: 没棋子
    public static void backtrack(List<String> panel, int k, int n){
        if (n==k){
            res.add(new ArrayList<>(panel));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (isValid(panel, k, i, n)) {
                StringBuilder sb = new StringBuilder();
                for (int i1 = 0; i1 < i; i1++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int i1 = i+1; i1 < n; i1++) {
                    sb.append(".");
                }
                panel.add(sb.toString());

                backtrack(panel, k+1, n);

                panel.remove(panel.size()-1);
            }
        }
    }

    private static boolean isValid(List<String> panel, int k, int i, int n) {
        for (int j = 0; j < k; j++) {
            if (panel.get(j).charAt(i)=='Q') {
                return false;
            }
        }
        int i1 = i;
        int j1 = k;
        int i2 = i;
        int j2 = k;
        while ( i1>0 && j1>0 ){
            i1--;
            j1--;
            if (panel.get(j1).charAt(i1)=='Q') {
                return false;
            }
        }
        while ( i2<n-1 && j2>0 ){
            i2++;
            j2--;
            if (panel.get(j2).charAt(i2)=='Q') {
                return false;
            }
        }

        return true;
    }


}
