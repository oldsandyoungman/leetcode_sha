package com.example.leetcode.test;

import java.util.Arrays;

public class s1143 {

    public static void main(String[] args) {
//        String s1 = "ace";
        String s1 = "abcba";
//        String s2 = "abcde";
        String s2 = "abcbcba";




        System.out.println(longestCommonSubsequence(s1,s2));
        System.out.println(longestCommonSubsequence2(s1,s2));
        System.out.println(longestCommonSubsequence3(s1,s2));

    }

//    给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
//
//    一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//
//    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//    两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/longest-common-subsequence
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static int longestCommonSubsequence(String text1, String text2) {
//        int m = text1.length();
//        int n = text2.length();
//        int[][] dp = new int[m+1][n+1];
////        for (int i = 0; i < m + 1; i++) {
////            dp[i][0] = 0;
////        }
////        for (int j = 0; j < n+1; j++) {
////            dp[0][j] = 0;
////        }
//
//        for (int i = 1; i < m+1; i++) {
//            for (int j = 1; j < n+1; j++) {
//                if (text1.charAt(i-1) == text2.charAt(j-1)) {
//                    dp[i][j] = 1 + dp[i-1][j-1];
//                }else {
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//
//        return dp[m][n];
//    }



    // dp table 方法
    public static int longestCommonSubsequence2(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        return dp[n1][n2];

    }

    // 降维 方法
    public static int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[] dp = new int[n2+1];

        for (int i = 1; i <= n1; i++) {
            int pre = 0;
            for (int j = 1; j <= n2; j++) {
                int temp = dp[j];
                if (text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[j] = pre + 1;
                }else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                pre = temp;
            }
//            System.out.println(Arrays.toString(dp));
        }

        return dp[n2];

    }


    // 备忘录方法
    public static int longestCommonSubsequence3(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        memo = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(text1, text2, 0, 0);
    }
    public static int[][] memo;
    public static int dp(String text1, String text2, int n1, int n2){
        if (n1==text1.length() || n2==text2.length()){
            return 0;
        }
        if (memo[n1][n2]!=-1) {
            return memo[n1][n2];
        }
        if (text1.charAt(n1)==text2.charAt(n2)) {
            int res = 1 + dp(text1, text2, n1+1, n2+1);
            memo[n1][n2] = res;
            return res;
        }else {
            int res = Math.max(dp(text1, text2, n1, n2+1), dp(text1, text2, n1+1, n2));
            memo[n1][n2] = res;
            return res;
        }

    }

}
