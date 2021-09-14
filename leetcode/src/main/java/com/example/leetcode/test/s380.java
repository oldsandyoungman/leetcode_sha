package com.example.leetcode.test;

import java.util.*;

public class s380 {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(randomizedSet.remove(2)); // 返回 false ，表示集合中不存在 2 。
        System.out.println(randomizedSet.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomizedSet.getRandom()); // getRandom 应随机返回 1 或 2 。
        System.out.println(randomizedSet.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println(randomizedSet.insert(2)); // 2 已在集合中，所以返回 false 。
        System.out.println(randomizedSet.getRandom()); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。


    }

//    实现RandomizedSet 类：
//
//    RandomizedSet() 初始化 RandomizedSet 对象
//    bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
//    bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
//    int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
//    你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。





}


class RandomizedSet {

    HashMap<Integer, Integer> val2index = new HashMap<>();
    ArrayList<Integer> index2val = new ArrayList<>();
    Random rd = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (val2index.containsKey(val)){
            return false;
        }
        val2index.put(val, index2val.size());
        index2val.add(index2val.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!val2index.containsKey(val)) {
            return false;
        }
        int last_val = index2val.get(index2val.size() - 1);
        int index = val2index.get(val);
        index2val.set(index, last_val);
        val2index.put(last_val, index);
        index2val.remove(index2val.size()-1);
        val2index.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return index2val.get(rd.nextInt(index2val.size()));
    }
}




//class RandomizedSet {
//    Map<Integer, Integer> dict;
//    List<Integer> list;
//    Random rand = new Random();
//
//    /** Initialize your data structure here. */
//    public RandomizedSet() {
//        dict = new HashMap();
//        list = new ArrayList();
//    }
//
//    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//    public boolean insert(int val) {
//        if (dict.containsKey(val)) return false;
//
//        dict.put(val, list.size());
//        list.add(list.size(), val);
//        return true;
//    }
//
//    /** Removes a value from the set. Returns true if the set contained the specified element. */
//    public boolean remove(int val) {
//        if (! dict.containsKey(val)) return false;
//
//        // move the last element to the place idx of the element to delete
//        int lastElement = list.get(list.size() - 1);
//        int idx = dict.get(val);
//        list.set(idx, lastElement);
//        dict.put(lastElement, idx);
//        // delete the last element
//        list.remove(list.size() - 1);
//        dict.remove(val);
//        return true;
//    }
//
//    /** Get a random element from the set. */
//    public int getRandom() {
//        return list.get(rand.nextInt(list.size()));
//    }
//}