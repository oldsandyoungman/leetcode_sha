package com.example.leetcode.test;

import java.util.Arrays;

public class s516 {

    public static void main(String[] args) {
        String a = "bbbcb";
        System.out.println(longestPalindromeSubseq(a));
    }

//    给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
//
//    子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
////        for (int i = 0; i < n; i++) {
////            for (int j = 0; j < i; j++) {
////                dp[i][j] = 0;
////            }
////        }
//
//        for (int i = n-1; i >= 0; i--) {
//            for (int j = i+1; j < n; j++) {
//                if (s.charAt(i)==s.charAt(j)) {
//                    dp[i][j] = dp[i+1][j-1] + 2;
//                }else {
//                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
//                }
//            }
//        }
//        return dp[0][n-1];
//    }






//    // dp table法
//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
//
//        for (int i = n-2; i >= 0; i--) {
//            for (int j = i+1; j < n; j++) {
//                if (s.charAt(i)==s.charAt(j)) {
//                    dp[i][j] = dp[i+1][j-1] + 2;
//                }else {
//                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
//                }
//            }
//        }
//
//        return dp[0][n-1];
//
//    }



//    // dp table法 + 降维打击
//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
////        int[][] dp = new int[n][n];
//        int[] dp = new int[n];
//
////        for (int i = 0; i < n; i++) {
//////            dp[i][i] = 1;
////            dp[i] = 1;
////        }
//        Arrays.fill(dp, 1);
//
//
//        for (int i = n-2; i >= 0; i--) {
//            int pre = 0;
//            for (int j = i+1; j < n; j++) {
//                int temp = dp[j];
//                if (s.charAt(i)==s.charAt(j)) {
////                    dp[i][j] = dp[i+1][j-1] + 2;
//                    dp[j] = pre + 2;
//                }else {
////                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
//                    dp[j] = Math.max(dp[j-1], dp[j]);
//                }
//                pre = temp;
//            }
//        }
////        return dp[0][n-1];
//        return dp[n-1];
//
//    }

//    // dp table法
//    public static int longestPalindromeSubseq(String s) {
//        int n = s.length();
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
//        for (int i = n-1; i >= 0; i--) {
//            for (int j = i+1; j < n; j++) {
//                if (s.charAt(i)==s.charAt(j)) {
//                    dp[i][j] = dp[i+1][j-1]+2;
//                }else {
//                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
//                }
//            }
//        }
//
//        return dp[0][n-1];
//
//    }


    // 降维法
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = n-2; i >= 0; i--) {
            int pre = 0;
            for (int j = i+1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i)==s.charAt(j)) {
                    dp[j] = pre+2;
                }else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                pre = temp;
            }
        }

        return dp[n-1];



    }



}
