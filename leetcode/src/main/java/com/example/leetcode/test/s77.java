package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class s77 {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

//    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
//    你可以按 任何顺序 返回答案


    public static List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        boolean[] selectable = new boolean[n];
        backtrack(n, k, now, 0);
        return res;
    }
    public static List<List<Integer>> res;
    public static void backtrack(int n, int k, List<Integer> now, int start){
        if (now.size()==k) {
            res.add(new ArrayList<>(now));
            return;
        }

        for (int i = start; i < n; i++) {
            now.add(i+1);
            backtrack(n, k, now, i+1);
            now.remove(now.size()-1);

        }

    }


}
