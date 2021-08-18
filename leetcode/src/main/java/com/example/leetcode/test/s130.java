package com.example.leetcode.test;

public class s130 {

    public static void main(String[] args) {

    }

//    给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

    public static void solve(char[][] board) {
        if (board==null || board.length==0) {
            return;
        }
        int h = board.length;
        int w = board[0].length;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = i==0 || i==h-1 || j==0 || j==w-1;
                if (flag && board[i][j]=='O'){
                    dfs_sha(board,i,j);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if (board[i][j]=='#') {
                    board[i][j] = 'O';
                }
            }
        }



    }

    public static void dfs_sha(char[][] board, int x, int y){
        if (x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]=='X' || board[x][y]=='#') {
            return;
        }
        board[x][y] = '#';
        dfs_sha(board,x+1,y);
        dfs_sha(board,x-1,y);
        dfs_sha(board,x,y+1);
        dfs_sha(board,x,y-1);

    }

}
