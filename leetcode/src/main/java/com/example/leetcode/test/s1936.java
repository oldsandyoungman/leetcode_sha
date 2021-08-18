package com.example.leetcode.test;

public class s1936 {
    public static void main(String[] args) {

//        int[] xx = {1, 3, 5, 10};
//        int[] xx = {3,6,8,10};
//        int[] xx = {3,4,6,7};
        int[] xx = {5};

//        int dist = 2;
//        int dist = 3;
        int dist = 10;

        System.out.println(addRungs(xx, dist));

    }

//    给你一个 严格递增 的整数数组 rungs ，用于表示梯子上每一台阶的 高度 。当前你正站在高度为 0 的地板上，并打算爬到最后一个台阶。
//
//    另给你一个整数 dist 。每次移动中，你可以到达下一个距离你当前位置（地板或台阶）不超过 dist 高度的台阶。当然，你也可以在任何正 整数 高度处插入尚不存在的新台阶。
//
//    返回爬到最后一阶时必须添加到梯子上的 最少 台阶数。

    public static int addRungs(int[] rungs, int dist) {

        int gap = 0;
        int c = 0;

        for (int i = 0; i < rungs.length; i++) {
            if (i == 0) {
                gap = rungs[i];
            }else {
                gap = rungs[i]-rungs[i-1];
            }

            while (gap>dist){
                gap -= dist;
                c++;
            }
        }


        return c;

    }

}
