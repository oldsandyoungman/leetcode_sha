package com.example.leetcode.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class s870 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,7,11,15};
        int[] nums2 = new int[]{1,10,4,11};

        System.out.println(Arrays.toString(advantageCount(nums1, nums2)));

    }


//    给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
//
//    返回 A 的任意排列，使其相对于 B 的优势最大化。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/advantage-shuffle
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int[] advantageCount(int[] nums1, int[] nums2) {

        int n = nums1.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[1]-a[1]
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);

        int left = 0;
        int right = n-1;
        int[] res = new int[n];

        while (!pq.isEmpty()){

            int[] temp = pq.poll();
            int i = temp[0];
            int max2 = temp[1];

            if (max2<nums1[right]) {
                res[i] = nums1[right];
                right--;
            }else {
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

}
