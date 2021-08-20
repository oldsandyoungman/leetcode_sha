package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s438 {

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String s = "abab";
//        String s = "aaaaaaaaaa";
        String s = "cbaebabacd";
//        String p = "abc";
//        String p = "ab";
//        String p = "aaaaaaaaaaaaa";
        String p = "abc";
        System.out.println(findAnagrams(s,p));

    }

//    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//    异位词 指字母相同，但排列不同的字符串。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length()<p.length()){
            return res;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] p_array = p.toCharArray();
        for (char c : p_array) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < p.length()) {
            char r = s.charAt(right);
            if (need.containsKey(r)) {
                window.put(r,window.getOrDefault(r,0)+1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }
            right++;
        }

        if (valid==need.size()) {
//            if (!s.substring(0,right).equals(p)){
//                res.add(0);
//            }
            res.add(0);
        }

        while (right<s.length()){

            char r = s.charAt(right);
            if (need.containsKey(r)) {
                window.put(r,window.getOrDefault(r,0)+1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }
            right++;

            char l = s.charAt(left);
            if (need.containsKey(l)) {
                window.put(l,window.get(l)-1);
                if (window.get(l).equals(need.get(l)-1)) {
                    valid--;
                }
            }
            left++;

            if (valid==need.size()){
//                if (!s.substring(left,right).equals(p)){
//                    res.add(left);
//                }
                res.add(left);
            }

        }

        return res;




    }



}
