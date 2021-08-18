package com.example.leetcode.labuladong;

import java.util.Arrays;

public class lis {
    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};

        System.out.println(lis_sha(a));

    }

    private static int lis_sha(int[] a) {

        int[] dp = new int[a.length];
        Arrays.fill(dp,1);

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
//                System.out.println(a[i]);
//                System.out.println(a[j]);
                if (a[i]>a[j]){
                    max = Math.max(max, dp[j]+1);
                }
            }
            if(max!=0){
                dp[i] = max;
            }

        }

        int max = 0;
        for (int i : dp) {
            if(max<i){
                max =i;
            }
        }

        return max;

    }
}
