package com.example.leetcode.test;

import java.util.HashMap;

public class s659 {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,3,4,5};
//        int[] nums = new int[]{1,2,3,3,4,4,5,5};
        int[] nums = new int[]{1,2,3,4,4,5};

        System.out.println(isPossible(nums));

    }

//    给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
//
//    如果可以完成上述分割，则返回 true ；否则，返回 false 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> fre = new HashMap<>();
        HashMap<Integer, Integer> need = new HashMap<>();

        for (int num : nums) {
            fre.put(num, fre.getOrDefault(num, 0)+1);
        }

        for (int num : nums) {
            if (fre.getOrDefault(num, 0)==0) {
                continue;
            }

            if (need.containsKey(num) && need.get(num)>0) {
                fre.put(num, fre.get(num)-1);
                need.put(num, need.get(num)-1);
                need.put(num+1, need.getOrDefault(num+1, 0)+1);
            } else if (fre.getOrDefault(num, 0)>0 && fre.getOrDefault(num+1, 0)>0 && fre.getOrDefault(num+2, 0)>0) {
                fre.put(num, fre.get(num)-1);
                fre.put(num+1, fre.get(num+1)-1);
                fre.put(num+2, fre.get(num+2)-1);
                need.put(num+3, need.getOrDefault(num+3, 0)+1);
            } else {
                return false;
            }
        }
        return true;

    }

}
