package com.example.leetcode.test;

import java.util.Arrays;

public class s986 {

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        System.out.println(Arrays.deepToString(intervalIntersection(firstList, secondList)));
        System.out.println(Arrays.deepToString(intervalIntersection2(firstList, secondList)));

    }

//    给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
//
//    返回这 两个区间列表的交集 。
//
//    形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
//
//    两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/interval-list-intersections
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0, j=0;

        int[][] res = new int[firstList.length+secondList.length][2];
        int idx = 0;

        while (i<firstList.length && j<secondList.length) {

            int a1 = firstList[i][0];
            int a2 = firstList[i][1];
            int b1 = secondList[j][0];
            int b2 = secondList[j][1];

            if (b2>=a1 && a2>=b1) {
                res[idx] = new int[]{Math.max(a1,b1), Math.min(a2,b2)};
                idx++;
            }
            if (b2<a2) {
                j++;
            }else {
                i++;
            }

        }

        return Arrays.copyOf(res, idx);
    }

    public static int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        int n1 = firstList.length;
        int n2 = secondList.length;
        int[][] res = new int[n1+n2][2];

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i<n1 && j<n2) {

            int a1 = firstList[i][0];
            int a2 = firstList[i][1];
            int b1 = secondList[j][0];
            int b2 = secondList[j][1];

            if (a1<=b2 && b1<=a2) {
                res[idx][0] = Math.max(a1,b1);
                res[idx][1] = Math.min(a2,b2);
//                res[idx] = new int[]{Math.max(a1,b1), Math.min(a2,b2)};
                idx++;
            }

            if (a2<=b2) {
                i++;
            }

            if (a2>b2) {
                j++;
            }

        }

        return Arrays.copyOf(res, idx);

    }


}
