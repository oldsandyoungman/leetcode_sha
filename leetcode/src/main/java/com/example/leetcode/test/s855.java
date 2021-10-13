package com.example.leetcode.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class s855 {

    public static void main(String[] args) {

        int n = 10;
        int p =4;
        ExamRoom obj = new ExamRoom(n);
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        System.out.println(obj.seat());
        obj.leave(p);
        System.out.println(obj.seat());

        System.out.println("666");

//        输出：[null,0,9,4,2,null,5]


    }

//    在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
//
//    当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
//
//    返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/exam-room
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}



//class ExamRoom {
//
//    // 将端点 p 映射到以 p 为左端点的线段
//    private Map<Integer, int[]> startMap;
//    // 将端点 p 映射到以 p 为右端点的线段
//    private Map<Integer, int[]> endMap;
//    // 根据线段长度从小到大存放所有线段
//    private TreeSet<int[]> pq;
//    private int N;
//
//    public ExamRoom(int N) {
//        this.N = N;
//        startMap = new HashMap<>();
//        endMap = new HashMap<>();
//        pq = new TreeSet<>((a, b) -> {
//            int distA = distance(a);
//            int distB = distance(b);
//            // 如果长度相同，就比较索引
//            if (distA == distB)
//                return b[0] - a[0];
//            return distA - distB;
//        });
//        // 在有序集合中先放一个虚拟线段
//        addInterval(new int[] {-1, N});
//    }
//
//    /* 去除一个线段 */
//    private void removeInterval(int[] intv) {
//        pq.remove(intv);
//        startMap.remove(intv[0]);
//        endMap.remove(intv[1]);
//    }
//
//    /* 增加一个线段 */
//    private void addInterval(int[] intv) {
//        pq.add(intv);
//        startMap.put(intv[0], intv);
//        endMap.put(intv[1], intv);
//    }
//
//    /* 计算一个线段的长度 */
//    private int distance(int[] intv) {
//        int x = intv[0];
//        int y = intv[1];
//        if (x == -1) return y;
//        if (y == N) return N - 1 - x;
//        // 中点和端点之间的长度
//        return (y - x) / 2;
//    }
//
//
//    public int seat() {
//        // 从有序集合拿出最长的线段
//        int[] longest = pq.last();
//        int x = longest[0];
//        int y = longest[1];
//        int seat;
//        if (x == -1) { // 情况一
//            seat = 0;
//        } else if (y == N) { // 情况二
//            seat = N - 1;
//        } else { // 情况三
//            seat = (y - x) / 2 + x;
//        }
//        // 将最长的线段分成两段
//        int[] left = new int[] {x, seat};
//        int[] right = new int[] {seat, y};
//        removeInterval(longest);
//        addInterval(left);
//        addInterval(right);
//        return seat;
//    }
//
//    public void leave(int p) {
//        // 将 p 左右的线段找出来
//        int[] right = startMap.get(p);
//        int[] left = endMap.get(p);
//        // 合并两个线段成为一个线段
//        int[] merged = new int[] {left[0], right[1]};
//        removeInterval(left);
//        removeInterval(right);
//        addInterval(merged);
//    }
//
//}
//
///*
// * Your ExamRoom object will be instantiated and called as such:
// * ExamRoom obj = new ExamRoom(n);
// * int param_1 = obj.seat();
// * obj.leave(p);
// */




class ExamRoom {

    HashMap<Integer, int[]> startmap;
    HashMap<Integer, int[]> endmap;
    TreeSet<int[]> pq;
    int N;

    public ExamRoom(int n) {
        startmap = new HashMap<>();
        endmap = new HashMap<>();
        pq = new TreeSet<>((a,b) -> {
            int dis_a = distance(a);
            int dis_b = distance(b);

            if (dis_a==dis_b){
                return b[0]-a[0];
            }else {
                return dis_a-dis_b;
            }
        });
        this.N = n;
        int[] temp = new int[]{-1, n};
        pq.add(temp);
        startmap.put(-1, temp);
        endmap.put(n, temp);
    }

    public int distance(int[] s){
        int left = s[0];
        int right = s[1];

        if (left==-1){
            return right;
        }else if(right==N){
            return N-left-1;
        }else {
            return (right-left)/2;
        }

    }

    public void addman(int[] intv){
        pq.add(intv);
        startmap.put(intv[0], intv);
        endmap.put(intv[1], intv);
    }
    public void removeman(int[] intv){
        pq.remove(intv);
        startmap.remove(intv[0]);
        endmap.remove(intv[1]);
    }

    public int seat() {
        int[] last = pq.last();
        int left = last[0];
        int right = last[1];
        int s;
        if (left==-1){
            s = 0;
        }else if (right==N){
            s = N-1;
        }else {
            s = left + (right-left)/2;
        }
        removeman(last);
        addman(new int[]{left, s});
        addman(new int[]{s, right});
        return s;
    }

    public void leave(int p) {
        int[] left = endmap.get(p);
        int[] right = startmap.get(p);
        removeman(left);
        removeman(right);
        addman(new int[]{left[0], right[1]});
    }
}