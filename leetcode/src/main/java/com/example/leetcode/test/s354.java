package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Comparator;

public class s354 {

    public static void main(String[] args) {

        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

        System.out.println(maxEnvelopes(envelopes));

    }

//    给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
//    当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
//
//    请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
//    注意：不允许旋转信封。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/russian-doll-envelopes
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });

        int[] heights = new int[envelopes.length];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lis_sha(heights);


    }

    private static int lis_sha(int[] heights) {
        int[] top = new int[heights.length];
        int piles = 0;

        for (int i = 0; i < heights.length; i++) {


            int left = 0;
            int right = piles-1;

            while (left<=right){
                int mid = left + (right-left)/2;
                if (top[mid]<heights[i]) {
                    left = mid + 1;
                } else if (top[mid]>heights[i]) {
                    right = mid -1;
                } else if (top[mid]==heights[i]) {
                    right = mid -1;
                }
            }

            if (left==piles) {
                piles++;
            }
            top[left] = heights[i];


        }

        return piles;

    }


}
