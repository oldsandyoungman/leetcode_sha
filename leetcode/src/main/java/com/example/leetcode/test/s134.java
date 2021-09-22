package com.example.leetcode.test;

public class s134 {

    public static void main(String[] args) {

    }

//    在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//    你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
//    如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/gas-station
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }

        if (sum<0) {
            return -1;
        }

        int tank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank<0) {
                tank = 0;
                start = i+1;
            }
        }

        return start==n?0:start;
    }


}
