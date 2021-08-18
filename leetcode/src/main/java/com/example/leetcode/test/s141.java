package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s141 {

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
//        i.next = e;

//        System.out.println(a);
        System.out.println(hasCycle(a));

    }
//
//    给定一个链表，判断链表中是否有环。
//
//    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//
//    如果链表中存在环，则返回 true 。 否则，返回 false 。


    public static boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){

            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow){
                return true;
            }
        }
        return false;

    }


}
