package com.example.leetcode.labuladong;

import java.util.Arrays;

public class chi_pu_tao {

    public static void main(String[] args) {

    }


    // 输入为三种葡萄的颗数，可能非常大，所以用 long 型
    // 返回吃的最多的人最少要吃多少颗葡萄
    public static long solution(long a, long b, long c){
        long[] nums = new long[]{a, b, c};
        Arrays.sort(nums);
        long sum = a + b + c;

        if (nums[0]+nums[1]>nums[2]){
            return (sum+2)/3;
        } else if (2*(nums[0]+nums[1])<nums[2]) {
            return (nums[2]+1)/2;
        }else {
            return (sum+2)/3;
        }

    }
}
