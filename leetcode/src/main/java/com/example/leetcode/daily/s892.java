package com.example.leetcode.daily;

public class s892 {

    public static void main(String[] args) {
//        int[][] grid = {{1,2},{3,4}};
        int[][] grid = {{1,0},{0,2}};
        System.out.println(surfaceArea(grid));
        System.out.println(surfaceArea2(grid));
    }


//    给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
//
//    每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
//
//    放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
//
//    请你返回最终这些形体的总表面积。
//
//    注意：每个形体的底面也需要计入表面积中。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // 只减自己的
    public static int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int sum = 0;
        int sub = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                sum += cur;
                sub += cur>0?2*(cur-1):0;

                if (j>0) {
                    int left = grid[i][j-1];
                    sub += Math.min(cur, left);
                }
                if (j<n-1){
                    int right = grid[i][j+1];
                    sub += Math.min(cur, right);
                }
                if (i>0){
                    int up = grid[i-1][j];
                    sub += Math.min(cur, up);
                }
                if (i<m-1){
                    int down = grid[i+1][j];
                    sub += Math.min(cur,down);
                }
            }
        }

        return 6*sum-sub;


    }

    // 把相邻的一起减了
    public static int surfaceArea2(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                sum += cur>0?2 + 4*cur:0;

                if (j>0) {
                    int left = grid[i][j-1];
                    sum -= 2*Math.min(cur, left);
                }
                if (i>0){
                    int up = grid[i-1][j];
                    sum -= 2*Math.min(cur, up);
                }
            }
        }

        return sum;


    }

//    public static int sub_sha(int cur, int other){
//        if (cur<=other){
//            return cur;
//        }else {
//            return other;
//        }
//    }

}
