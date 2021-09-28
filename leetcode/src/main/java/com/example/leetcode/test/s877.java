package com.example.leetcode.test;

public class s877 {

    public static void main(String[] args) {
//        int[] piles = new int[]{5,3,4,5};
        int[] piles = new int[]{3,7,2,3};
        System.out.println(stoneGame(piles));
    }

//    亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
//
//    游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
//
//    亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
//
//    假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/stone-game
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        pair_sha[][] dp = new pair_sha[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new pair_sha(0,0);
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {

                // 下面注释的是错误解法
//                dp[i][j].fir = Math.max(
//                        dp[i+1][j].sec + piles[i],
//                        dp[i][j-1].sec + piles[j]
//                );
//                dp[i][j].sec = Math.max(
//                        dp[i+1][j].fir,
//                        dp[i][j-1].fir
//                );

                int left = dp[i+1][j].sec + piles[i];
                int right = dp[i][j-1].sec + piles[j];
                if (left>right){
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                }else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }

            }
        }

        System.out.println(dp[0][n-1].fir-dp[0][n-1].sec);

        return dp[0][n-1].fir-dp[0][n-1].sec>0;

    }

}

class pair_sha{

    public int fir;
    public int sec;

    public pair_sha(int fir, int sec) {
        this.fir = fir;
        this.sec = sec;
    }


}
