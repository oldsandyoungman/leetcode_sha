package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s86 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        ListNode g = new ListNode(5);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
//        f.next = g;
//        g.next = h;
//        h.next = i;

        System.out.println(a);
        System.out.println(partition(a,3));

    }
//
//    给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//    你应当 保留 两个分区中每个节点的初始相对位置。

    public static ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smallhead = small;
        ListNode largehead = large;

        while (head!=null){
            if(head.val<x){
                small.next = head;
                small = head;
            }else {
                large.next = head;
                large = head;
            }
            head=head.next;
        }

        small.next = largehead.next;
        large.next = null;

        return smallhead.next;

    }

    public static ListNode partition2(ListNode head, int x) {

        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;

        while (cur!=null && cur.val>=x){
            if(pre == null){
                pre = head;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        if(cur==null){
            return head;
        }
        if(pre == null){
            cur.next = partition(cur.next,x);
        }else {
            nxt = cur.next;
            pre.next = nxt;
            cur.next = partition(head,x);
        }
        return cur;

    }

}
