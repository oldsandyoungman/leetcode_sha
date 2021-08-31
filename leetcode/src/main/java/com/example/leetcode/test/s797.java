package com.example.leetcode.test;

import java.util.LinkedList;
import java.util.List;

public class s797 {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

//    给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
//
//    二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
//
//    译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<List<Integer>> res;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }


    public static void traverse(int[][] graph, int s, LinkedList<Integer> path){
        int n = graph.length;
        if (s==n-1) {
            path.add(s);
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        path.add(s);
        for (int i : graph[s]) {
            traverse(graph, i, path);
        }
        path.removeLast();

    }

}
