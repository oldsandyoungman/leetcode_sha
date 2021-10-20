package com.example.leetcode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s554 {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
//        List<Integer> w1 = new ArrayList<>();
//        w1.add(1);
//        w1.add(2);
//        w1.add(2);
//        w1.add(1);
//        wall.add(w1);
//
//        List<Integer> w2 = new ArrayList<>();
//        w2.add(3);
//        w2.add(1);
//        w2.add(2);
//        wall.add(w2);
//
//        List<Integer> w3 = new ArrayList<>();
//        w3.add(1);
//        w3.add(3);
//        w3.add(2);
//        wall.add(w3);
//
//        List<Integer> w4 = new ArrayList<>();
//        w4.add(2);
//        w4.add(4);
//        wall.add(w4);
//
//
//        List<Integer> w5 = new ArrayList<>();
//        w5.add(3);
//        w5.add(1);
//        w5.add(2);
//        wall.add(w5);
//
//        List<Integer> w6 = new ArrayList<>();
//        w6.add(1);
//        w6.add(3);
//        w6.add(1);
//        w6.add(1);
//        wall.add(w6);








//
//        List<Integer> w1 = new ArrayList<>();
//        w1.add(1);
//        wall.add(w1);
//
//        List<Integer> w2 = new ArrayList<>();
//        w2.add(1);
//        wall.add(w2);
//
//        List<Integer> w3 = new ArrayList<>();
//        w3.add(1);
//        wall.add(w3);





        List<Integer> w1 = new ArrayList<>();
        w1.add(6);
        w1.add(2);
        w1.add(2);
        wall.add(w1);

        List<Integer> w2 = new ArrayList<>();
        w2.add(1);
        w2.add(4);
        w2.add(4);
        w2.add(1);
        wall.add(w2);

        List<Integer> w3 = new ArrayList<>();
        w3.add(2);
        w3.add(5);
        w3.add(3);
        wall.add(w3);


        System.out.println(leastBricks(wall));

    }

//    你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
//
//    你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
//
//    给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/brick-wall
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        HashMap<Integer, Integer> fre = new HashMap<>();
        int max = 0;

        for (List<Integer> integers : wall) {
            int sum = 0;
            for (int i = 0; i < integers.size()-1; i++) {
                sum += integers.get(i);
                int temp = fre.getOrDefault(sum, 0)+1;
                fre.put(sum, temp);
                max = Math.max(max, temp);
            }

        }

        return n-max;

    }


}
