package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class s654 {
    public static void main(String[] args) {

//        System.out.println(Integer.parseInt("#"));


        // 初始化队列，将 root 加入队列
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        Integer cur = q.poll();
        System.out.println(cur);


    }

//    给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
//
//    二叉树的根是数组 nums 中的最大元素。
//    左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
//    右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
//    返回有给定数组 nums 构建的 最大二叉树 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-binary-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums,0,nums.length-1);
    }

    public TreeNode build(int[] nums, int lo, int hi){

        if(lo>hi){
            return null;
        }

        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }

        TreeNode res = new TreeNode(max);
        res.left = build(nums, lo, index-1);
        res.right = build(nums, index+1, hi);



        return res;
    }

}
