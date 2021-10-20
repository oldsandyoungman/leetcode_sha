package com.example.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class s1945 {

    public static void main(String[] args) {
//        String s = "iiii";
        String s = "leetcode";
        int k = 2;
        System.out.println(getLucky(s, k));
    }


//    给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
//
//    首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
//
//    例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
//
//    转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
//    转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
//    转换 #2：17 ➝ 1 + 7 ➝ 8
//    返回执行上述操作后得到的结果整数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sum-of-digits-of-string-after-convert
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int getLucky(String s, int k) {

        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = s.charAt(i)-'a'+1;
            if (num>9){
                sum += num%10;
                sum += num/10;
            }else {
                sum += num;
            }

        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < k-1; i++) {
            while (sum>0){
                l.add(sum%10);
                sum /= 10;
            }
            sum = 0;
            while (!l.isEmpty()){
                sum += l.remove(0);
            }
        }
        return sum;

    }

}
