package com.example.leetcode.test;

import java.util.HashMap;
import java.util.Map;

public class s76 {

    public static void main(String[] args) {

//        String a = "ADOBECODEBANC";
//        String a = "A";
        String a = "A";
//        String t = "ABC";
//        String t = "A";
        String t = "AA";

        System.out.println(minWindow(a,t));

    }

//    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

//    注意：
//
//    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//    如果 s 中存在这样的子串，我们保证它是唯一的答案。


    /* 滑动窗口算法框架 */
//        Map<Character, Integer> need = new HashMap<Character, Integer>();
//        Map<Character, Integer> window = new HashMap<Character, Integer>();
//        for (int i = 0; i < t.length(); i++) {
//            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0));
//        }
//
//        int left = 0, right = 0;
//        int valid = 0;
//        while (right < s.length()) {
//            // c 是将移入窗口的字符
//            char c = s.charAt(right);
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//
//
////    ...
//
//            /*** debug 输出的位置 ***/
//            System.out.println("window[left,right]:[ " + left + " , " + right + "]");
//            /********************/
//
//            // 判断左侧窗口是否要收缩
//            while (window needs shrink){
//                // d 是将移出窗口的字符
//                char d = s.charAt(left);
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
////        ...
//
//
//            }
//        }




    public static String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        char[] t_char = t.toCharArray();
        for (char c : t_char) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int min = s.length()+1;
        int res_l = 0;
        int res_r = s.length()-1;

        while (right<s.length()){

            char r = s.charAt(right);

            if (need.containsKey(r)) {
                window.put(r,window.getOrDefault(r,0)+1);

                if (window.get(r).equals(need.get(r))){
                    valid++;
                }
            }


            right++;

            while (valid==need.size()) {

                if (right-left<min) {
                    min = right-left;
                    res_l = left;
                    res_r = right;
                }

                char l = s.charAt(left);

                if (need.containsKey(l)) {
                    window.put(l,window.get(l)-1);
                    if (window.get(l)==need.get(l)-1) {
                        valid--;
                    }
                }

                left++;
            }

        }

        if (min==s.length()+1){
            return "";
        }else {
            return s.substring(res_l, res_r);
        }

    }

}
