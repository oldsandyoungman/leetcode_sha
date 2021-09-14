package com.example.leetcode.test;

public class s410 {

    public static void main(String[] args) {
//        int[] a = {7, 2, 5, 10, 8};
        int[] a = {1,2,3,4,5};
        System.out.println(splitArray(a, 2));

    }



//    给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
//
//    设计一个算法使得这 m 个子数组各自和的最大值最小。



//    public static int splitArray(int[] nums, int m) {
//
//        int lo = max_shasha(nums);
//        int hi = sum_shasha(nums);
//
////        for (int i = lo; i <= hi; i++) {
////
////            int n = split_shasha(nums, i);
////            if (n<=m){
////                return i;
////            }
////        }
////        return -1;
//
//        int left = lo;
//        int right = hi;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (split_shasha(nums, mid) > m) {
//                left = mid + 1;
//            } else if (split_shasha(nums,mid)<m) {
//                right = mid - 1;
//            } else if (split_shasha(nums,mid)==m) {
//                right = mid - 1;
//            }
//        }
//        if (left>hi || split_shasha(nums,left)>m) {
//            return -1;
//        }
//
//        return left;
//    }
//
//    private static int split_shasha(int[] nums, int max) {
//        int count = 1;
//        int sum = 0;
//        for (int num : nums) {
//            if (sum + num > max) {
//                count++;
//                sum = num;
//            } else {
//                sum += num;
//            }
//        }
//        return count;
//    }
//
//    private static int sum_shasha(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        return sum;
//    }
//
//    private static int max_shasha(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int num : nums) {
//            if (max < num) {
//                max = num;
//            }
//        }
//        return max;
//    }





    public static int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int left0 = left;
        int right0 = right;

        while (left<=right) {
            int mid = left + (right-left)/2;
//            if (f(nums, mid)<m) {
//                right = mid - 1;
//            } else if (f(nums, mid)>m) {
//                left = mid + 1;
//            }else {
//                right = mid - 1;
//            }
            if (f(nums, mid)>m) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }

        if (left > right0 || f(nums, left)>m) {
            return -1;
        }

        return left;

    }

    // x 是指子数组和的上限
    public static int f(int[] nums, int x) {

        int m = 0;
        int temp_sum = 0;
        for (int num : nums) {
            if (temp_sum + num > x) {
                temp_sum = 0;
                m++;
            }
            temp_sum += num;
        }

        return m+1;

    }


}
