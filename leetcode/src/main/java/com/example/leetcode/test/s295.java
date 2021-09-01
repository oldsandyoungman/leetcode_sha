package com.example.leetcode.test;

import java.util.PriorityQueue;

public class s295 {

    public static void main(String[] args) {
//        PriorityQueue<Integer> large = new PriorityQueue<>((a,b) -> {
//            return b-a;
//        });
//
//        large.offer(1);
//        large.offer(3);
//        large.offer(5);
//        large.offer(4);
//        large.offer(2);
//
//        System.out.println(large.poll());
//        System.out.println(large.poll());
//        System.out.println(large.poll());
//        System.out.println(large.poll());
//        System.out.println(large.poll());

        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());

    }


//    中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
//
//    例如，
//
//            [2,3,4] 的中位数是 3
//
//            [2,3] 的中位数是 (2 + 3) / 2 = 2.5
//
//    设计一个支持以下两种操作的数据结构：
//
//    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
//    double findMedian() - 返回目前所有元素的中位数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/find-median-from-data-stream
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}



class MedianFinder {

    public PriorityQueue<Integer> large;
    public PriorityQueue<Integer> small;

    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        if (small.size()>large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size()>0) {
            if (small.size() == large.size()) {
                return (small.peek() + large.peek()) / 2.0;
            }else {
                return small.peek();
            }
        }else {
            return 0;
        }
    }
}