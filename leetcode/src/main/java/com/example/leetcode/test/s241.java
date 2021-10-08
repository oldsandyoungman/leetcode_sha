package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

public class s241 {

    public static void main(String[] args) {
//        String e = "2-1-1";
        String e = "2*3-4*5";
        System.out.println(diffWaysToCompute(e));
    }

//    给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static HashMap<String, List<Integer>> memo = new HashMap<>();
    public static List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> res = new ArrayList<>();

        int n = expression.length();

        for (int i = 0; i < n; i++) {
            if (expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                List<Integer> res1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(expression.substring(i+1));
                for (Integer integer1 : res1) {
                    for (Integer integer2 : res2) {
                        if (expression.charAt(i)=='+'){
                            res.add(integer1+integer2);
                        } else if (expression.charAt(i)=='-') {
                            res.add(integer1-integer2);
                        }else {
                            res.add(integer1*integer2);
                        }
                    }
                }
            }
        }

        if (res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }

        return res;


    }

}
