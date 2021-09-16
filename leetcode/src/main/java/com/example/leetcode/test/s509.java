package com.example.leetcode.test;

import java.util.Arrays;

public class s509 {

    public static void main(String[] args) {
        System.out.println(fib(3));
    }

//    斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//
//    F(0) = 0，F(1) = 1
//    F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//    给你 n ，请计算 F(n) 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/fibonacci-number
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static int[] memo;
//    public static int fib(int n) {
//        memo = new int[n+1];
//        traverse(n);
//        return memo[n];
//    }
//    public static void traverse(int n){
//        if (n==0){
//            return;
//        }
//        if (n==1) {
//            memo[1] = 1;
//            return;
//        }
//        if (memo[n]!=0){
//            return;
//        }
//        traverse(n-2);
//        traverse(n-1);
//        memo[n] = memo[n-1] + memo[n-2];
//    }


////    备忘录方法
//    public static int[] memo;
//    public static int fib(int n) {
//        memo = new int[n+1];
//        Arrays.fill(memo, -1);
//        traverse(n);
//        return memo[n];
//    }
//    public static int traverse(int n){
//        if (n==0 || n==1) {
//            return n;
//        }
//        if (memo[n]!=-1) {
//            return memo[n];
//        }
//        int res = traverse(n-2)+traverse(n-1);
//        memo[n] = res;
//        return res;
//    }



//    dp table方法
    public static int fib(int n) {
        if (n<=1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
