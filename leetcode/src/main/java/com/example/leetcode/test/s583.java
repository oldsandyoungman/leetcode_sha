package com.example.leetcode.test;

import java.util.Arrays;

public class s583 {
    public static void main(String[] args) {

        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minDistance(s1,s2));

    }

//    给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
//
//    public static int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        int dp = new
//
//    }


    public static int minDistance(String word1, String word2) {
        memo = new int[word1.length()+1][word2.length()+1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp_sha(word1, word1.length()-1, word2, word2.length()-1);
    }
    public static int[][] memo;

    public static int dp_sha(String s1, int n1, String s2, int n2){
        if (memo[n1+1][n2+1]!=-1) {
            return memo[n1+1][n2+1];
        }
        if (n1<0) {
            memo[n1+1][n2+1] = n2+1;
            return memo[n1+1][n2+1];
        }
        if (n2<0) {
            memo[n1+1][n2+1] = n1+1;
            return memo[n1+1][n2+1];
        }
        if (s1.charAt(n1)==s2.charAt(n2)) {
            memo[n1+1][n2+1] = dp_sha(s1, n1-1, s2, n2-1);

        }else {
            memo[n1+1][n2+1] = 1+Math.min(dp_sha(s1, n1, s2, n2-1),dp_sha(s1,n1-1, s2, n2));
        }
        return memo[n1+1][n2+1];
    }

}
