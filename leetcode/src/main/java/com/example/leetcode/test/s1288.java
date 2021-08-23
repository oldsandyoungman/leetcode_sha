package com.example.leetcode.test;

import java.util.Arrays;

public class s1288 {

    public static void main(String[] args) {
//        int[][] intvs = new int[][]{{1,4},{3,6},{2,8}};
        int[][] intvs = new int[][]{{1,4},{1,4}};
//        int[][] intvs = new int[][]{{1,2},{1,4},{3,4}};




        System.out.println(removeCoveredIntervals(intvs));

    }

//    给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
//
//    只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
//
//    在完成所有删除操作后，请你返回列表中剩余区间的数目。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/remove-covered-intervals
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0]==o2[0]) {
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;

        for (int i = 1; i < n; i++) {
            int[] intv = intervals[i];
            if (left<=intv[0] && right>=intv[1]) {
                res++;
            }
            if (right>=intv[0] && right<=intv[1]) {
                right = intv[1];
            }
            if (right<intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        return n-res;
    }

}
