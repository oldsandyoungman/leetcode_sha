package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;
import sun.awt.LightweightFrame;

public class s83 {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        System.out.println(a);
//        System.out.println(deleteDuplicates(a));
//        System.out.println(deleteDuplicates2(a));
        System.out.println(deleteDuplicates4(a));

    }
//    存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
//
//    返回同样按升序排列的结果链表。

    public static ListNode deleteDuplicates3(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode cur = head.next;
        ListNode pre = head;

        while (cur!=null){
            if(cur.val==pre.val){
                pre.next = cur.next;
                cur = cur.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return head;

    }


    public static ListNode deleteDuplicates2(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null){
            if (fast.val!=slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null){
            if (slow.val!=fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        slow.next = null;

        return head;
    }



    public static ListNode deleteDuplicates4(ListNode head) {

        ListNode left = head;
        ListNode right = head;

        while (right!=null){
            if (left.val!=right.val){
                left.next = right;
                left = left.next;
            }
            right = right.next;
        }
        assert left != null;
        left.next=null;

        return head;

    }

}
