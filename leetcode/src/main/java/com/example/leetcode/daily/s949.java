package com.example.leetcode.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class s949 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(largestTimeFromDigits(arr));
    }

//    给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
//
//            24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。
//
//    以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/largest-time-for-given-digits
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String largestTimeFromDigits(int[] arr) {

        int ans = -1;

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                if (j!=i) {

                    for (int k = 0; k < 4; k++) {

                        if (k!=j && k!=i){

                            int l = 6 - i - j - k;

                            int hour = arr[i]*10 + arr[j];
                            int min = arr[k]*10 + arr[l];

                            if (hour<24 && min<60){
                                ans = Math.max(ans, 60*hour+min);
                            }
                        }
                    }
                }
            }
        }

        if (ans==-1){
            return "";
        }

        return String.format("%02d:%02d", ans / 60, ans % 60);

    }


}
