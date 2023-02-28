package org.example;

import java.util.logging.*;

class Game {
    String[][] board;
    int i;
    int j;
    Logger l = Logger.getLogger("com.api.jar");

    public Game(int size) {
        board = new String[size][size];
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                board[i][j] = "-";
            }
        }
    }

    void set(int a, int b, String c) {
        if (board[a][b].equals("-")) {
            board[a][b] = c;
        }
    }

    void printBoard(int size) {
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                l.log(Level.INFO, () -> board[i][j] + " ");
            }
            l.info("");
        }
    }

    String tie(int size) {
        int count = 0;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (board[i][j].equals("-")) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return "tie";
        }
        return "NotTie";
    }

    String win(String[][] board, int size) {
        for (i = 0; i < size; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("-")) {
                return board[i][0];
            } else if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("-")) {
                return board[0][i];
            } else if (board[1][1].equals(board[0][0]) && board[1][1].equals(board[2][2]) && !board[1][1].equals("-")) {
                return board[1][1];
            } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("-")) {
                return board[0][2];
            }
        }
        return "-";
    }
}
