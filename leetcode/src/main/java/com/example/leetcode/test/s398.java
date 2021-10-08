package com.example.leetcode.test;

import java.util.Random;

public class s398 {

    public static void main(String[] args) {

    }

//    给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
//
//    注意：
//    数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/random-pick-index
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




}

class Solution398 {

    private final int[] nums;
    public Solution398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        int n = 0;
        int index = 0;
        for(int i = 0;i < nums.length;i++)
            if(nums[i] == target){
                //我们的目标对象中选取。
                n++;
                //我们以1/n的概率留下该数据
                if(r.nextInt() % n == 0) index = i;
            }
        return index;
    }

}