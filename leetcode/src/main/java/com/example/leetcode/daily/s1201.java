package com.example.leetcode.daily;

public class s1201 {

    public static void main(String[] args) {
        int n = 3, a = 2, b = 3, c = 5;

        System.out.println(nthUglyNumber(n,a,b,c));

    }

//    给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
//
//    丑数是可以被 a 或 b 或 c 整除的 正整数 。

    public static int nthUglyNumber(int n, int a, int b, int c) {
        if (a==1 || b==1 || c==1){
            return n;
        }

        int min_sha = Math.min(Math.min(a,b), c);
        long lcm_ab = lcm(a, b);
        long lcm_bc = lcm(b, c);
        long lcm_ac = lcm(a, c);
        long lcm_abc = lcm(lcm_ab, c);

        long left = min_sha;
        long right = (long) min_sha*n;

        while (left<=right){
            long mid = left + (right-left)/2;
            long count = mid/a + mid/b + mid/c - mid/lcm_ab - mid/lcm_bc - mid/lcm_ac + mid/lcm_abc;
            if (count==n){
                left = mid;
                break;
            } else if (count>n) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return (int) (left - Math.min(Math.min(left%a, left%b), left%c));



    }

    // 最小公倍数
    private static long lcm(long a, long b) {
        return a*b/gcd(a,b);
    }

    // 最大公因数
    private static long gcd(long a, long b) {
        if (a==0){
            return b;
        }
        return gcd(b%a, a);
    }

}
