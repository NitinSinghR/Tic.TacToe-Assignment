package org.example;

import java.util.*;
import java.util.logging.*;

public class TicTacToe {
    static boolean check(int x, int y, int size){ return (x >= 0 && y >= 0) || (x < size && y < size);}
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
        String t=g.tie(size);

        while (stop==1) {
                l.info("Enter the position Player 1");
                x = sc.nextInt();
                y = sc.nextInt();
                if (check(x,y,size)) {
                     g.set(x, y, "X");
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
                if (check(x,y,size)) {
                     g1.set(x, y, "O");
                }

                g.printBoard(size);

                if(g.win(g.board, size).equals("O")){
                    l.info("Player 2 wins");
                    stop=0;

                }
                if(t.equals("tie")){
                    l.info("Match Draw");
                    stop=0;
                }
        }
    }
}
