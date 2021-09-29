package com.example.leetcode.test;

public class s28 {

    public static void main(String[] args) {
//        String a = "hello";
        String a = "";
//        String b = "ll";
        String b = "";
        System.out.println(strStr(a, b));
    }

//    实现 strStr() 函数。
//
//    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
//
//             
//
//    说明：
//
//    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
//    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/implement-strstr
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int strStr(String haystack, String needle) {
        KMP kmp = new KMP(needle);

        return kmp.search(haystack);
    }


}

//class KMP {
//    private int[][] dp;
//    private String pat;
//
//    public KMP(String pat) {
//        this.pat = pat;
//        int M = pat.length();
//        // dp[状态][字符] = 下个状态
//        dp = new int[M][256];
//        // base case
//        dp[0][pat.charAt(0)] = 1;
//        // 影子状态 X 初始为 0
//        int X = 0;
//        // 构建状态转移图（稍改的更紧凑了）
//        for (int j = 1; j < M; j++) {
//            for (int c = 0; c < 256; c++)
//                dp[j][c] = dp[X][c];
//            dp[j][pat.charAt(j)] = j + 1;
//            // 更新影子状态
//            X = dp[X][pat.charAt(j)];
//        }
//    }
//
//    public int search(String txt) {
//        int M = pat.length();
//        int N = txt.length();
//        // pat 的初始态为 0
//        int j = 0;
//        for (int i = 0; i < N; i++) {
//            // 计算 pat 的下一个状态
//            j = dp[j][txt.charAt(i)];
//            // 到达终止态，返回结果
//            if (j == M) return i - M + 1;
//        }
//        // 没到达终止态，匹配失败
//        return -1;
//    }
//}



class KMP {
    private final int[][] dp;
    private final String pat;

    public KMP(String pat) {
        this.pat = pat;
        int m = pat.length();

        dp = new int[m][256];
        if (m==0) {
            return;
        }

        int x = 0;

        // base case: 下面一行+其它都为0
        dp[0][pat.charAt(0)] = 1;

        for (int j = 1; j < m; j++) {
            System.arraycopy(dp[x], 0, dp[j], 0, 256);
//            for (int k = 0; k < 256; k++) {
//                dp[j][k] = dp[x][k];
//            }
            dp[j][pat.charAt(j)] = j+1;
            x = dp[x][pat.charAt(j)];
        }

    }

    public int search(String txt) {
        if (dp.length==0) {
            return 0;
        }
        int n = txt.length();
        int m = pat.length();
        int j = 0;
        for (int i = 0; i < n; i++) {
            j = dp[j][txt.charAt(i)];
            if (j==m) {
                return i-m+1;
            }
        }
        return -1;
    }
}