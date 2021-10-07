package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class s22 {

    public static void main(String[] args) {

//        Stack<Character> s = new Stack<>();
//        s.push('(');
//        s.push(')');
//        Character[] characters = s.toArray(new Character[0]);
//        String ss = Arrays.toString(characters);
//        System.out.println(ss);
//
//        String strStringType="my string"; //创建一个字符串变量strStringType
//        char[] chrCharArray; //创建一个字符数组chrCharArray
//        chrCharArray = strStringType.toCharArray(); //将字符串变量转换为字符数组
//        String a = String.valueOf(chrCharArray);
//        strStringType= String.valueOf(chrCharArray ); //将字符数组转换为字符串
//
//        System.out.println(a);


        List<String> strings = generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }

    }

//    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//    有效括号组合需满足：左括号必须以正确的顺序闭合。

//    public static List<String> generateParenthesis(int n) {
//        res = new ArrayList<>();
//        //        Stack<Character> s = new Stack<>();
//        StringBuilder s = new StringBuilder();
//        backtrack(n, n, s);
//        return res;
//    }
//
//    public static List<String> res;
//
//    public static void backtrack(int left, int right, StringBuilder s){
//        if (left<0 || right<0) {
//            return;
//        }
//        if (left>right) {
//            return;
//        }
//        if (left==0 && right==0){
//            res.add(s.toString());
//            return;
//        }
//
//        s.append('(');
//        backtrack(left-1,right,s);
//        s.deleteCharAt(s.length()-1);
//
//        s.append(')');
//        backtrack(left,right-1,s);
//        s.deleteCharAt(s.length()-1);
//
//    }


    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, n, sb);
        return res;
    }
    public static List<String> res;
    public static void backtrack(int n1, int n2, StringBuilder now) {
//        if (n1>n2) {
//            return;
//        }
//        if (n1==0 && n2==0) {
//            res.add(new String(now));
//            return;
//        }
//
//        if (n1==0) {
//            now.append(")");
//            backtrack(n1, n2-1, now);
//            now.deleteCharAt(now.length()-1);
//            return;
//        }
//
//        if (n1==n2){
//            now.append("(");
//            backtrack(n1-1, n2, now);
//            now.deleteCharAt(now.length()-1);
//            return;
//        }
//
//        now.append("(");
//        backtrack(n1-1, n2, now);
//        now.deleteCharAt(now.length()-1);
//
//        now.append(")");
//        backtrack(n1, n2-1, now);
//        now.deleteCharAt(now.length()-1);

        if (n1<0 || n2<0) {
            return;
        }
        if (n1>n2) {
            return;
        }
        if (n1==0 && n2==0) {
//            res.add(new String(now));
            res.add(now.toString());
            return;
        }

        // 单引号时间更快
//        now.append("(");
        now.append('(');
        backtrack(n1-1, n2, now);
        now.deleteCharAt(now.length()-1);

//        now.append(")");
        now.append(')');
        backtrack(n1, n2-1, now);
        now.deleteCharAt(now.length()-1);

    }


}
