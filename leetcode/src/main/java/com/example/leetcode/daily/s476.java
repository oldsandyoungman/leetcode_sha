package com.example.leetcode.daily;

public class s476 {

    public static void main(String[] args) {

//        System.out.println(1^1);
//        System.out.println(0^1);
//        System.out.println(4>>1);

        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        System.out.println(findComplement(4));

    }

//    对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
//
//    例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
//    给你一个整数 num ，输出它的补数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/number-complement
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int findComplement(int num) {
        int x = num;
        int i = 0;
        while (x!=0){
            x = x>>1;
            i++;
        }
        int res = 1<<i;
        res--;


        return num^res;

    }

}
