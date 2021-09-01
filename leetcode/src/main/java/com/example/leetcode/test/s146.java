package com.example.leetcode.test;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class s146 {

    public static void main(String[] args) {

    }

//    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
//    实现 LRUCache 类：
//
//    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
//    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//             
//
//    进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lru-cache
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}



class LRUCache {
    public LinkedHashMap<Integer, Integer> cache;
    public int cap;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }else {
            makeRecently(key);
            return cache.get(key);
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
//            cache.put(key, value);
////            这步老是忘记233，或者按照之前的思路也行，就先删再加呗
//            makeRecently(key);
            cache.remove(key);
            cache.put(key,value);
            return;
        }

        if (cache.size()==cap) {
            Integer oldestkey = cache.keySet().iterator().next();
            cache.remove(oldestkey);
        }

        cache.put(key,value);

    }

    public void makeRecently(int key){
        if (cache.containsKey(key)) {
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key, val);
        }
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */






class Node_sha{

    int key;
    int val;
    Node_sha pre;
    Node_sha next;
    Node_sha(){}
    Node_sha(int key, int val){
        this.key = key;
        this.val = val;
    }

}


class doublelist_sha{
    Node_sha head;
    Node_sha tail;
    int size;

    doublelist_sha(){
        head = new Node_sha();
        tail = new Node_sha();
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    void addLast(Node_sha x){
        x.next = tail;
        x.pre = tail.pre;
        x.pre.next = x;
        tail.pre = x;
        size++;
    }

    void remove(Node_sha x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    Node_sha removeFirst(){
        if (size>0){
            Node_sha res = head.next;
//            head.next.next.pre = head;
//            head.next = head.next.next;
//            size--;
            remove(res);
            return res;
        }
        return null;
    }

    public int size(){
        return this.size;
    }

}

class LRUCache2 {
    doublelist_sha cache = new doublelist_sha();
    HashMap<Integer, Node_sha> map = new HashMap<>();
    int cap;

    LRUCache2(int capacity){
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node_sha curnode = map.get(key);
        makeRecent(key);
        return curnode.val;

    }



    public void put(int key, int value) {
        if (map.containsKey(key)){
//            Node_sha curnode = map.get(key);
//            curnode.val = value;
//            makeRecent(key);
            deleteKey(key);
            addRecent(key, value);

            return;
        }

        if (cap == map.size()){
            Node_sha first = cache.removeFirst();
            int key1 = first.key;
            map.remove(key1);
        }

//        Node_sha curnode = new Node_sha(key, value);
//        map.put(key, curnode);
//        cache.addLast(curnode);

        addRecent(key, value);


    }

    private void makeRecent(int key) {
        Node_sha curnode = map.get(key);
        cache.remove(curnode);
        cache.addLast(curnode);

    }

    private void addRecent(int key, int val){
        Node_sha curnode = new Node_sha(key, val);
        map.put(key, curnode);
        cache.addLast(curnode);
    }

    public void deleteKey(int key){
        Node_sha curnode = map.get(key);
        cache.remove(curnode);
        map.remove(key);
    }

}

