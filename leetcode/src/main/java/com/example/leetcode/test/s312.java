package com.example.leetcode.test;

public class s312 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(maxCoins(nums));
    }

//    有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//
//    现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
//
//    求所能获得硬币的最大数量。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/burst-balloons
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];

        // dp[i][i] = 0;

        int[] points = new int[n+2];
        points[0] = 1;
        points[n+1] = 1;
//        for (int i = 1; i <= n; i++) {
//            points[i] = nums[i-1];
//        }
        System.arraycopy(nums, 0, points, 1, n);

        for (int i = n; i >= 0; i--) {
            for (int j = i+1; j <= n+1; j++) {
                int res = 0;
                for (int k = i+1; k < j; k++) {
                    res = Math.max(res, dp[i][k]+dp[k][j]+points[i]*points[j]*points[k]);
                }
                dp[i][j] = res;
            }
        }

        return dp[0][n+1];

    }


}
