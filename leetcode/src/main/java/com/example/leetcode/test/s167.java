package com.example.leetcode.test;

import java.util.Arrays;

public class s167 {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));

    }

//    给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
//    函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
//
//    你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left<right){
            int sum = numbers[left]+numbers[right];
            if (sum < target) {
                left++;
            }else if (sum> target){
                right--;
            }else {
                return new int[]{left+1, right+1};
            }

        }
        return new int[]{-1, -1};

    }


}
