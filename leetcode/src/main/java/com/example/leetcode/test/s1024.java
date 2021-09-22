package com.example.leetcode.test;

import java.util.Arrays;
import java.util.Comparator;

public class s1024 {

    public static void main(String[] args) {
        int[][] clips = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
        int time = 10;
        System.out.println(videoStitching(clips, time));
    }

//    你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
//
//    视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
//
//    我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/video-stitching
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int videoStitching(int[][] clips, int time) {

        if (time==0) {
            return 0;
        }

        int n = clips.length;

        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0]==o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int res = 0;
        int curend = 0;
        int nextend = 0;
        int i = 0;
        while (i<n && clips[i][0]<=curend) {

            while (i<n && clips[i][0]<=curend){
                nextend = Math.max(nextend, clips[i][1]);
                i++;
            }

            res++;
            curend = nextend;
            if (nextend>=time) {
                return res;
            }

        }

        return -1;

    }


}
