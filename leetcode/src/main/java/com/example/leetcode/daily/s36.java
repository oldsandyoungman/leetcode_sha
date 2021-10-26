package com.example.leetcode.daily;

import java.util.Arrays;

public class s36 {

    public static void main(String[] args) {
//        char s = '0' + 2;
//        System.out.println(s);

//        char[][] board = new char[][]{
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };

        char[][] board = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));


    }


//    请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//    数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//    注意：
//
//    一个有效的数独（部分已被填充）不一定是可解的。
//    只需要根据以上规则，验证已经填入的数字是否有效即可。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/valid-sudoku
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。






    // 注意审题
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];

                if (c=='.'){
                    continue;
                }

                if (!isvalid(board, i, j)){
                    return false;
                }

            }
        }
        return true;
    }

    public static boolean isvalid(char[][] board, int x, int y){
        char c = board[x][y];
        int startx = 3*(x/3);
        int starty = 3*(y/3);
        int bias = 3*(x-startx)+y-starty;
        for (int i = 0; i < 9; i++) {
            if (board[x][i]==c && i!=y){
                return false;
            }
            if (board[i][y]==c && i!=x){
                return false;
            }
            if (board[startx+i/3][starty+i%3]==c &&i!=bias){
                return false;
            }
        }
        return true;
    }




    // 审题不清
    public static boolean isValidSudoku2(char[][] board) {
        return backtrack(board, 0, 0);
    }

    // 验证有效性，先填再验
//    public static boolean backtrack(char[][] board, int x, int y){
//        if (x==9){
//            return true;
//        }
//        if (y==9){
//            return backtrack(board, x+1,0);
//        }
//        char c = board[x][y];
//        if (c!='.'){
//            return backtrack(board, x,y+1);
//        }
//
//        for (int i = 0; i < 9; i++) {
//
//            board[x][y] = (char) ('0' + i);
//            if (!isvalid(board, x, y)){
//                continue;
//            }
//
//            if (backtrack(board, x, y+1)){
//                return true;
//            }
//
//        }
//
//        return false;
//
//    }
//
//    public static boolean isvalid(char[][] board, int x, int y){
//        char c = board[x][y];
//        int startx = 3*(x/3);
//        int starty = 3*(y/3);
//        int bias = 3*(x-startx)+y-starty;
//        for (int i = 0; i < 9; i++) {
//            if (board[x][i]==c && i!=y){
//                return false;
//            }
//            if (board[i][y]==c && i!=x){
//                return false;
//            }
//            if (board[startx+i/3][starty+i%3]==c &&i!=bias){
//                return false;
//            }
//        }
//        return true;
//    }


    public static boolean backtrack(char[][] board, int x, int y){
        if (x==9){
            return true;
        }
        if (y==9){
            return backtrack(board, x+1,0);
        }
        char c = board[x][y];
        if (c!='.'){
            return backtrack(board, x,y+1);
        }

        for (char i = '1'; i <= '9'; i++) {

            if (!isvalid(board, x, y, i)){
                continue;
            }

            board[x][y] = i;

            if (backtrack(board, x, y+1)){
                return true;
            }

            board[x][y] = '.';

        }

        return false;

    }

    public static boolean isvalid(char[][] board, int x, int y, char c){
        int startx = 3*(x/3);
        int starty = 3*(y/3);
        for (int i = 0; i < 9; i++) {
            if (board[x][i]==c){
                return false;
            }
            if (board[i][y]==c){
                return false;
            }
            if (board[startx+i/3][starty+i%3]==c){
                return false;
            }
        }
        return true;
    }

}
