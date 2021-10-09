package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s56 {

    public static void main(String[] args) {
        int[][] intvs = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intvs)));
        System.out.println(Arrays.deepToString(merge2(intvs)));
        System.out.println(Arrays.deepToString(merge3(intvs)));
    }

//    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/merge-intervals
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[][] merge2(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0]==o2[0]) {
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] intv = intervals[i];
            int[] last = list.getLast();
            if (intv[0]<=last[1]) {
                last[1] = Math.max(intv[1], last[1]);
            }else {
                list.add(intv);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            int[] cur = list.removeFirst();
            res[i][0] = cur[0];
            res[i][1] = cur[1];
        }

        return res;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0]==o2[0]) {
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });

        int[][] res = new int[intervals.length][2];
        int idx = -1;

        for (int[] intv : intervals) {
            if (idx == -1 || intv[0] > res[idx][1]) {
                idx++;
                res[idx] = intv;

            } else {
                res[idx][1] = Math.max(intv[1], res[idx][1]);
            }
        }

        return Arrays.copyOf(res,idx+1);
    }



    public static int[][] merge3(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0]==o2[0]){
                return Integer.compare(o2[1], o1[1]);
            }else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0]>end){
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][1]>end) {
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});

        int[][] res_array = new int[res.size()][2];
        for (int i = 0; i < res_array.length; i++) {
            res_array[i][0] = res.get(i)[0];
            res_array[i][1] = res.get(i)[1];
        }
        return res_array;

    }

}
