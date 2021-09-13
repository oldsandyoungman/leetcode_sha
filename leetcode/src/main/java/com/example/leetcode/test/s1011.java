package com.example.leetcode.test;

public class s1011 {

    public static void main(String[] args) {
//        int[] weights = {3,2,2,4,1,4};
        int[] weights = {1,2,3,1,1};
//        int days = 3;
        int days = 4;
//        System.out.println(f(weights, 5));

        System.out.println(shipWithinDays(weights, days));

    }


//    传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
//
//    传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
//
//    返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int f(int[] weights, int load){
        if (weights.length==0) {
            return 0;
        }
        int days = 1;
        int l = 0;
        for (int weight : weights) {
            if (l+weight > load){
                l = 0;
                days++;
            }
            l += weight;
        }
        return days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }

        int bianjie = right;

        while (left <= right) {
            int mid = left + (right-left)/2;
//            if (f(weights, mid)<days) {
//                right = mid - 1;
//            } else if (f(weights, mid)>days) {
//                left = mid + 1;
//            }else {
//                right = mid - 1;
//            }
            if (f(weights, mid)>days) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if (left>bianjie || f(weights, left)>days) {
            return -1;
        }

        return left;
    }

}
