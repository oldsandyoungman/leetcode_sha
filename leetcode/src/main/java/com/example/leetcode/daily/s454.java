package com.example.leetcode.daily;

import java.util.HashMap;

public class s454 {

    public static void main(String[] args) {

    }

//    给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
//            0 <= i, j, k, l < n
//    nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/4sum-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> sum12 = new HashMap<>();
        HashMap<Integer, Integer> sum34 = new HashMap<>();
        int res = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                int s = i+j;
                sum12.put(s, sum12.getOrDefault(s, 0)+1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int s = i+j;
                sum34.put(s, sum34.getOrDefault(s, 0)+1);
            }
        }
        for (Integer integer : sum12.keySet()) {
            int other = -integer;
            if (sum34.containsKey(other)){
                res += sum12.get(integer)*sum34.get(other);
            }
        }
        return res;
    }


    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> sum12 = new HashMap<>();
        int res = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                int s = i+j;
                sum12.put(s, sum12.getOrDefault(s, 0)+1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int s = -i-j;
                if (sum12.containsKey(s)){
                    res += sum12.get(s);
                }
            }
        }

        return res;
    }


}
