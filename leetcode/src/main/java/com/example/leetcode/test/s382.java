package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class s382 {
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

//        a=null;

        System.out.println(a);

        s382 obj = new s382(a);
        int param_1 = obj.getRandom();


    }

//    给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
//
//    进阶:
//    如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？

    private Random random = new Random();
    private final ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public s382(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {

        ListNode a = head;
        int i = 1;
        int result=0;


        while (a!=null){
            if(random.nextInt(i)==0){
                result = a.val;
            }else {
                a = a.next;
                i++;
            }
        }

        return result;

    }


    int getRandom(ListNode head) {

        Random r = new Random();
        int i = 0;
        int result = 0;
        ListNode p = head;

        while (p!=null){
            if(r.nextInt(++i)==0){
                result = p.val;
            }
            p = p.next;
        }
        return result;
    }



    int getRandom2(ListNode head) {
        Random r = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        // while 循环遍历链表
        while (p != null) {
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (r.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }


    int[] getRandom(ListNode head, int k) {
        Random r = new Random();
        ListNode p = head;
        int i = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (p!=null){
            if(++i<=k){
                res.add(p.val);
            }else {
                if (r.nextInt(i)<k){
                    res.remove(r.nextInt(k));
                    res.add(p.val);
                }
            }
            p = p.next;
        }

        int[] aaa = new int[res.size()];
        for (int i1 = 0; i1 < res.size(); i1++) {
            aaa[i] = res.get(i);
        }
        return aaa;

    }


    int[] getRandom2(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;

        // 前 k 个元素先默认选上
        for (int j = 0; j < k && p != null; j++) {
            res[j] = p.val;
            p = p.next;
        }

        int i = k;
        // while 循环遍历链表
        while (p != null) {
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(++i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }


}


class Solution23333 {

    Random r = new Random();
    ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution23333(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int i = 0, res = 0;
        ListNode p = head;
        // while 循环遍历链表
        while (p != null) {
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (r.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
