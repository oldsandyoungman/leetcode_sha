package com.example.leetcode.test;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.HashSet;

public class s391 {

    public static void main(String[] args) {
        int[][] rectangles = {
//                {1, 1, 3, 3},
//                {3, 1, 4, 2},
//                {3, 2, 4, 4},
//                {1, 3, 2, 4},
//                {2, 3, 3, 4}
                {1,1,2,3},
                {1,3,2,4},
                {3,1,4,2},
                {3,2,4,4}
        };
        System.out.println(isRectangleCover(rectangles));

    }

//    我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
//
//    每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/perfect-rectangle
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean isRectangleCover(int[][] rectangles) {

        int X1 = Integer.MAX_VALUE;
        int Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE;
        int Y2 = Integer.MIN_VALUE;

        HashSet<String> memo = new HashSet<>();

        int actual_area = 0;

        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];

            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);

            int now_area = (x2-x1)*(y2-y1);
            actual_area += now_area;

            String p1 = x1+","+y1;
            String p2 = x1+","+y2;
            String p3 = x2+","+y1;
            String p4 = x2+","+y2;

            if (memo.contains(p1)){
                memo.remove(p1);
            }else {
                memo.add(p1);
            }

            if (memo.contains(p2)){
                memo.remove(p2);
            }else {
                memo.add(p2);
            }

            if (memo.contains(p3)){
                memo.remove(p3);
            }else {
                memo.add(p3);
            }

            if (memo.contains(p4)){
                memo.remove(p4);
            }else {
                memo.add(p4);
            }

        }

        int pre_area = (X2-X1)*(Y2-Y1);

        if (pre_area!=actual_area) {
            return false;
        }

        if (memo.size()!=4){
            return false;
        }

        String fin_p1 = X1+","+Y1;
        String fin_p2 = X1+","+Y2;
        String fin_p3 = X2+","+Y1;
        String fin_p4 = X2+","+Y2;

        if (!memo.contains(fin_p1)){
            return false;
        }
        if (!memo.contains(fin_p2)){
            return false;
        }
        if (!memo.contains(fin_p3)){
            return false;
        }
        if (!memo.contains(fin_p4)){
            return false;
        }

        return true;

    }

}
