package com.example.leetcode.test;

public class s174 {

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2, -3, 3},{-5, -10, 1},{10, 30, -5}};


        System.out.println(calculateMinimumHP(dungeon));

    }

//    一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
//
//    骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
//
//    有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
//
//    为了尽快到达公主，骑士决定每次只向右或向下移动一步。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/dungeon-game
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = dungeon[m-1][n-1]>=0?1:1-dungeon[m-1][n-1];

        for (int i = m-2; i >= 0; i--) {
            int res = dp[i+1][n-1] - dungeon[i][n-1];
            dp[i][n-1] = res>0?res:1;
        }

        for (int i = n-2; i >= 0; i--) {
            int res = dp[m-1][i+1] - dungeon[m-1][i];
            dp[m-1][i] = res>0?res:1;
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int res = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = res>0?res:1;
            }
        }

        return dp[0][0];

    }


}
