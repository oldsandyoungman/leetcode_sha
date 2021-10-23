package com.example.leetcode.daily.mian_shi_ti;

import java.util.Arrays;

public class s492 {

    public static void main(String[] args) {
//        int a = 122122;
        int a = 37;

        System.out.println(Arrays.toString(constructRectangle(a)));

    }

//    作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
//
//            1. 你设计的矩形页面必须等于给定的目标面积。
//
//            2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
//
//            3. 长度 L 和宽度 W 之间的差距应当尽可能小。
//    你需要按顺序输出你设计的页面的长度 L 和宽度 W。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/construct-the-rectangle
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[] constructRectangle(int area) {

        int gen = (int) Math.sqrt(area);

        for (int i = gen; i > 0; i--) {
            if (area%i==0){
                return new int[]{area/i, i};
            }
        }
        return new int[]{area, 1};

    }


}
