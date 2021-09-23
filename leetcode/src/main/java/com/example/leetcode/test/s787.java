package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class s787 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        System.out.println(findCheapestPrice(n, edges, src, dst, k));

    }

//    有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
//
//    现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        src_fin = src;
        dst_fin = dst;

        map = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            map.putIfAbsent(to, new ArrayList<>());
            map.get(to).add(new int[]{from, price});
        }

        k++;

        memo = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -888);
        }

        dp(dst, k);

        return memo[dst][k];

    }
    public static int[][] memo;
    public static HashMap<Integer, List<int[]>> map;
    public static int src_fin;
    public static int dst_fin;
    public static int dp(int s, int k){

        printspace(count_sha++);
        System.out.print("s="+s+",k="+k+'\n');

        if (s==src_fin){
            memo[s][k]=0;
            printspace(--count_sha);
            System.out.print("prices=0"+'\n');

            return 0;
        }

        if (k<=0){
            printspace(--count_sha);
            System.out.print("prices=-1"+'\n');
            return -1;
        }

        if (memo[s][k]!=-888){
            printspace(--count_sha);
            System.out.print("prices="+memo[s][k]+'\n');
            return memo[s][k];
        }
        int res = Integer.MAX_VALUE;
        if (map.containsKey(s)){
            for (int[] ints : map.get(s)) {
                int from = ints[0];
                int prices = ints[1];

                int pre = dp(from, k - 1);
                if (pre!=-1){
                    res = Math.min(res, pre+prices);
                }

            }
        }

        memo[s][k] = res==Integer.MAX_VALUE?-1:res;

        printspace(--count_sha);
        System.out.print("prices="+memo[s][k]+'\n');

        return memo[s][k];

    }

    public static int count_sha = 0;
    public static void printspace(int count){
        for (int i = 0; i < count; i++) {
            System.out.print("  ");
        }
    }

}
