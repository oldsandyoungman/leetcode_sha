package com.example.leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class s3 {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "aaaaaaaa";
        String s = "pwwkew";
//        String s = "";
//        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));

    }
//    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

//    public static int lengthOfLongestSubstring2(String s) {
//        if (s.length()==0){
//            return 0;
//        }
//        Map<Character, Integer> window = new HashMap<>();
//
//        int left = 0;
//        int right = 0;
//        int max_sha = 1;
//        int invalid = 0;
//
//        while (right<s.length()){
//
//            char r = s.charAt(right);
//            window.put(r,window.getOrDefault(r,0)+1);
//            if (window.getOrDefault(r,0)>1){
//                invalid++;
//            }
//            right++;
//
//            while (invalid>0 && left<=right) {
//                char l = s.charAt(left);
//                window.put(l,window.get(l)-1);
//                if (window.get(l)==1){
//                    invalid--;
//                }
//                left++;
//            }
//
//            if (max_sha<right-left) {
//                max_sha = right-left;
//            }
//
//
//
//        }
//        return max_sha;
//
//    }


//    public static int lengthOfLongestSubstring(String s) {
//        Map<Character,Integer> window = new HashMap<>();
//        int left = 0;
//        int right = 0;
//        int max_sha = 0;
//
//        while (right<s.length()) {
//            char r = s.charAt(right);
//            window.put(r,window.getOrDefault(r,0)+1);
//            right++;
//            while (window.get(r)>1){
//                char l = s.charAt(left);
//                window.put(l,window.get(l)-1);
//                left++;
//            }
//            max_sha = Math.max(max_sha,right-left);
//        }
//        return max_sha;
//    }

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right<s.length()) {

            char tmp = s.charAt(right);
            window.put(tmp, window.getOrDefault(tmp, 0)+1);

            right++;

            while (window.get(tmp)>1) {
                char tmp2 = s.charAt(left);
                window.put(tmp2, window.get(tmp2)-1);
                left++;
            }

            sum = Math.max(sum, right - left);

        }

        return sum;


    }


}
