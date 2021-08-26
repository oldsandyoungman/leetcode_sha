package com.example.leetcode.labuladong;

import com.example.leetcode.bean_sha.ListNode;

public class hui_wen_lian_biao_2 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
//        ListNode f = new ListNode(2);
        ListNode f = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

//        boolean flag = fuc1(a);
//        System.out.println(flag);

        System.out.println(isPalindrome(a));
    }

    public static ListNode left;

    public static boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public static boolean traverse(ListNode right){
        if (right==null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }


}
