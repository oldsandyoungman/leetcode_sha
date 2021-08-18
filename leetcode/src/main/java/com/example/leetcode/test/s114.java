package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s114 {

    public static void main(String[] args) {

    }

//    给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
//    展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode tmp_right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root;
        while (p.right!=null){
            p = p.right;
        }
        p.right = tmp_right;


    }
}
