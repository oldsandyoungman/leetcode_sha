package com.example.leetcode.test;

import java.lang.Math;

public class s1978 {
    public static void main(String[] args) {

//        int num = 4;
        int num = 5;
//        int num = 449572;
//        int num = 971131546;




//        int x = 1, y = 2;
        int x = 1, y = 3;
//        int x = 209397, y = 306801;
//        int x = 966980466, y = 531910024;
        System.out.println(orchestraLayout(num, x, y));

////        int[][] std_sha = {{1,2,3,4,5},{7,8,9,1,6},{6,6,7,2,7},{5,5,4,3,8},{4,3,2,1,9}};
//        int[][] std_sha = {{1,2,3,4},{3,4,5,5},{2,7,6,6},{1,9,8,7}};
//
//        for (int i = 0; i < num; i++) {
//            for (int j = 0; j < num; j++) {
//                if(std_sha[i][j]!=orchestraLayout(num,i,j)){
//                    System.out.println("wrong"+i+","+"j");
//                }
//            }
//        }


    }

//    某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
//
//    为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
//
//
//
//    请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。


//    public static int orchestraLayout(int num, int xPos, int yPos) {
//
//
//        int dis = 0;
//        int big = 0;
//        double small = 0;
//        int N0 = 0;
//
//
//
//        if (num % 2 == 1) {
//
//            int half = (num - 1) / 2;
//            int x_re = xPos - half;
//            int y_re = yPos - half;
//
//            dis = Math.max(Math.abs(x_re), Math.abs(y_re));
//            big = complete_length(num, dis);
//            N0 = half - dis;
//
//            if (x_re == -half + N0) {
////                左上角的坐标
//                small = y_re - (-half + N0);
//
//            }else {
//                if(y_re == half - N0){
//                    small = (num-1-2*N0) + x_re - (-half + N0);
//                }else {
//                    if(x_re == half - N0){
//                        small = 2*(num-1-2*N0) + half - N0 - y_re;
//                    }else {
//                        small = 3*(num-1-2*N0) + half - N0 - x_re;
//                    }
//                }
//
//            }
//
//            return (int)(big + small)%9 + 1;
//
//
//        }else {
//
//            double half = (num - 1) / 2.0;
//            int half_int = (int) Math.ceil(half);
//            double x_re = xPos - half;
//            double y_re = yPos - half;
//
//            dis = (int) Math.ceil(Math.max(Math.abs(x_re), Math.abs(y_re)));
//            big = complete_length(num, dis);
//            N0 = half_int - dis;
//
//            if (x_re == -half + N0) {
////                左上角的坐标
//                small = y_re - (-half + N0);
//
//            }else {
//                if(y_re == half - N0){
//                    small = (num-1-2*N0) + x_re - (-half + N0);
//                }else {
//                    if(x_re == half - N0){
//                        small = 2*(num-1-2*N0) + half - N0 - y_re;
//                    }else {
//                        small = 3*(num-1-2*N0) + half - N0 - x_re;
//                    }
//                }
//
//            }
//
//            return (int)(big + small)%9 + 1;
//        }
//
//
//
//    }
//
//    public static int complete_length(int num, int dis) {
//        int half = num / 2;
//        int result = 0;
//
//        for (int i = 0; i < (half - dis); i++) {
//            int temp = 4 * (num%9 - 1 - 2 * i);
//            while (temp<0){
//                temp += 9;
//            }
//            result += temp;
//            if(result<0){
//                System.out.println("something wrong");
//            }
//        }
//
//        return result%9;
//
//    }

    public static int orchestraLayout(int n, int xPos, int yPos) {
        //一共几圈
        int quan=(n+1)/2;
        long num=n;
        //第几圈
        int layer = Math.min(Math.min(yPos,xPos),Math.min( n - xPos - 1, n - yPos - 1))+1;
        //总面积
        long area=num*num;
        //当前所在圈面积
        long zhong=(num-2*(layer-1));
        zhong*=zhong;
        //求差 +1 得到当前圈左上角编号
        long index=(area-zhong)%9+1;
        //右边界
        int right=n-layer;
        //左边界
        int left=layer-1;
        if(xPos==left){
            //在 --- 上
            index+=yPos-left;
        }else if(yPos==right){
            //在   |上
            index+=right-left;
            index+=xPos-left;
        }else if(xPos==right){
            //在 __ 上
            index+=2*(right-left);
            index+=right-yPos;
        }else{
            //在 |  上
            index+=3*(right-left);
            index+=right-xPos;
        }
        return (int)(index%9==0?9:index%9);
    }


}
