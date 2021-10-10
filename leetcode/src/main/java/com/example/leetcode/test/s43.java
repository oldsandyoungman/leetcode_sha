package com.example.leetcode.test;

import java.util.Arrays;

public class s43 {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";

        System.out.println(multiply(s1, s2));
    }

//    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m+n];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int m1 = num1.charAt(i) - '0';
                int n1 = num2.charAt(j) - '0';
                int result = m1*n1 + res[i+j+1];
                int qian = result/10;
                int hou = result%10;
                res[i+j] += qian;
//                if (res[i+j]>10){
//                    res[i+j] %= 10;
//                    res[i+j+1] += res[i+j]/10;
//                }
                res[i+j+1] = hou;
//                if (res[i+j+1]>10){
//                    res[i+j+1] %= 10;
//                    res[i+j+2] += res[i+j+1]/10;
//                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i<m+n && res[i]==0) {
            i++;
        }
        for (; i < m+n; i++) {
            sb.append(res[i]);
        }
        String s = sb.toString();
        return s.isEmpty()?"0":s;

    }

}
