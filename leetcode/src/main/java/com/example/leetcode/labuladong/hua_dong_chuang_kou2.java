package com.example.leetcode.labuladong;

import java.util.HashMap;
import java.util.Map;

public class hua_dong_chuang_kou2 {

    public static void main(String[] args) {
        System.out.println(containOrNot("eidbaooo", "ab"));
//        System.out.println(containOrNot2("ab", "eidbaooo"));

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

    private static boolean containOrNot(String s, String t) {
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
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }


//    ...

            /*** debug 输出的位置 ***/
            System.out.println("window[left,right]:[ " + left + " , " + right + "]");
            /********************/

            // 判断左侧窗口是否要收缩
            while (right-left==t.length()){

                if (valid==need.size()) {
                    return true;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){

                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);

                }


//        ...


            }
        }


        return false;
    }

    private static boolean containOrNot2(String s, String t) {
        return false;
    }

}