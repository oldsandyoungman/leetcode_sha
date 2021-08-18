package com.example.leetcode.test;

import java.util.Arrays;

public class s712 {

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        System.out.println(minimumDeleteSum(s1,s2));
    }

//    给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。

    public static int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()+1][s2.length()+1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp_sha(s1, s1.length()-1, s2, s2.length()-1);
    }
    public static int[][] memo;

    public static int dp_sha(String s1, int n1, String s2, int n2){
        if (memo[n1+1][n2+1]!=-1) {
            return memo[n1+1][n2+1];
        }
        if (n1<0) {
            int sum = 0;
            for (int i = 0; i <= n2; i++) {
                sum += s2.charAt(i);
            }
            memo[n1+1][n2+1] = sum;
            return sum;
        }
        if (n2<0) {
            int sum = 0;
            for (int i = 0; i <= n1; i++) {
                sum += s1.charAt(i);
            }
            memo[n1+1][n2+1] = sum;
            return sum;
        }
        if (s1.charAt(n1)==s2.charAt(n2)) {
            memo[n1+1][n2+1] = dp_sha(s1, n1-1, s2, n2-1);

        }else {
            memo[n1+1][n2+1] = Math.min(dp_sha(s1, n1, s2, n2-1)+s2.charAt(n2),dp_sha(s1,n1-1, s2, n2)+s1.charAt(n1));
        }
        return memo[n1+1][n2+1];
    }

}
