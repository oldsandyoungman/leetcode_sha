package com.example.leetcode.labuladong;

import java.util.Arrays;

public class coincharge {

    public static int count_indent = 0;

    public static void main(String[] args) {
        int[] c = {1,2,5};
        int num = 11;
        int[] m = new int[num+1];
        Arrays.fill(m,-2);
//        System.out.println(coin(c,num));
//        System.out.println(coin_mem(c,num, m));
        System.out.println(coin_dp(c,num));

    }

    public static int coin(int[] c, int num){

        print_sha(count_indent++);
        System.out.print("num="+(num)+'\n');


        if (num == 0){
            print_sha(--count_indent);
            System.out.print("return=" + "0"+'\n');
            return 0;
        }

        int res;

        int min = Integer.MAX_VALUE;

        for (int i : c) {
            if(num<i){
                continue;
            }else {

                res = 1 + coin(c, num - i);
            }

            if (res == 0){
                continue;
            }

            if (res<min){
                min = res;
            }

        }

        if (min == Integer.MAX_VALUE){
            print_sha(--count_indent);
            System.out.print("return=" + "-1"+'\n');
            return -1;
        }else {
            print_sha(--count_indent);
            System.out.print("return=" + min+'\n');
            return min;
        }



    }

    public static int coin_mem(int[] c, int num, int[] m){

        print_sha(count_indent++);
        System.out.print("num="+(num)+'\n');


        if (num == 0){
            print_sha(--count_indent);
            System.out.print("return=" + "0"+'\n');
            return 0;
        }

        if(m[num]!=-2){
            print_sha(--count_indent);
            System.out.print("return=" + m[num]+'\n');
            return m[num];
        }

        int res;

        int min = Integer.MAX_VALUE;

        for (int i : c) {
            if(num<i){
                continue;
            }else {
                res = 1 + coin_mem(c, num - i, m);
            }

            if (res == 0){
                continue;
            }

            if (res<min){
                min = res;
            }

        }

        if (min == Integer.MAX_VALUE){
            print_sha(--count_indent);
            System.out.print("return=" + "-1"+'\n');
            return -1;
        }else {
            print_sha(--count_indent);
            System.out.print("return=" + min+'\n');

            m[num] = min;

            return min;
        }



    }

    public static int coin_dp(int[] c, int num){

        int[] dp = new int[num+1];
        Arrays.fill(dp, num+1);
        dp[0]=0;

        for (int i = 0; i < dp.length; i++) {

            for (int j : c) {

                if(i<j){
                    continue;
                }
                dp[i] = Math.min( dp[i], 1+dp[i-j]);

            }

        }
        return dp[num];
    }


    public static void print_sha(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }

}
