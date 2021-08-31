package com.example.leetcode.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class s341 {

    public static void main(String[] args) {

    }

//    给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
//
//    实现扁平迭代器类 NestedIterator ：
//
//    NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
//    int next() 返回嵌套列表的下一个整数。
//    boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
//    你的代码将会用下述伪代码检测：
//
//    initialize iterator with nestedList
//    res = []
//            while iterator.hasNext()
//    append iterator.next() to the end of res
//return res
//    如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}


class NestedIterator implements Iterator<Integer> {

    public LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.removeFirst().getInteger();
    }

    @Override
    public boolean hasNext() {

//        写错了三个地方：
//              i--写成了i++
//              （这个应该也不算错） list.addFirst(first.get(i)); 写成了 list.addFirst(first.remove(i));
//              !list.isEmpty() 写成了 list.getFirst().isInteger()
//
//

        while (!list.isEmpty() && !list.getFirst().isInteger()) {
            List<NestedInteger> first = this.list.removeFirst().getList();
            for (int i = first.size()-1; i>=0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
}



interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
 }