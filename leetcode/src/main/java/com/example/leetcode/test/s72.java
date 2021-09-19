package com.example.leetcode.test;

import java.util.Arrays;

public class s72 {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));
        System.out.println("666");
    }


//    给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//    你可以对一个单词进行如下三种操作：
//
//    插入一个字符
//            删除一个字符
//    替换一个字符
// 
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/edit-distance
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    // dp table 方法
//    public static int minDistance(String word1, String word2) {
//        int n1 = word1.length();
//        int n2 = word2.length();
//
//        int[][] dp = new int[n1+1][n2+1];
//
//        for (int i = 0; i <= n1; i++) {
//            dp[i][0] = i;
//        }
//        for (int i = 0; i <= n2; i++) {
//            dp[0][i] = i;
//        }
//
//
//        for (int i = 1; i <= n1; i++) {
//            for (int j = 1; j <= n2; j++) {
//                if (word1.charAt(i-1)==word2.charAt(j-1)) {
//                    dp[i][j] = dp[i-1][j-1];
//                }else {
//                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
//                }
//            }
//        }
//
//        return dp[n1][n2];
//
//    }


    // 备忘录 方法
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        memo = new int[n1+1][n2+1];

        for (int i = 0; i <= n1; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i <= n2; i++) {
            memo[0][i] = i;
        }
        for (int i = 0; i <= n1; i++) {
            memo[i][0] = i;
        }


        return dp(word1, word2, n1, n2);


    }

    public static int[][] memo;

    public static int dp(String word1, String word2, int s1, int s2){
        if (memo[s1][s2]!=-1){
            return memo[s1][s2];
        }

        if (word1.charAt(s1-1)==word2.charAt(s2-1)){
            memo[s1][s2] = dp(word1, word2, s1-1, s2-1);
            return memo[s1][s2];
        }else {
            memo[s1][s2] = 1+Math.min(dp(word1, word2, s1-1, s2-1), Math.min(dp(word1, word2, s1-1, s2), dp(word1, word2, s1, s2-1)));
            return memo[s1][s2];
        }

    }

}
