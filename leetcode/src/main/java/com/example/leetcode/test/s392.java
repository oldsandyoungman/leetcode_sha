package com.example.leetcode.test;

import java.util.ArrayList;

public class s392 {

    public static void main(String[] args) {
//        String s = "axc";
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

//    给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//
//    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//    进阶：
//
//    如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//    致谢：
//
//    特别感谢 @pbrother 添加此问题并且创建所有测试用例。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/is-subsequence
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//    public static boolean isSubsequence(String s, String t) {
//        int m = s.length();
//        int n = t.length();
//
//        int i = 0;
//        int j = 0;
//
//        while (i<m && j<n){
//            if (s.charAt(i)==t.charAt(j)) {
//                i++;
//            }
//            j++;
//        }
//        if (i==m){
//            return true;
//        }
//        return false;
//    }

    // 进阶
    public static boolean isSubsequence(String s, String t) {

        int m = s.length();
        int n = t.length();

        ArrayList<Integer>[] index = new ArrayList[256];

        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            if (index[c]==null){
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }

        int j = 0;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (index[c]==null){
                return false;
            }
            int pos = left_bound(index[c], j);
            if (pos == index[c].size()){
                return false;
            }
            j = index[c].get(pos)+1;

        }

        return true;



    }

    public static int left_bound(ArrayList<Integer> index, int j) {
        int left = 0;
        int right = index.size()-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (index.get(mid)<j){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;

    }


}
