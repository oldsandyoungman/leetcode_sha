package com.example.leetcode.test;

import java.util.HashMap;
import java.util.Map;

public class s567 {

    public static void main(String[] args) {
        //        String a = "ADOBECODEBANC";
//        String a = "A";
//        String a = "ab";
        String a = "a";
//        String a = "adc";
//        String t = "ABC";
//        String t = "A";
//        String t = "eidboooab";
//        String t = "dcda";
        String t = "ab";

        System.out.println(checkInclusion(a,t));
    }

//    给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
//
//    换句话说，s1 的排列之一是 s2 的 子串 。

//    public static boolean checkInclusion2(String s1, String s2) {
//
//        Map<Character,Integer> need = new HashMap<>();
//        Map<Character,Integer> window = new HashMap<>();
//
//        char[] s1_array = s1.toCharArray();
//        for (char c : s1_array) {
//            need.put(c,need.getOrDefault(c,0)+1);
//        }
//
//        int left = 0;
//        int right = 0;
//        int valid = 0;
//
//
//
//        while (right<s2.length()){
//
//            char r = s2.charAt(right);
//            if (need.containsKey(r)){
//                window.put(r,window.getOrDefault(r,0)+1);
//                if (window.get(r).equals(need.get(r))){
//                    valid++;
//                }
//            }
//            right++;
//
//            while (valid==need.size()) {
//                if (right-left==s1.length()){
//                    return true;
//                }
//
//                char l = s2.charAt(left);
//                if (need.containsKey(l)){
//                    window.put(l,window.get(l)-1);
//                    if (window.get(l)==need.get(l)-1) {
//                        valid--;
//                    }
//                }
//
//                left++;
//
//            }
//
//        }
//
//        return false;
//
//
//    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length()>s2.length()){
            return false;
        }

        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        char[] s1_array = s1.toCharArray();
        for (char c : s1_array) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right<s1.length()){

            char r = s2.charAt(right);
            if (need.containsKey(r)){
                window.put(r,window.getOrDefault(r,0)+1);
                if (window.get(r).equals(need.get(r))){
                    valid++;
                }
            }
            right++;
        }

        if (valid==need.size()){
            return true;
        }

        while (right<s2.length()) {

            char r = s2.charAt(right);
            if (need.containsKey(r)){
                window.put(r,window.getOrDefault(r,0)+1);
                if (window.get(r).equals(need.get(r))){
                    valid++;
                }
            }
            right++;

            char l = s2.charAt(left);
            if (need.containsKey(l)){
                window.put(l,window.get(l)-1);
                if (window.get(l)==need.get(l)-1) {
                    valid--;
                }
            }

            left++;

            if (valid==need.size()){
                return true;
            }


        }

        return false;


    }

}
