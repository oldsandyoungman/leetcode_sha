package com.example.leetcode.test;

import java.util.Arrays;

public class s1109 {

    public static void main(String[] args) {
        int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
        int n = 5;
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

//    这里有 n 个航班，它们分别从 1 到 n 进行编号。
//
//    有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
//
//    请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/corporate-flight-bookings
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        Difference d = new Difference(res);

        for (int[] booking : bookings) {
            int i = booking[0]-1;
            int j = booking[1]-1;
            int k = booking[2];
            d.increment(i, j, k);
        }
        return d.result();
    }

}

class Difference {

    int[] diff;

    public Difference(int[] nums){
        int n = nums.length;
        diff = new int[n];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }

    public void increment(int i, int j, int val){
        diff[i] += val;
        if (j+1<diff.length) {
            diff[j+1] -= val;
        }
    }

    public int[] result(){
        int n = diff.length;
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] + diff[i];
        }
        return res;
    }


}
