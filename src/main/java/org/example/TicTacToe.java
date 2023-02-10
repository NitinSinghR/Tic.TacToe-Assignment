package org.example;

import java.util.*;
import java.util.logging.*;

public class TicTacToe {
    public static void main(String[] args) {
        int x;
        int y;

        Logger l = Logger.getLogger("com.api.jar");
        Scanner sc = new Scanner(System.in);

        l.info("Enter the dimensions");
        int size = sc.nextInt();

        Game g = new Game(size);
        Game g1= g;

        l.info("Board");
        g.printBoard(size);
        int stop=1;

        while (stop==1) {
                l.info("Enter the position Player 1");
                x = sc.nextInt();
                y = sc.nextInt();
                if ((x >= 0 && y >= 0) || (x < size && y < size)) {
                     g.set(x, y, "X");
                }else{
                    l.info("Enter valid input");
                }

                g.printBoard(size);

                if(g.win(g.board, size).equals("X")){
                  l.info("Player 1 wins");
                  stop=0;
                  break;
                }

                l.info("Enter the position Player 2");
                x = sc.nextInt();
                y = sc.nextInt();
                if ((x >= 0 && y >= 0) || (x < size && y < size)) {
                     g1.set(x, y, "O");
                }

                g.printBoard(size);

                if(g.win(g.board, size).equals("O")){
                    l.info("Player 2 wins");
                    stop=0;

                }else if(g.tie(size).equals("tie")){
                    l.info("Match Draw");
                    stop=0;
                }
        }
    }
}
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
                l.log(Level.INFO,()->board[i][j] + " ");
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
        return "notTie";
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