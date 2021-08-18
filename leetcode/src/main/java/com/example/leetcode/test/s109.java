package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;
import com.example.leetcode.bean_sha.TreeNode;

public class s109 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;

        System.out.println(sortedListToBST(a));

    }

//    给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static TreeNode sortedListToBST(ListNode head) {

        if (head==null) {
            return null;
        }
        if (head.next==null){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode lefttail = new ListNode(0);
        lefttail.next = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            lefttail = lefttail.next;
            fast = fast.next.next;
        }
        lefttail.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;

    }



}
