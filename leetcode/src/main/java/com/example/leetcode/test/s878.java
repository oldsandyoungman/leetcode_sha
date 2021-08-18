package com.example.leetcode.test;

public class s878 {
    public static void main(String[] args) {
        int N = 1, A = 2, B = 3;
        System.out.println(nthMagicalNumber(N, A, B));

    }

//    如果正整数可以被 A 或 B 整除，那么它是神奇的。
//    返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。



//    public int nthMagicalNumber(int n, int a, int b) {
//        int count = 0;
//        int magic = 0;
//        int i = 1;
//        if(a>b){
//            while (count<=n){
//                if( (i*a)%b ==0 ){
//                    count++;
//                    magic = i*a;
//                    i++;
//                }
//            }
//        }
//
//
//
//
//        return 0;
//
//    }
//

    public static int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        int L = A / gcd(A, B) * B;

        long lo = 0;
        long hi = (long) 1e15;
        while (lo < hi) {
            long mi = lo + (hi - lo) / 2;
            // If there are not enough magic numbers below mi...
            if (mi / A + mi / B - mi / L < N)
                lo = mi + 1;
            else
                hi = mi;
        }

        return (int) (lo % MOD);
    }

    public static int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }


}
