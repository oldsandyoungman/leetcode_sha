package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class s739 {

    public static void main(String[] args) {
        int[] s = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(s)));
    }

//    请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。


    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> s = new LinkedList<>();

        for(int i = temperatures.length-1; i>=0; i--){
            while (!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                s.pop();
            }
            res[i] = s.isEmpty()?0:s.peek()-i;
            s.push(i);
        }

        return res;

    }
}
