package com.example.leetcode.test;

public class s875 {

    public static void main(String[] args) {
//        int[] piles = {3,6,7,11};
//        int[] piles = {30,11,23,4,20};
//        int[] piles = {30,11,23,4,20};
//        int[] piles = {2,2};
        int[] piles = {1000000000,1000000000};


//        int H = 8;
//        int H = 5;
//        int H = 6;
//        int H = 2;
        int H = 3;

        System.out.println(minEatingSpeed(piles, H));

    }

//    珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
//
//    珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
//
//    珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
//    返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/koko-eating-bananas
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int f(int[] piles, int k){
        int hours = 0;

        for (int pile : piles) {
            hours += pile/k;
            if (pile%k!=0) {
                hours++;
            }
        }

        return hours;

    }

    public static int minEatingSpeed(int[] piles, int h) {
        int bianjie = (int) Math.pow(10,9);
        int left = 1;
        int right = bianjie;

        while (left<=right) {

            int mid = left + (right-left)/2;
//            if (f(piles, mid)<h) {
//                right = mid -1;
//            } else if (f(piles, mid)>h) {
//                left = mid + 1;
//            }else {
//                right = mid -1;
//            }
            if (f(piles, mid)>h) {
                left = mid + 1;
            }else {
                right = mid -1;
            }

        }

        if (left>bianjie || f(piles, left)>h ) {
            return -1;
        }

        return left;

    }

}
