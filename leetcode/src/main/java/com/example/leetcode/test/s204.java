package com.example.leetcode.test;

import java.util.Arrays;

public class s204 {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

//    统计所有小于非负整数 n 的质数的数量。

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;

        for (int i=2; i*i<n; i++){
            if (isPrime[i]){
                for (int j=i*i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i=2; i<n; i++){
            if (isPrime[i]){
                count++;
            }
        }
        return count;
    }

}
