package com.example.leetcode.daily.jian_zhi_offer_2;

public class s46 {

    public static void main(String[] args) {
//        int s = 12258;
        int s = 506;
        System.out.println(translateNum(s));
    }

//    给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int translateNum(int num) {
        String s = Integer.toString(num);
        int n = s.length();

        //dp[i]：前 i 个字符能表示的种类
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            if (Integer.parseInt(s.substring(i-2,i))<26 && s.charAt(i-2)!='0'){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }

}
