package com.example.leetcode.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class s460 {

    public static void main(String[] args) {
        LFUCache obj = new LFUCache(0);
        obj.put(0,0);
        int param_1 = obj.get(0);

    }

//    请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
//
//    实现 LFUCache 类：
//
//    LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
//    int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
//    void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
//    注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
//
//    为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
//
//    当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lfu-cache
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。





}


class LFUCache {
    public int cap;
    public int minFre;
    public HashMap<Integer, Integer> key2val = new HashMap<>();
    public HashMap<Integer, Integer> key2fre = new HashMap<>();
    public HashMap<Integer, LinkedHashSet<Integer>> fre2keys = new HashMap<>();


    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFre = 0;
    }

    public int get(int key) {
        if (key2val.containsKey(key)) {
            increaseFre(key);
            return key2val.get(key);
        }else {
            return -1;
        }
    }



    public void put(int key, int value) {
        if (this.cap<=0){
            return;
        }

        if (key2val.containsKey(key)) {
            key2val.put(key, value);
            increaseFre(key);
            return;
        }

        if (cap==key2val.size()) {
            deleteLeastFre();
        }

        key2val.put(key, value);
        key2fre.put(key, 1);
        fre2keys.putIfAbsent(1, new LinkedHashSet<>());
        fre2keys.get(1).add(key);
        this.minFre = 1;
    }



    private void increaseFre(int key) {
        int fre = key2fre.get(key);
        key2fre.put(key, fre+1);

        LinkedHashSet<Integer> keylist = fre2keys.get(fre);
        keylist.remove(key);
        if (keylist.isEmpty()) {
            fre2keys.remove(fre);
            if (fre==this.minFre){
                this.minFre = fre+1;
            }
        }

        fre2keys.putIfAbsent(fre+1, new LinkedHashSet<>());
        fre2keys.get(fre+1).add(key);
    }

    private void deleteLeastFre() {
        LinkedHashSet<Integer> keylist = fre2keys.get(minFre);
        int deletekey = keylist.iterator().next();
        keylist.remove(deletekey);
        if (keylist.isEmpty()){
            fre2keys.remove(minFre);
        }
        key2val.remove(deletekey);
        key2fre.remove(deletekey);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




class LFUCache2 {
    int cap;
    HashMap<Integer, Integer> key2val = new HashMap<>();
    HashMap<Integer, Integer> key2fre = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> fre2keys = new HashMap<>();
    int minFre;

    LFUCache2(int cap){
        this.cap = cap;
        this.minFre = 0;
    }

    public int get(int key) {
        if (key2val.containsKey(key)) {
            increaseFre(key);
            return key2val.get(key);
        }else {
            return -1;
        }
    }



    public void put(int key, int value) {
        if (this.cap<=0){
            return;
        }
        if (key2val.containsKey(key)) {
            key2val.put(key, value);
            increaseFre(key);
            return;
        }

        if (cap==key2val.size()){
            removeLeastFre();
        }

        key2val.put(key, value);
        key2fre.put(key, 1);
        fre2keys.putIfAbsent(1, new LinkedHashSet<>());
        fre2keys.get(1).add(key);

//        漏写了
        this.minFre = 1;

    }

    private void increaseFre(int key) {
        int fre = key2fre.get(key);
        key2fre.put(key, fre+1);

        LinkedHashSet<Integer> keylist = fre2keys.get(fre);
        keylist.remove(key);
        if (keylist.isEmpty()) {
            fre2keys.remove(fre);
            if (fre==this.minFre){
                this.minFre = fre+1;
            }
        }

        fre2keys.putIfAbsent(fre+1, new LinkedHashSet<>());
        fre2keys.get(fre+1).add(key);

    }

    private void removeLeastFre() {
        LinkedHashSet<Integer> keylist = fre2keys.get(minFre);
        int deletekey = keylist.iterator().next();
        keylist.remove(deletekey);
        if (keylist.isEmpty()){
            fre2keys.remove(minFre);
        }
        key2val.remove(deletekey);
        key2fre.remove(deletekey);

    }


}