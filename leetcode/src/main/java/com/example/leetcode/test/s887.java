package com.example.leetcode.test;

import java.util.Arrays;

public class s887 {

    public static void main(String[] args) {
        int k = 2;
        int n = 6;

        System.out.println(superEggDrop(k,n));
    }

//    给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
//
//    已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
//
//    每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
//
//    请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/super-egg-drop
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    // 备忘录方法（超时了）
//    public static int superEggDrop(int k, int n) {
//        memo = new int[k+1][n+1];
//        for (int i = 0; i < memo.length; i++) {
//            Arrays.fill(memo[i], -1);
//        }
//
//
//        dp(k,n);
//        return memo[k][n];
//    }
//    public static int[][] memo;
//    public static int dp(int k, int n){
//
//        printspace(countspace++);
//        System.out.print("k="+k+",n="+n);
//        System.out.print('\n');
//
////        if (k==0) {
////            printspace(--countspace);
////            System.out.print("res="+0);
////            System.out.print('\n');
////            return 0;
////        }
//        if (k==1) {
//            printspace(--countspace);
//            System.out.print("res="+n);
//            System.out.print('\n');
//            memo[k][n] = n;
//            return n;
//        }
//        if (n==0) {
//            printspace(--countspace);
//            System.out.print("res="+0);
//            System.out.print('\n');
//            memo[k][n] = 0;
//            return 0;
//        }
//        if (memo[k][n]!=-1) {
//            printspace(--countspace);
//            System.out.print("res="+memo[k][n]);
//            System.out.print('\n');
//            return memo[k][n];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++) {
//            res = Math.min(res, 1 + Math.max(dp(k, n-i), dp(k-1, i-1)));
//        }
//        memo[k][n] = res;
//
//        printspace(--countspace);
//        System.out.print("res="+res);
//        System.out.print('\n');
//
//        return res;
//    }




    // 备忘录方法（二分搜索优化）
    public static int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        dp(k,n);
        return memo[k][n];
    }
    public static int[][] memo;
    public static int dp(int k, int n){

        printspace(countspace++);
        System.out.print("k="+k+",n="+n);
        System.out.print('\n');

//        if (k==0) {
//            printspace(--countspace);
//            System.out.print("res="+0);
//            System.out.print('\n');
//            return 0;
//        }
        if (k==1) {
            printspace(--countspace);
            System.out.print("res="+n);
            System.out.print('\n');
            memo[k][n] = n;
            return n;
        }
        if (n==0) {
            printspace(--countspace);
            System.out.print("res="+0);
            System.out.print('\n');
            memo[k][n] = 0;
            return 0;
        }
        if (memo[k][n]!=-1) {
            printspace(--countspace);
            System.out.print("res="+memo[k][n]);
            System.out.print('\n');
            return memo[k][n];
        }


//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++) {
//            res = Math.min(res, 1 + Math.max(dp(k, n-i), dp(k-1, i-1)));
//        }

        int lo = 1;
        int hi = n;
        int broken;
        int unbroken;
//        while (lo<=hi) {
//            int mid = lo + (hi-lo)/2;
//            broken = dp(k-1, mid-1);
//            unbroken = dp(k, n-mid);
//            if (broken>unbroken) {
//                hi = mid - 1;
//            }else if (broken<unbroken){
//                lo = mid + 1;
//            }else {
//                break;
//            }
//        }
//
//        int res = 1+Math.max(broken, unbroken);
//        memo[k][n] = res;
//        return res;
        int res = Integer.MAX_VALUE;
        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            broken = dp(k-1, mid-1);
            unbroken = dp(k, n-mid);
            if (broken>unbroken) {
                hi = mid - 1;
                res = Math.min(res, 1 + broken);
            }else {
                lo = mid + 1;
                res = Math.min(res, 1 + unbroken);
            }
        }

        memo[k][n] = res;
        return res;



//        if (broken==unbroken){
//            memo[k][n] = 1+broken;
//            printspace(--countspace);
//            System.out.print("res="+memo[k][n]);
//            System.out.print('\n');
//            return 1+broken;
//        }else {
//            int res = 1+Math.max(broken, unbroken);
//            memo[k][n] = res;
//            printspace(--countspace);
//            System.out.print("res="+memo[k][n]);
//            System.out.print('\n');
//            return res;
//        }

    }





//    // dp table 方法(超时)
//    public static int superEggDrop(int k, int n) {
//        int[][] dp = new int[k+1][n+1];
//
//        for (int i = 0; i <= k; i++) {
//            dp[i][0] = 0;
//            dp[i][1] = 1;
//        }
//
//        for (int i = 0; i <= n; i++) {
//            dp[0][i] = 0;
//            dp[1][i] = i;
//        }
//
//
//        for (int i = 2; i <= k; i++) {
//            for (int j = 2; j <= n; j++) {
//                int res = Integer.MAX_VALUE;
//                for (int m = 1; m <= j; m++) {
//                    res = Math.min(res, 1+Math.max(dp[i-1][m-1], dp[i][j-m]));
//                }
//                dp[i][j] = res;
//            }
//        }
//
//        return dp[k][n];
//
//    }


//    // dp table 方法(二分搜索法优化，好像优化不了)
//    public static int superEggDrop(int k, int n) {
//        int[][] dp = new int[k+1][n+1];
//
//        for (int i = 0; i <= k; i++) {
//            dp[i][0] = 0;
//            dp[i][1] = 1;
//        }
//
//        for (int i = 0; i <= n; i++) {
//            dp[0][i] = 0;
//            dp[1][i] = i;
//        }
//
//
//        for (int i = 2; i <= k; i++) {
//            for (int j = 2; j <= n; j++) {
////                int res = Integer.MAX_VALUE;
////                for (int m = 1; m <= j; m++) {
////                    res = Math.min(res, 1+Math.max(dp[i-1][m-1], dp[i][j-m]));
////                }
////                dp[i][j] = res;
//
//                int lo = 1;
//                int hi = j;
//
//                while (lo<=hi){
//                    int mid = lo + (hi-lo)/2;
//                    int broken = dp[i-1][mid-1];
//                }
//
//
//            }
//        }
//
//        return dp[k][n];
//
//    }




    // 换了定义的 dp table 方法(二分搜索法优化，好像优化不了)
    public static int superEggDrop2(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        int m = 0;

        while (dp[k][m]<n){
            m++;
            for (int i = 1; i <= m; i++) {
                dp[k][i] = dp[k-1][i-1] + dp[k][n-i];
            }

        }

        return 0;

    }






    public static int countspace = 0;
    public static void printspace(int count){
        for (int i = 0; i < count; i++) {
            System.out.print("  ");
        }
    }




}
