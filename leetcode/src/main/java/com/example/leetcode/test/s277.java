package com.example.leetcode.test;

import java.util.LinkedList;

public class s277 {

    public static void main(String[] args) {
        System.out.println(findCelebrity(4));
    }

//    今天来讨论经典的「名流问题」：
//
//    给你 n 个人的社交关系（你知道任意两个人之间是否认识），然后请你找出这些人中的「名人」。
//
//    所谓「名人」有两个条件：
//
//            1、所有其他人都认识「名人」。
//
//            2、「名人」不认识任何其他人。
//
//    这是一个图相关的算法问题，社交关系嘛，本质上就可以抽象成一幅图。
//
//    如果把每个人看做图中的节点，「认识」这种关系看做是节点之间的有向边，那么名人就是这幅图中一个特殊的节点：
//
//
//    这个节点没有一条指向其他节点的有向边；且其他所有节点都有一条指向这个节点的有向边。
//
//    或者说的专业一点，名人节点的出度为 0，入度为 n - 1。
//
//    那么，这 n 个人的社交关系是如何表示的呢？
//
//    前文 图论算法基础 说过，图有两种存储形式，一种是邻接表，一种是邻接矩阵，邻接表的主要优势是节约存储空间；邻接矩阵的主要优势是可以迅速判断两个节点是否相邻。
//
//    对于名人问题，显然会经常需要判断两个人之间是否认识，也就是两个节点是否相邻，所以我们可以用邻接表来表示人和人之间的社交关系。
//
//    那么，把名流问题描述成算法的形式就是这样的：
//
//    给你输入一个大小为 n x n 的二维数组（邻接矩阵） graph 表示一幅有 n 个节点的图，每个人都是图中的一个节点，编号为 0 到 n - 1。
//
//    如果 graph[i][j] == 1 代表第 i 个人认识第 j 个人，如果 graph[i][j] == 0 代表第 i 个人不认识第 j 个人。
//
//    有了这幅图表示人与人之间的关系，请你计算，这 n 个人中，是否存在「名人」？
//
//    如果存在，算法返回这个名人的编号，如果不存在，算法返回 -1。

    public static int[][] graph = new int[][]{
            {1,1,1,0},
            {1,1,1,1},
            {0,0,1,0},
            {0,0,1,1}
    };

    // 可以直接调用，能够返回 i 是否认识 j
    public static boolean knows(int i, int j){
        return graph[i][j] == 1;
    }

    // 请你实现：返回「名人」的编号
    public static int findCelebrity(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        while (list.size()>1){
            int can = list.removeFirst();
            int oth = list.removeFirst();

            if (knows(can, oth) || !knows(oth, can)) {
                list.addFirst(oth);
            }else {
                list.addFirst(can);
            }
        }

        int can = list.removeFirst();
        for (int i = 0; i < n; i++) {
            if (can==i){
                continue;
            }
            if (knows(can,i) || !knows(i, can)){
                return -1;
            }
        }
        return can;

    }

}
