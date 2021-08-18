package com.example.leetcode.test;

import com.example.leetcode.bean_sha.Node3;

public class s430 {

    public static void main(String[] args) {

        Node3 a = new Node3(1);
        Node3 b = new Node3(2);
        Node3 c = new Node3(3);
        Node3 d = new Node3(4);
        Node3 e = new Node3(5);
        Node3 f = new Node3(6);
        Node3 g = new Node3(7);
        Node3 h = new Node3(8);
        Node3 i = new Node3(9);
        Node3 j = new Node3(10);
        Node3 k = new Node3(11);
        Node3 l = new Node3(12);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        c.child = g;
        g.next = h;
        h.next = i;
        i.next = j;
        h.child = k;
        k.next = l;

        System.out.println(flatten(a));

    }
//
//    多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
//
//    给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。

    public static Node3 flatten(Node3 head) {

        flatten_tail(head);
        return head;


    }

//    目的：1.head的下+右排列好；2.返回排列好的尾巴
    public static Node3 flatten_tail(Node3 head) {

        if (head==null) {
            return null;
        }

        Node3 tail = null;

        while (head!=null){
            if(head.child!=null){
                Node3 newtail = flatten_tail(head.child);
                newtail.next = head.next;
                head.next = head.child;
                head.child = null;
                tail = newtail;
                head = newtail.next;
            }else {
                tail = head;
                head = head.next;

            }
        }

        return tail;


    }

}
