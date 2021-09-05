package com.example.leetcode.test;

import java.util.Arrays;
import java.util.LinkedList;

public class s239 {

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {7,2,4};
//        int k = 3;
        int k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

//    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//    返回滑动窗口中的最大值。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sliding-window-maximum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int[] maxSlidingWindow(int[] nums, int k) {
        Monotonicqueue mq = new Monotonicqueue();
        int[] res = new int[nums.length-k+1];

        for (int i = 0; i < nums.length; i++) {
            if ( i < k-1 ) {
                mq.push(nums[i]);
            }else {

                mq.push(nums[i]);
                res[i-k+1] = mq.max();
                mq.pop(nums[i-k+1]);

            }
        }
        return res;
    }

}


class Monotonicqueue {

    LinkedList<Integer> q = new LinkedList<>();

    void push(int n){
        while (!q.isEmpty() && q.getLast()<n) {
            //            好像remove比poll更快
            q.removeLast();
//            q.pollLast();
        }
        q.addLast(n);
    }

    void pop(int n){
        if (n==q.getFirst()) {
//            好像remove比poll更快
            q.removeFirst();
//            q.pollFirst();
        }
    }

    int max(){
        return q.getFirst();
    }


}
