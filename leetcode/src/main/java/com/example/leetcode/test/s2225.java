package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s2225 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(sortedArrayToBST(nums));

    }

//    给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

    public static TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length-1);
    }

    public static TreeNode traverse(int[] nums, int start, int end){

        if (start>end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode cur = new TreeNode(nums[mid]);

        cur.left = traverse(nums, start, mid-1);
        cur.right = traverse(nums, mid+1, end);

        return cur;

    }

}
