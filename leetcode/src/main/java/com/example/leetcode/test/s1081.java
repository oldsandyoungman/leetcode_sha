package com.example.leetcode.test;

import java.util.Stack;

public class s1081 {

    public static void main(String[] args) {

    }

    public String smallestSubsequence(String s) {
        boolean[] exist = new boolean[256];
        int[] count = new int[256];
        Stack<Character> stk = new Stack<>();


        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count[aChar]++;
        }



        for (char aChar : chars) {
            count[aChar]--;
            if (exist[aChar]) {
                continue;
            }
            while (!stk.empty() && stk.peek()>aChar){
                if (count[stk.peek()]==0) {
                    break;
                }
                exist[stk.pop()] = false;
            }
            exist[aChar] = true;
            stk.push(aChar);
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.empty()) {
            sb.append(stk.pop());
        }

        return sb.reverse().toString();
    }

}
