package com.example.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class s412 {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

//    写一个程序，输出从 1 到 n 数字的字符串表示。
//
//            1. 如果 n 是3的倍数，输出“Fizz”；
//
//            2. 如果 n 是5的倍数，输出“Buzz”；
//
//            3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/fizz-buzz
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int i;
        int i3 = 3;
        int i5 = 5;

        for (i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i==i3){
                sb.append("Fizz");
                i3 += 3;
            }
            if (i==i5){
                sb.append("Buzz");
                i5 += 5;
            }
            if (sb.length()==0){
                sb.append(i);
            }
            res.add(sb.toString());
        }
        return res;
    }

}
