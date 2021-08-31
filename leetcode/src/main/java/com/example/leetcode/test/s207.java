package com.example.leetcode.test;

import java.util.LinkedList;
import java.util.List;

public class s207 {

    public static void main(String[] args) {
        int n = 2;
        int[][] pre = new int[][]{{1,0},{0,1}};

        System.out.println(canFinish(n, pre));

    }

//    你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//    在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/course-schedule
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    // 记录一次 traverse 递归经过的节点
    public static boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    public static boolean[] visited;
    // 记录图中是否有环
    public static boolean hasCircle = false;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCircle;

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

}
