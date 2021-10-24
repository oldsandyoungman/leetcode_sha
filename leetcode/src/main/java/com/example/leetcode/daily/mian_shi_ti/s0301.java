package com.example.leetcode.daily.mian_shi_ti;

public class s0301 {

    public static void main(String[] args) {

    }

//    三合一。描述如何只用一个数组来实现三个栈。
//
//    你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
//
//    构造函数会传入一个stackSize参数，代表每个栈的大小。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/three-in-one-lcci
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}


class TripleInOne {

    public int[] num;
    public int[] point;
    public int size;

    public TripleInOne(int stackSize) {
        num = new int[3*stackSize];
        point = new int[3];
        point[0] = -1;
        point[1] = stackSize-1;
        point[2] = 2*stackSize-1;
        size = stackSize;
    }

    public void push(int stackNum, int value) {
        if (point[stackNum]!=(stackNum+1)*size-1){
            num[++point[stackNum]] = value;
        }
    }

    public int pop(int stackNum) {
        if (point[stackNum]!=(stackNum)*size-1){
            return num[point[stackNum]--];
        }else {
            return -1;
        }

    }

    public int peek(int stackNum) {
        if (point[stackNum]!=(stackNum)*size-1){
            return num[point[stackNum]];
        }else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {
        return point[stackNum]==stackNum*size-1;
    }
}