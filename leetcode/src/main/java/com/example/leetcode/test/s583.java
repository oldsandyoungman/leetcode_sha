package com.example.leetcode.test;

import java.util.Arrays;

public class s583 {
    public static void main(String[] args) {

//        String s1 = "sea";
        String s1 = "leetcode";
//        String s2 = "eat";
        String s2 = "etco";

        System.out.println(minDistance(s1,s2));
        System.out.println(minDistance2(s1,s2));

    }

//    给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
//
//    public static int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        int dp = new
//
//    }


//    public static int minDistance(String word1, String word2) {
//        memo = new int[word1.length()+1][word2.length()+1];
//        for (int[] ints : memo) {
//            Arrays.fill(ints, -1);
//        }
//        return dp_sha(word1, word1.length()-1, word2, word2.length()-1);
//    }
//    public static int[][] memo;
//
//    public static int dp_sha(String s1, int n1, String s2, int n2){
//        if (memo[n1+1][n2+1]!=-1) {
//            return memo[n1+1][n2+1];
//        }
//        if (n1<0) {
//            memo[n1+1][n2+1] = n2+1;
//            return memo[n1+1][n2+1];
//        }
//        if (n2<0) {
//            memo[n1+1][n2+1] = n1+1;
//            return memo[n1+1][n2+1];
//        }
//        if (s1.charAt(n1)==s2.charAt(n2)) {
//            memo[n1+1][n2+1] = dp_sha(s1, n1-1, s2, n2-1);
//
//        }else {
//            memo[n1+1][n2+1] = 1+Math.min(dp_sha(s1, n1, s2, n2-1),dp_sha(s1,n1-1, s2, n2));
//        }
//        return memo[n1+1][n2+1];
//    }


    public static int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

//        int[][] dp = new int[n1+1][n2+1];
        int[] dp = new int[n2+1];


        for (int i = 1; i <= n1; i++) {
            int pre = 0;
            for (int j = 1; j <= n2; j++) {
                int temp = dp[j];
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
//                    dp[i][j] = dp[i-1][j-1] + 1;
                    dp[j] = pre + 1;
                }else {
//                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                pre = temp;
            }
        }

        return n1 + n2 - 2*dp[n2];

    }


    // dp table 方法
    public static int minDistance2(String text1, String text2) {

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

        System.out.println(Arrays.deepToString(dp));

        return n1+n2-2*dp[n1][n2];

    }

}
