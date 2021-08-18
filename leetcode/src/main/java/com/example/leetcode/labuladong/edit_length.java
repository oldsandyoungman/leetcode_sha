package com.example.leetcode.labuladong;

public class edit_length {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(edit_length_sha(s1,s2));

    }

    private static int edit_length_sha(String s1, String s2) {

        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < s2.length()+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min_sha(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1;
                }

            }
        }
        return dp[s1.length()][s2.length()];

    }

    private static int min_sha(int i, int i1, int i2) {
        return Math.min(i, Math.min(i1, i2));
    }


}
