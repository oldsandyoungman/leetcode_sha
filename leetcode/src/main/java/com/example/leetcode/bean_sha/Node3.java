package com.example.leetcode.bean_sha;

public class Node3 {
    public int val;
    public Node3 prev;
    public Node3 next;
    public Node3 child;

    public Node3(int val) {
        this.val = val;
    }

    public Node3(int val, Node3 prev, Node3 next, Node3 child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

    @Override
    public String toString() {
        if(next==null){
            return ""+val;
        }
        else {
            return this.val + "->" + this.next;
        }
    }
};
