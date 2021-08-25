package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s25 {

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
        System.out.println(reverseKGroup(a,2));

    }


//    给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//    k 是一个正整数，它的值小于或等于链表的长度。
//
//    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//    进阶：
//
//    你可以设计一个只使用常数额外空间的算法来解决此问题吗？
//    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    /**
     * 迭达法翻转[a,b)之间的链表
     * @param a 左端
     * @param b 右端
     * @return 返回新的头结点
     */
    public static ListNode reverse_a_b(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt;

        while (cur!=b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;

    }


    /**
     * k个一组迭达法翻转链表
     * @param head 头节点
     * @param k k个一组
     * @return 返回新的头节点
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null) {
            return null;
        }

        ListNode b = head;

        for (int i = 0; i < k; i++) {
            if (b==null) {
                return head;
            }
            b = b.next;
        }

        ListNode newhead = reverse_a_b(head, b);

        head.next = reverseKGroup(b,k);

        return newhead;

    }

}
