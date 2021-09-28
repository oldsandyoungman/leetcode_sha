package com.example.leetcode.test;

public class s651 {

    public static void main(String[] args) {
//        int N = 3;
        int N = 7;

        System.out.println(maxA(N));
    }

//    假设你有一个特殊的键盘包含下面的按键︰Key 1: (A)∶在屏幕上打印一个'A。
//    Key 2: (ctrl-A)∶选中整个屏幕。
//    Key 3: (ctrl-c)∶复制选中区域到缓冲区。
//    Key 4: (ctr1-v)∶将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。现在，你只可以按键Ⅳ次(使用上述四种按键)，请问屏幕上最多可以显示几个'A呢?


    public static int maxA(int N) {
        int[] dp = new int[N+1];

        // base case
//        dp[0] = 0;

        for (int i = 1; i <= N; i++) {

            int res = dp[i-1] + 1;
            for (int j = 2; j < i; j++) {
                res = Math.max(res, dp[j-2]*(i-j+1));
            }
            dp[i] = res;
        }

        return dp[N];

    }


}
