package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s108 {
    public static void main(String[] args) {
        int[] a = {};
        System.out.println(sortedArrayToBST(a));
    }

//    给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
//    高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static TreeNode sortedArrayToBST(int[] nums) {

        return traverse(nums, 0, nums.length-1);

    }

    public static TreeNode traverse(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        if (start==end){
            return new TreeNode(nums[start]);
        }

        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traverse(nums, start, mid-1);
        root.right = traverse(nums, mid+1, end);
        return root;
    }
}
