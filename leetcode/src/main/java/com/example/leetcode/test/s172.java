package com.example.leetcode.test;

public class s172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(125));
    }


//    给定一个整数 n ，返回 n! 结果中尾随零的数量。
//
//    提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1


    public static int trailingZeroes(int n) {
        int div = 5;
        int res = 0;
        while (div<=n) {
            res += n/div;
            div *= 5;
        }
        return res;
    }

}
