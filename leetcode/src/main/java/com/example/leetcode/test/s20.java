package com.example.leetcode.test;

import java.util.Deque;
import java.util.LinkedList;

public class s20 {

    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "([)]{}";
//        String s = "{[]}";
        String s = "{";

        System.out.println(isValid(s));
    }

//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/valid-parentheses
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static boolean isValid(String s) {
        Deque<Character> q = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur=='(' || cur=='[' || cur=='{') {
                q.addLast(cur);
            }else {
                if (!q.isEmpty() && leftkind(cur)==q.getLast()) {
                    q.removeLast();
                }else {
                    return false;
                }
            }
        }
        return q.isEmpty();
    }

    public static char leftkind(char s){
        if (s==')'){
            return '(';
        }
        if (s==']'){
            return '[';
        }
        return '{';
    }

}
