package com.example.leetcode.daily;

import java.lang.reflect.Array;
import java.util.Arrays;

public class s66 {

    public static void main(String[] args) {
        int[] d = new int[]{4,3,2,1};
        System.out.println(Arrays.toString(plusOne(d)));
    }

//    给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
//    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
//    你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/plus-one
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n-1]++;
        for (int i = n-1; i >= 0; i--) {
            if (i==0){
                if (digits[i]>9){
                    digits[i]=0;
                    int[] res = new int[n+1];
                    System.arraycopy(digits, 0, res, 1, n);
                    res[0] = 1;
                    return res;
                }
            }else {
                if (digits[i]>9){
                    digits[i-1]++;
                    digits[i] = 0;
                }
            }
        }
        return digits;

    }


}
