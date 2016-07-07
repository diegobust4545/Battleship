package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	// write your code here
        Gameboard board = new Gameboard();
        Scanner scan = new Scanner(System.in);
        board.displayBoard();
        System.out.println();
        System.out.println(" ~ Welcome to Battleship ~");
        System.out.println();
        System.out.println("Key Concept of the game is to " +
                "sink all of your opponents ships");
        System.out.println();

        System.out.println("* To make a move first type in Letter " +
                "of the row followed by number of the column ");
        System.out.println("* If you see / on the grid it means you missed");
        System.out.println("* If you see x on the grid it means you made a hit");
        System.out.println();
        System.out.println("Good Luck!");
        board.drawPlayerBoard();

        while(board.play())
        {
            board.isWin();
            System.out.println();
            System.out.println("Make Your Move");
            String shot = scan.nextLine();
            board.move(shot);
            board.isWin();
            board.drawPlayerBoard();

        }

    }
}
