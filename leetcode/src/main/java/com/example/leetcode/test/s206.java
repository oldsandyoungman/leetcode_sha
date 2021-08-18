package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s206 {

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
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = g;
//        g.next = h;
//        h.next = i;

//        a=null;

        System.out.println(a);
        System.out.println(reverseList(a));
    }

//    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


    public static ListNode reverseList(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode cur = head;
        ListNode nxt = head;
        ListNode pre = null;

        while (cur!=null){

            nxt = nxt.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;

        }

        return pre;


    }
}
