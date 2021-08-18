package com.example.leetcode.test;

public class s96 {

    public static void main(String[] args) {

        System.out.println(numTrees(3));

    }

//    给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

    public static int[] memo;

    public static int numTrees(int n) {
        memo = new int[n];
        return count(1, n);
    }

    public static int count(int lo, int hi){

        if (lo>hi) {
            return 1;
        }

        if (memo[hi-lo]!=0) {
            return memo[hi-lo];
        }

        int res =0;
        for (int i = lo; i <= hi; i++) {
            int left = count(lo, i-1);
            int right = count(i+1, hi);
            res += left * right;
        }

        memo[hi-lo] = res;
        return res;

    }


//    public static int count(int lo, int hi){
//
//        if (lo>hi) {
//            return 1;
//        }
//
//        int res =0;
//
//        for (int i = lo; i <= hi; i++) {
//            int left, right;
//            if (memo[lo][i-1]==0) {
//                left = count(lo, i-1);
//                memo[lo][i-1] = left;
//            }else {
//                left = memo[lo][i-1];
//            }
//            System.out.println("i+1:"+(i+1));
//            System.out.println(hi);
//            if (memo[i+1][hi]==0) {
//                right = count(i+1, hi);
//                memo[i+1][hi] = right;
//            }else {
//                right = memo[i+1][hi];
//            }
//
//            res += left * right;
//
//        }
//
//        return res;
//
//    }

}
