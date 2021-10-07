package com.example.leetcode.test;

import java.util.Arrays;

public class s37 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));

    }

//    编写一个程序，通过填充空格来解决数独问题。
//
//    数独的解法需 遵循如下规则：
//
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//    数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sudoku-solver
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void solveSudoku(char[][] board) {
        boolean flag = backtrack(board, 0, 0);
        System.out.println(flag);
    }

    public static boolean backtrack(char[][] board, int i, int j){
        int m = 9, n = 9;
        if (j==n) {
            return backtrack(board, i+1, 0);
        }

        if (i==m) {
            return true;
        }

        if (board[i][j]!='.') {
            return backtrack(board, i, j+1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isvalid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;
            if (backtrack(board, i, j+1)) {
                return true;
            }else {
                board[i][j] = '.';
            }


        }

        return false;

    }

    public static boolean isvalid(char[][] board, int i, int j, char ch) {
        int m = 9, n = 9;
        for (int i1 = 0; i1 < 9; i1++) {
            if (board[i1][j]==ch) {
                return false;
            }
            if (board[i][i1]==ch) {
                return false;
            }
            if (board[i/3*3 + i1/3][j/3*3 + i1%3]==ch) {
                return false;
            }

        }

        return true;


    }


}
