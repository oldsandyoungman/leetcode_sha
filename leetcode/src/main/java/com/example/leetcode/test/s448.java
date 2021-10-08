package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class s448 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

//    给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;

    }

}
