package com.example.leetcode.test;

import java.util.*;

public class s752 {

    public static void main(String[] args) {
//        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String[] deadends = new String[]{"0000"};
        String target = "8888";
        System.out.println(openLock(deadends, target));
    }

//    你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//
//    锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//
//    列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//
//    字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/open-the-lock
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//    public static int openLock(String[] deadends, String target) {
//        Set<String> visited = new HashSet<>();
//        Collections.addAll(visited, deadends);
//        Queue<String> q = new LinkedList<>();
//        q.offer("0000");
//        visited.add("0000");
//        int step = 0;
//
//        while (!q.isEmpty()){
//
//        }
//    }

    public static int openLock(String[] deadends, String target) {
//        Set<String> deadset = new HashSet<>();
//        Collections.addAll(deadset, deadends);

        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);
        if (visited.contains("0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up_sha(cur,j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = down_sha(cur,j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }

        return -1;






    }

    private static String up_sha(String cur, int i) {
        char[] c = cur.toCharArray();
        if (c[i]=='9') {
            c[i] = '0';
        }else {
            c[i] += 1;
        }
        return new String(c);
    }
    private static String down_sha(String cur, int i) {
        char[] c = cur.toCharArray();
        if (c[i]=='0') {
            c[i] = '9';
        }else {
            c[i] -= 1;
        }
        return new String(c);
    }

}
