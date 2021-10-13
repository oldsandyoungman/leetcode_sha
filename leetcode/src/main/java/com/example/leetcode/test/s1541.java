package com.example.leetcode.test;

public class s1541 {

    public static void main(String[] args) {
        String s = "(()))(()))()())))";
        System.out.println(minInsertions(s));
    }

//    给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
//
//    任何左括号 '(' 必须对应两个连续的右括号 '))' 。
//    左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
//    比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
//
//    你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
//
//    请你返回让 s 平衡的最少插入次数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int minInsertions(String s) {
        int n = s.length();
        int need = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);

            if (cur=='('){
                need += 2;
                if (need%2==1){
                    need--;
                    res++;
                }
            }else {
                need--;
                if (need==-1){
                    res++;
                    need = 1;
                }
            }

        }

        return res + need;

    }

}
