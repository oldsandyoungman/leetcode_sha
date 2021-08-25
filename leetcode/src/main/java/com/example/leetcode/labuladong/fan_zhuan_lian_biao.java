package com.example.leetcode.labuladong;

import com.example.leetcode.bean_sha.ListNode;
import com.example.leetcode.bean_sha.TreeNode;

public class fan_zhuan_lian_biao {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

//        System.out.println(reverse(a));
//        System.out.println(reverse2(a));
//        System.out.println(reverseN(a,4));
        System.out.println(reverseBetween(a,2,4));
    }

    /**
     * 迭代法翻转整个链表
     * @param head 链表头
     * @return 链表头
     */
    public static ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt;

        while (cur!=null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;

    }

    /**
     * 递归法翻转整个链表
     * @param head 链表头
     * @return 链表头
     */
    public static ListNode reverse2(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }

        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return res;

    }

    // 递归法将链表的前 n 个节点反转（n <= 链表长度）
    public static ListNode successor = null; // 后驱节点
    public static ListNode reverseN(ListNode head, int n){
        if (n==1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;

        return last;

    }


    /**
     * 递归法翻转部分节点
     * @param head 头结点
     * @param m 开始（索引从1开始）
     * @param n 结束（索引从1开始）
     * @return 返回新的头结点
     */

    public static ListNode reverseBetween(ListNode head, int m, int n){
        if (m>1) {
            head.next = reverseBetween(head.next, m-1, n-1);
            return head;
        }

        if (n==1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseBetween(head.next, 1,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

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
