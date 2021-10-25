package com.example.leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;

public class s506 {

    public static void main(String[] args) {
        int[] s = new int[]{5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(findRelativeRanks(s)));
    }


//    给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
//
//            (注：分数越高的选手，排名越靠前。)
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/relative-ranks
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] r = new int[n][2];

        for (int i = 0; i < n; i++) {
            r[i][0] = score[i];
            r[i][1] = i;
        }

        Arrays.sort(r, (o1, o2) -> o2[0]-o1[0]);

        String[] res = new String[n];

        res[r[0][1]] = "Gold Medal";
        if (n>=2){
            res[r[1][1]] = "Silver Medal";
        }
        if (n>=3){
            res[r[2][1]] = "Bronze Medal";
        }

        for (int i = 3; i < n; i++) {
            res[r[i][1]] = Integer.toString(i+1);
        }

        return res;

    }


}
