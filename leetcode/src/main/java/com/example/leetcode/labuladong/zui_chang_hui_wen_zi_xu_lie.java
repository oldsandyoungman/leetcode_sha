package com.example.leetcode.labuladong;

public class zui_chang_hui_wen_zi_xu_lie {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(shasha(s));

    }

    private static int shasha(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i==j){
                    dp[i][j]=1;
                }else {
                    dp[i][j]=0;
                }
            }
        }

        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i+1; j < s.length(); j++) {

                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }

            }
        }

        return dp[0][s.length()-1];

    }


}
