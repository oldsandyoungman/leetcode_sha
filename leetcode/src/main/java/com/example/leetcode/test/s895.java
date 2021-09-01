package com.example.leetcode.test;

import java.util.HashMap;
import java.util.Stack;

public class s895 {

    public static void main(String[] args) {

    }

//    实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
//
//    FreqStack 有两个函数：
//
//    push(int x)，将整数 x 推入栈中。
//    pop()，它移除并返回栈中出现最频繁的元素。
//    如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-frequency-stack
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//
}


class FreqStack {

    public int maxFre;
    public HashMap<Integer, Integer> val2fre = new HashMap<>();
    public HashMap<Integer, Stack<Integer>> fre2vals = new HashMap<>();

    public FreqStack() {
        this.maxFre = 0;
    }

    public void push(int val) {
        int fre = val2fre.getOrDefault(val, 0) + 1;
        val2fre.put(val, fre);
        fre2vals.putIfAbsent(fre, new Stack<>());
        fre2vals.get(fre).push(val);
        maxFre = Math.max(maxFre, fre);
    }

    public int pop() {
        Stack<Integer> s = fre2vals.get(maxFre);
        int cur = s.pop();
        val2fre.put(cur, maxFre-1);
        if (s.empty()) {
            maxFre--;
        }
        return cur;

    }
}

/*
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
