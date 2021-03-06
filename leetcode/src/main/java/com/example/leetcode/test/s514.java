package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class s514 {

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";

        System.out.println(findRotateSteps(ring, key));
    }

//    电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
//
//    给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
//
//    最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
//
//    旋转 ring 拼出 key 字符 key[i] 的阶段中：
//
//    您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
//    如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/freedom-trail
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//    public static int findRotateSteps(String ring, String key) {
//
//        int m = ring.length();
//        int n = key.length();
//
//        int[][] dp = new int[m][n];
//
//        for (int i = m-1; i >= 0; i--) {
//            for (int j = n-1; j >= 0; j--) {
//
//            }
//        }
//
//    }

    // 备忘录方法(二维数组)
    public static int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        memo = new int[m][n];
        char2index = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            char2index.putIfAbsent(c, new ArrayList<>());
            char2index.get(c).add(i);
        }
        traverse(ring, 0, key, 0);
        return memo[0][0];

    }
    public static int[][] memo;
    public static HashMap<Character, ArrayList<Integer>> char2index;

    public static int traverse(String ring, int i, String key, int j){
        if (j==key.length()) {
            return 0;
        }
        if (memo[i][j]!=0) {
            return memo[i][j];
        }
        char c = key.charAt(j);
        int res = Integer.MAX_VALUE;
        for (Integer integer : char2index.get(c)) {
            int delta = Math.abs(integer - i);
            delta = Math.min(delta, ring.length()-delta);
            int sub = traverse(ring, integer, key, j+1);
            res = Math.min(res, 1 + sub + delta);
        }
        memo[i][j] = res;
        return res;
    }


//    // 备忘录方法(字符串)，耗时太长不推荐
//    public static int findRotateSteps(String ring, String key) {
//        int m = ring.length();
//        int n = key.length();
//        memo = new HashMap<>();
//        char2index = new HashMap<>();
//        for (int i = 0; i < m; i++) {
//            char c = ring.charAt(i);
//            char2index.putIfAbsent(c, new ArrayList<>());
//            char2index.get(c).add(i);
//        }
//        traverse(ring, 0, key, 0);
//        return memo.get("0,0");
//
//    }
//    public static HashMap<String, Integer> memo;
//    public static HashMap<Character, ArrayList<Integer>> char2index;
//
//    public static int traverse(String ring, int i, String key, int j){
//        if (j==key.length()) {
//            return 0;
//        }
//        String s = i+","+j;
//        if (memo.containsKey(s)) {
//            return memo.get(s);
//        }
//        char c = key.charAt(j);
//        int res = Integer.MAX_VALUE;
//        for (Integer integer : char2index.get(c)) {
//            int delta = Math.abs(integer - i);
//            delta = Math.min(delta, ring.length()-delta);
//            int sub = traverse(ring, integer, key, j+1);
//            res = Math.min(res, 1 + sub + delta);
//        }
//        memo.put(s, res);
//        return res;
//    }

}
