package com.example.leetcode.labuladong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twosum {
    public static void main(String[] args) {

        int[] nums = {3,0,3,5};

        System.out.println(Arrays.toString(twosum(nums, 6)));

    }

    static int[] twosum(int[] nums, int target) {

        int n = nums.length;
        Map<Integer, Integer> index = new HashMap<>();//构造一个哈希表︰元素映射到相应的索引
        for (int i = 0; i < n; i++)
            index.put(nums[i], i);
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            //如果 other存在且不是nums[i]本身
            if (index.containsKey(other) && index.get(other) != i)
                return new int[]{i, index.get(other)};
        }
        return new int[]{-1, -1};
    }

}
