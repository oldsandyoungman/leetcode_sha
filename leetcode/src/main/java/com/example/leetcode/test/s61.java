package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s61 {
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
        h.next = i;

        System.out.println(a);
        System.out.println(rotateRight(a,9));
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if(head==null){
            return null;
        }

        ListNode right = head;
        ListNode left = head;
        int count = 0;

        while (right!=null){
            right = right.next;
            count++;
        }

        k = k % count;

        if (k==0){
            return head;
        }

        right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }

        while (right.next!=null){
            right = right.next;
            left = left.next;
        }

        ListNode newhead = left.next;
        left.next = null;
        right.next = head;

        return newhead;

    }

    public static ListNode rotateRight2(ListNode head, int k) {

        if(head==null){
            return null;
        }

        ListNode left = head;
        ListNode right = head;
        ListNode newhead = null;
        ListNode pre = null;

        for (int i = 0; i < k; i++) {
            right = right.next;
            if(right==null){
                right = head;
            }
        }
        if(right==head){
            return head;
        }

        while (right.next!=null){
            right = right.next;
            left = left.next;
        }

        newhead = left.next;
        left.next = null;
        right.next = head;

        return newhead;

    }


}
