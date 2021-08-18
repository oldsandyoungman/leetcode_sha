package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s143 {

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
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = g;
//        g.next = h;
//        h.next = i;

//        a=null;

        System.out.println(a);
//        System.out.println(detectCycle(a).val);
        reorderList(a);
        System.out.println(a);
    }

//    给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//             L0 → L1 → … → Ln-1 → Ln 
//    请将其重新排列后变为：
//
//    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
//
//    不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    static int count = 0;


    public static void reorderList2(ListNode head) {





    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        //求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private static ListNode reorderListHelper(ListNode head, int len) {

        print_sha(count++);
        System.out.print("head:" + head + " ; len:" + len + '\n');

        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;

            print_sha(--count);
            System.out.print("outtail:" + outTail + '\n');

            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;

            print_sha(--count);
            System.out.print("outtail:" + outTail + '\n');

            return outTail;
        }
        //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;//中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next;  //上一层 head 对应的 tail
        tail.next = subHead;

        print_sha(--count);
        System.out.print("outtail:" + outTail + '\n');
        return outTail;
    }



    public static void reorderList3(ListNode head) {

        zheng(head);

    }

    public static ListNode zheng(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        head.next = fan(head.next);
        return head;
    }

    public static ListNode fan(ListNode head){

        if(head==null || head.next==null){
            return head;
        }

        ListNode right = head;
        while (right.next.next!=null){
            right = right.next;
        }

        ListNode newhead = right.next;

        right.next = null;
        newhead.next = zheng(head);

        return newhead;

    }


    public static void print_sha(int count){
        for (int i = 0; i < count; i++) {
            System.out.print("  ");
        }
    }


}
