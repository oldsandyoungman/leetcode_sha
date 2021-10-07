package com.example.leetcode.test;

public class s793 {

    public static void main(String[] args) {
//        System.out.println(trailingZeroes(Integer.MAX_VALUE));


        System.out.println(preimageSizeFZF(5));

    }

//     f(x) 是 x! 末尾是 0 的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 ）
//
//    例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。给定 K，找出多少个非负整数 x ，能满足 f(x) = K 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/preimage-size-of-factorial-zeroes-function
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int preimageSizeFZF(int k) {
        long left = 0;
        long right = Long.MAX_VALUE;
        long mid = 0;

        while (left<=right) {
            mid = left + (right-left)/2;
            long res = trailingZeroes(mid);
            if (res>k) {
                right = mid -1;
            } else if (res<k) {
                left = mid + 1;
            }else {
                break;
            }
        }

        long left1 = left;
        long right1 = mid;
        long mid1;

        while (left1<=right1) {
            mid1 = left1 + (right1-left1)/2;
            long res1 = trailingZeroes(mid1);
            if (res1>k) {
                right1 = mid1 - 1;
            } else if (res1<k) {
                left1 = mid1 + 1;
            } else {
                right1 = mid1 - 1;
            }
        }

        long left2 = mid;
        long right2 = right;
        long mid2;

        while (left2<=right2) {
            mid2 = left2 + (right2-left2)/2;
            long res2 = trailingZeroes(mid2);
            if (res2>k) {
                right2 = mid2 - 1;
            } else if (res2<k) {
                left2 = mid2 + 1;
            } else {
                left2 = mid2 + 1;
            }
        }

        return (int)(right2-left1+1);
    }


    public static long trailingZeroes(long n) {
        long div = 5;
        long res = 0;
        while (div<=n) {
            res += n/div;
            div *= 5;
        }
        return res;
    }

}
