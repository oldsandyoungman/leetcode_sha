package com.example.leetcode.daily;

import java.util.Arrays;

public class s1996 {

    public static void main(String[] args) {
//        int[][] s = {{1,5},{10,4},{4,3}};
//        int[][] s = {{1,1},{1,2},{2,1}, {2,2}};
        int[][] s = {{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
        System.out.println(numberOfWeakCharacters2(s));
    }

//    你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
//
//    如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
//
//    返回 弱角色 的数量。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    // 没做出来
//    public static int numberOfWeakCharacters(int[][] properties) {
//        Arrays.sort(properties, (o1, o2) -> {
//            if (o1[0]==o2[0]){
//                return Integer.compare(o1[1], o2[1]);
//            }else {
//                return Integer.compare(o2[0], o1[0]);
//            }
//        });
//
//        int n = properties.length;
//
//        int sum = 0;
//
//        int last0 = properties[0][0];
//        int last1 = properties[0][1];
//
//        for (int i = 1; i < n; i++) {
//            int cur0 = properties[i][0];
//            int cur1 = properties[i][1];
//            if (last0==cur0){
//                last1 = cur1;
//                continue;
//            }
//            if (last1<cur1){
//                sum++;
//            }
//            last0 = cur0;
//            last1 = cur1;
//        }
//        return sum;
//    }


    public static int numberOfWeakCharacters2(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0]==o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }else {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        int max_def = properties[0][1];
        int n = properties.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (properties[i][1]<max_def){
                sum++;
            }else {
                max_def = properties[i][1];
            }
        }
        return sum;

    }


}
