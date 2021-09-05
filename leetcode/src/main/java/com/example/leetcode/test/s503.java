package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class s503 {

    public static void main(String[] args) {
        int[] a = {2,1,2,4,3};

        System.out.println(Arrays.toString(nextGreaterElements(a)));
    }


//    给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/next-greater-element-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int[] nextGreaterElements(int[] nums) {
        int n =nums.length;
        int[] res = new int[n];
        Deque<Integer> s = new LinkedList<>();

        for (int i = 2*n-1 ; i>=0 ; i--){

            while (!s.isEmpty() && s.peek()<=nums[i%n]) {
                s.pop();
            }

            res[i%n] = s.isEmpty()?-1:s.peek();
            s.push(nums[i%n]);

        }

        return res;

    }




}
