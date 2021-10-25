package com.example.leetcode.daily;

public class s7 {

    public static void main(String[] args) {

//        int x = -11;
//        x = x/10;

//        System.out.println(x);
//        System.out.println(Integer.MAX_VALUE);

//        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(2147483647));

//        2147483647
//       -2147483648

    }

//    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
//    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//
//    假设环境不允许存储 64 位整数（有符号或无符号）。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reverse-integer
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int reverse2(int x) {

        int max_sha = Integer.MAX_VALUE;
        int min_sha = Integer.MIN_VALUE;

        int max_shi = Integer.MAX_VALUE/10;
        int min_shi = Integer.MIN_VALUE/10;

        int res = 0;

        while (x!=0){

            int temp = x%10;

            res = 10*res + temp;

            if (res>max_shi){
                return 0;
            }

            if (res<min_shi){
                return 0;
            }

            x = x/10;

        }

        return res;

    }


    public static int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;



    }


    public static int reverse3(int x) {
        //        2147483647
        //       -2147483648
        int res = 0;
        while (x!=0){
            int temp = x%10;

            if (res>214748364 || (res==214748364 && temp>7 )){
                return 0;
            }
            if (res<-214748364 || (res==-214748364 && temp<-8 )) {
                return 0;
            }

            res = 10*res + temp;
            x = x/10;

        }

        return res;

    }

}
