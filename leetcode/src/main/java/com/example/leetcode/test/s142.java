package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s142 {

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
        i.next = e;

//        System.out.println(a);
        System.out.println(detectCycle(a).val);

    }


//    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。


    public static ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;

        while (fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow){
                flag = true;
                break;
            }
        }

        if(flag){

            slow = head;

            while (fast!=slow){
                slow = slow.next;
                fast = fast.next;
            }

            return fast;


        }else {
            return null;
        }



    }



}
