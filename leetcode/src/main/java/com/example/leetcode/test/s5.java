package com.example.leetcode.test;

public class s5 {

    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

//    给你一个字符串 s，找到 s 中最长的回文子串。

    public static String longestPalindrome(String s) {
        int n = s.length();
        int max_n = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            int n1 = s1.length();
            int n2 = s2.length();
            if (n1>max_n){
                max_n = n1;
                res = s1;
            }
            if (n2>max_n){
                max_n = n2;
                res = s2;
            }
        }
        return res;
    }
    public static String palindrome(String s, int l, int r) {
        int left = l;
        int right = r;
        int n = s.length();
        while (left>=0 && right<n){
            if (s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left+1, right);
    }

}
