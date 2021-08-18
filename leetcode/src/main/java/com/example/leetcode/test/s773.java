package com.example.leetcode.test;

import java.util.*;

public class s773 {

    public static void main(String[] args) {
        int[][] a = {{4,1,2},{5,0,3}};
        System.out.println(slidingPuzzle(a));

    }

//    在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
//
//            一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
//
//            最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
//
//    给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sliding-puzzle
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int slidingPuzzle(int[][] board) {

        int m = board.length;
        int n = board[0].length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 3});
        list.add(new int[]{0, 2, 4});
        list.add(new int[]{1, 5});
        list.add(new int[]{0, 4});
        list.add(new int[]{1, 3, 5});
        list.add(new int[]{2, 4});
        if (start.equals(target)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(sb.toString());
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;

        while (!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (target.equals(cur)) {
                    return step;
                }
                int j = 0;
                while (cur.charAt(j)!='0'){
                    j++;
                }
                for (int k : list.get(j)) {
                    char temp = cur.charAt(k);
                    String temp_string = cur.replace('0','x');
                    temp_string = temp_string.replace(temp, '0');
                    temp_string = temp_string.replace('x',temp);
                    if (!visited.contains(temp_string)) {
                        q.offer(temp_string);
                        visited.add(temp_string);
                    }
                }
            }
            step++;
        }
        return -1;
    }


}
