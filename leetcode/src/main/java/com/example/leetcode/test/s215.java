package com.example.leetcode.test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class s215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));

//        int[] test = new int[]{4,1,6,3,2,5};
//        System.out.println(partition(test, 0, 5));
//        System.out.println(Arrays.toString(test));

    }

//    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    // 优先级队列方法
//    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int num : nums) {
//            pq.offer(num);
//            if (pq.size()>k) {
//                pq.poll();
//            }
//        }
//        return pq.peek();
//
//    }



    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        shuffle_sha(nums);

        k = n - k;

        int lo = 0;
        int hi = n-1;
        int p = 0;

        while (lo<=hi){
            p = partition(nums, lo, hi);
            if (p>k) {
                hi = p - 1;
            } else if (p<k) {
                lo = p + 1;
            } else {
                return nums[p];
            }
        }

        return nums[p];

    }

    public static void shuffle_sha(int[] nums){
        Random r = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = r.nextInt(n-i)+i;
            swap(nums, i, j);
        }
    }

    public static int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        // 将 nums[lo] 作为默认分界点 pivot
        int pivot = nums[lo];
        // j = hi + 1 因为 while 中会先执行 --
        int i = lo, j = hi + 1;
        while (true) {
            // 保证 nums[lo..i] 都小于 pivot
            while (nums[++i] < pivot) {
                if (i == hi) break;
            }
            // 保证 nums[j..hi] 都大于 pivot
            while (nums[--j] > pivot) {
                if (j == lo) break;
            }
            if (i >= j) break;
            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        // 将 pivot 值交换到正确的位置
        swap(nums, j, lo);
        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
        return j;
    }

    // 交换数组中的两个元素
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



}
