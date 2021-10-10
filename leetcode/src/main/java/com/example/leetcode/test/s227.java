package com.example.leetcode.test;

import java.util.Deque;
import java.util.LinkedList;

public class s227 {

    public static void main(String[] args) {
        String s = "3/2";
        System.out.println(calculate(s));
    }

//    给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
//    整数除法仅保留整数部分。

    public static int calculate(String s) {
        Deque<Integer> q = new LinkedList<>();

        int n = s.length();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (isDigit(c)) {
                num = num*10 + (c - '0');
            }
            if ((!isDigit(c)&&c!=' ') || i==n-1){
                switch (sign){
                    case '+':
                        q.addLast(num);
                        break;
                    case '-':
                        q.addLast(-num);
                        break;
                    case '*':
                        q.addLast(q.removeLast()*num);
                        break;
                    case '/':
                        q.addLast(q.removeLast()/num);
                        break;
                }
                sign = c;
                num = 0;

            }
        }
        int sum = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
        }
        return sum;
    }

    public static boolean isDigit(char c){
        int gap = c - '0';
        return gap >= 0 && gap <= 9;
    }



}
