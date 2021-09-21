package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Comparator;

public class s435 {

    public static void main(String[] args) {
        int[][] s = new int[][]{{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(eraseOverlapIntervals(s));
    }

//    给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
//    注意:
//
//    可以认为区间的终点总是大于它的起点。
//    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/non-overlapping-intervals
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n==0){
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));
//        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o1[1], o2[1]);
//            }
//        });
        int count = 1;
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start>=x_end){
                count++;
                x_end = interval[1];
            }
        }

        return n - count;

    }

}
