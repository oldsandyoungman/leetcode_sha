package com.example.leetcode.test;

import com.example.leetcode.bean_sha.Node;

public class s116 {

    public static void main(String[] args) {

    }

//    给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
//
//    struct Node3 {
//        int val;
//        Node3 *left;
//        Node3 *right;
//        Node3 *next;
//    }
//    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//    初始状态下，所有 next 指针都被设置为 NULL。
//

    public static Node connect(Node root) {

        if(root==null || root.left==null){
            return root;
        }

        connect2nodes(root.left, root.right);

        return root;

    }

    public static void connect2nodes(Node left, Node right){

        if(left==null || right==null){
            return;
        }

        left.next = right;

        connect2nodes(left.left, left.right);
        connect2nodes(right.left, right.right);

//        left.right.next = right.left;

        connect2nodes(left.right, right.left);



    }

}
