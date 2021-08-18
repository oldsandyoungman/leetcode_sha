package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s234 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(3);
        ListNode h = new ListNode(2);
        ListNode i = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
//        d.next = e;
//        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

//        a=null;

        System.out.println(a);
        System.out.println(isPalindrome(a));
    }

//    请判断一个链表是否为回文链表。

    public static boolean isPalindrome(ListNode head) {

        ListNode left = head;
        ListNode right = head;

        while (right!=null && right.next!=null){
            left = left.next;
            right = right.next.next;
        }

        if(right!=null){
            left = left.next;
        }

        ListNode tail = reverseList(left);

        while (tail!=null){
            if(tail.val!=head.val){
                return false;
            }

            tail = tail.next;
            head = head.next;

        }

        return true;




    }

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
