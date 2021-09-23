package com.example.leetcode.test;

import java.util.Arrays;
import java.util.HashMap;

public class s10 {

    public static void main(String[] args) {
//        String s = "aa";
//        String s = "ab";
        String s = "a";
//        String p = "a*";
//        String p = ".*c";
        String p = ".*..a*";




        System.out.println(isMatch(s,p));
    }

//    给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//            '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
//    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/regular-expression-matching
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




    // 备忘录（int[][]）
    public static boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        dp(s, 0, p, 0);

        return memo[0][0] == 1;

    }
    public static int[][] memo;
    public static boolean dp(String s, int i, String p, int j){
        if (j==p.length()) {
            return i==s.length();
        }
        if (i==s.length()){
            if ((p.length()-j)%2==1) {
                return false;
            }
            for (int k = j; k < p.length(); k=k+2) {
                if (p.charAt(k+1)!='*'){
                    return false;
                }
            }
            return true;
        }
        if (memo[i][j]!=-1){
            return memo[i][j] == 1;
        }

        if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
//            匹配
            if (j<p.length()-1 && p.charAt(j+1)=='*') {
//                匹配0次或多次
                boolean temp = dp(s,i,p,j+2) || dp(s,i+1,p,j);
                memo[i][j] = temp?1:0;
                return temp;
            }else {
//                匹配1次
                boolean temp = dp(s,i+1,p,j+1);
                memo[i][j] = temp?1:0;
                return temp;
            }
        }else {
//            不匹配
            if (j<p.length()-1 && p.charAt(j+1)=='*') {
//                匹配0次
                boolean temp = dp(s,i,p,j+2);
                memo[i][j] = temp?1:0;
                return temp;
            }else {
//                不能匹配
                memo[i][j] = 0;
                return false;
            }
        }

    }


//    // 备忘录（Hashmap），速度太慢不建议
//    public static boolean isMatch(String s, String p) {
//        memo = new HashMap<>();
//        dp(s, 0, p, 0);
//        return memo.get("0,0");
//
//    }
//    public static HashMap<String, Boolean> memo;
//    public static boolean dp(String s, int i, String p, int j){
//        if (j==p.length()) {
//            return i==s.length();
//        }
//        if (i==s.length()){
//            if ((p.length()-j)%2==1) {
//                return false;
//            }
//            for (int k = j; k < p.length(); k=k+2) {
//                if (p.charAt(k+1)!='*'){
//                    return false;
//                }
//            }
//            return true;
//        }
//        if (memo.containsKey(i+","+j)){
//            return memo.get(i+","+j);
//        }
//
//        if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
////            匹配
//            if (j<p.length()-1 && p.charAt(j+1)=='*') {
////                匹配0次或多次
//                boolean temp = dp(s,i,p,j+2) || dp(s,i+1,p,j);
//                memo.put(i+","+j, temp);
//                return temp;
//            }else {
////                匹配1次
//                boolean temp = dp(s,i+1,p,j+1);
//                memo.put(i+","+j, temp);
//                return temp;
//            }
//        }else {
////            不匹配
//            if (j<p.length()-1 && p.charAt(j+1)=='*') {
////                匹配0次
//                boolean temp = dp(s,i,p,j+2);
//                memo.put(i+","+j, temp);
//                return temp;
//            }else {
////                不能匹配
//                memo.put(i+","+j, false);
//                return false;
//            }
//        }
//
//    }



}
