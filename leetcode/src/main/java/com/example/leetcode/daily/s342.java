package com.example.leetcode.daily;

public class s342 {

    public static void main(String[] args) {
        int n = 1162261466;
//        System.out.println(isPowerOfFour(1));
//        System.out.println(isPowerOfFour(2));
//        System.out.println(isPowerOfFour(3));
//        System.out.println(isPowerOfFour(4));
//        System.out.println(isPowerOfFour(5));
//        System.out.println(isPowerOfFour(6));
//        System.out.println(isPowerOfFour(7));
//        System.out.println(isPowerOfFour(8));
//        System.out.println(isPowerOfFour(9));
        System.out.println(isPowerOfFour(n));
    }

//    给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
//
//    整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/power-of-four
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static boolean isPowerOfFour(int n) {
        int m = 1+Integer.MAX_VALUE/4;
        int i = 1;
        while (i<n && i<m){
            i = i*4;
        }
        return i==n;

    }

    // 正确方法
    public static boolean isPowerOfFour2(int n) {
        int m = 0xaaaaaaaa;
        int res = n&m;
        return n>0 && (n&(n-1))==0 && res==0;

    }

}
