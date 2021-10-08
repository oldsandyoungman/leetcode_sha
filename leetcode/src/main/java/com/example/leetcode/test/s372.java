package com.example.leetcode.test;

public class s372 {

    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = {2,0,0};
        System.out.println(superPow(a,b));
    }

//    你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。

    public static int base = 1337;
    public static int superPow(int a, int[] b) {
        int m = b.length;
        int res = 1;
        for (int j : b) {
            int res1 = mypow(a, j);
            res = mypow(res, 10);
            res = (res * res1) % base;
        }
        return res;
    }
    public static int mypow(int a, int k){
        if (k==0){
            return 1;
        }

        a %= base;

        if (k%2==1){
            return (a*mypow(a,k-1))%base;
        }

        int kk = k/2;
        int res = mypow(a, kk);
        return (res*res)%base;

    }

}
