package com.example.leetcode.test;

import java.util.Deque;
import java.util.LinkedList;

public class s772 {

    public static void main(String[] args) {
//        String s = "(1+2)*(3+4)";
//        String s = "2-1 + 2";
        String s = " 2-1 + 2 ";
        System.out.println(calculate(s));
    }

//    给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。


    public static int calculate(String s) {

        int n = s.length();
        Deque<Character> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.addLast(s.charAt(i));
        }

        return traverse(q);

    }

    public static int traverse(Deque<Character> s){

        Deque<Integer> q = new LinkedList<>();
        int num = 0;
        char sign = '+';

        while (!s.isEmpty()){
            char c = s.pollFirst();
            if (c=='('){
                num = traverse(s);
            }


            if (isDigit(c)) {
                num = num*10 + (c - '0');
            }
            if ((!isDigit(c)&&c!=' ') || s.isEmpty()){

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
                }
                sign = c;
                num = 0;
                if (c==')'){
                    break;
                }

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
