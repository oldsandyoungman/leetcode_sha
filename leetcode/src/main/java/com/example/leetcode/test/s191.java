package com.example.leetcode.test;

public class s191 {

    public static void main(String[] args) {
        int n = 0b11111111111111111111111111111101;
        System.out.println(hammingWeight(n));
    }

//    编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

    public static int hammingWeight(int n) {
        int res = 0;
        while (n!=0) {
            n = n & (n-1);
            res++;
        }
        return res;
    }

}
