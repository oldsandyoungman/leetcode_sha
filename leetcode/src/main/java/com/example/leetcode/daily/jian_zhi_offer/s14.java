package com.example.leetcode.daily.jian_zhi_offer;

public class s14 {

    public static void main(String[] args) {
//        System.out.println(cuttingRope(8));
//        System.out.println(cuttingRope(2));
//        System.out.println(cuttingRope(3));
//        System.out.println(cuttingRope(120));
        System.out.println(cuttingRope(127));
//        System.out.println(mypow(3,40));
    }
//
//    给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//    // 错的思路
//    public static int cuttingRope(int n) {
//
//        if (n==2){
//            return 1;
//        }
//
//        int m = (int) Math.sqrt(n);
//
//        int num_n = n/(m+1);
//        int num_m = (n - num_n*(m+1))/m;
//
////        if (num_m+num_n>1){
////            return (int)(Math.pow(m,num_m) * Math.pow(m+1,num_n));
////        }else {
////            return 1;
////        }
//
//        return (int)(Math.pow(m,num_m) * Math.pow(m+1,num_n));
//
//
//    }

    public static int cuttingRope(int n) {

        if (n<=3){
            return n-1;
        }

        int p = 1000000007;

        int k = n/3;
        int l = n%3;

        if (l==1){
            k--;
            return (int)((4*qiuyu(k))%p);
        }else if (l==2){
            return (int)((2*qiuyu(k))%p);
        }else {
            return (int)(qiuyu(k)%p);
        }

    }


    public static long qiuyu(int k){
        if (k==0){
            return 1;
        }

        int p = 1000000007;

        if (k%2==0){
            long temp = qiuyu(k/2);
            return (temp*temp)%p;
        }else {
            long temp = qiuyu((k-1)/2);
            return (3*temp*temp)%p;
        }

    }

//    public static int base = 1000000007;
//    public static int mypow(int a, int k) {
//        if (k == 0) return 1;
//        a %= base;
//
//        if (k % 2 == 1) {
//            // k 是奇数
//            return (a * mypow(a, k - 1)) % base;
//        } else {
//            // k 是偶数
//            int sub = mypow(a, k / 2);
//            return (sub * sub) % base;
//        }
//    }

}
