package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s876 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
//        h.next = i;


        System.out.println(a);
        System.out.println(middleNode(a));
    }

//    给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
//    如果有两个中间结点，则返回第二个中间结点。

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null &&fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }


}
