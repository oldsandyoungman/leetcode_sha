package com.example.leetcode.test;

public class s1312 {

    public static void main(String[] args) {
//        String s = "zzazz";
//        String s = "mbadm";
//        String s = "leetcode";
//        String s = "g";
        String s = "no";

        System.out.println(minInsertions(s));

    }

//    给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
//
//    请你返回让 s 成为回文串的 最少操作次数 。
//
//            「回文串」是正读和反读都相同的字符串。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        // base case: dp[i][i]
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 0;
//        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];

    }


}
