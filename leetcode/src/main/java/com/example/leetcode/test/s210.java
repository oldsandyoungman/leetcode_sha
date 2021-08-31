package com.example.leetcode.test;

import java.util.*;

public class s210 {

    public static void main(String[] args) {
        int n = 4;
        int[][] pre = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(findOrder(n, pre)));
    }

//    现在你总共有 n 门课需要选，记为 0 到 n-1。
//
//    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
//
//    给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
//
//    可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/course-schedule-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    // 记录一次 traverse 递归经过的节点
    public static boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    public static boolean[] visited;
    // 记录图中是否有环
    public static boolean hasCircle = false;
    // 记录后序遍历结果
    private static List<Integer> postorder = new ArrayList<>();

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = build(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse3(graph, i);
        }

        if (hasCircle) {
            return new int[]{};
        }

        // 将后序遍历结果反转，转化成 int[] 类型
        Collections.reverse(postorder);

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;

    }

    private static void traverse3(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCircle = true;
        }

        if (visited[s] || hasCircle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for (Integer nxt : graph[s]) {
            traverse3(graph, nxt);
        }

        postorder.add(s);

        onPath[s] = false;


    }

    public static List<Integer>[] build(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }










    public static int[] findOrder2(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = build(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCircle) {
            return new int[]{};
        }

        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse2(graph, i);
        }

        // 将后序遍历结果反转，转化成 int[] 类型
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;

    }

    private static void traverse2(List<Integer>[] graph, int s) {
        print_space(space_num++);
        System.out.print("s="+s+'\n');
        if (visited[s]) {
            print_space(--space_num);
            System.out.print("return:visited"+'\n');
            return;
        }

        visited[s] = true;

        for (Integer nxt : graph[s]) {
            traverse2(graph, nxt);
        }

        postorder.add(s);

        print_space(--space_num);
        System.out.print("return"+'\n');
    }






    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCircle;

    }



    public static void traverse(List<Integer>[] graph, int s){
        if (onPath[s]) {
            hasCircle = true;
        }

        if (visited[s] || hasCircle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for (Integer nxt : graph[s]) {
            traverse(graph, nxt);
        }

        onPath[s] = false;


    }




    public static int space_num = 0;
    public static void print_space(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }



}
