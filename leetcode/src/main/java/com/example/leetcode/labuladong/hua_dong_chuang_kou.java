package com.example.leetcode.labuladong;

import java.util.HashMap;
import java.util.Map;

public class hua_dong_chuang_kou {

    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC","ABC"));
        System.out.println(minWindow2("ADOBECODEBANC","ABC"));

    }

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
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

//        unordered_map<char, int> need, window;
//        for (char c : t) need[c]++;


        for (int i = 0; i < t.length(); i++) {
//            need.put(t.charAt(i),need.get(t.charAt(i))+1);
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start,start+len);
    }

    public static String minWindow2(String s, String t) {

        int start = 0;
        int len = s.length();
        int min_sha = Integer.MAX_VALUE;

    /* 滑动窗口算法框架 */
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

//    ...

            /*** debug 输出的位置 ***/
            System.out.println("window[left,right]:[ " + left + " , " + right + "]");
            System.out.println(valid);
            /********************/

            // 判断左侧窗口是否要收缩
            while (valid==need.size()){

                if(right - left<min_sha){
                    start = left;
                    len = right - left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    window.put(d,window.getOrDefault(d,0)-1);
                    if(need.get(d) > window.get(d)){
                        valid--;
                    }
                }
//        ...


            }
        }


        return len==Integer.MAX_VALUE?
                "":s.substring(start,start+len);
    }

}
