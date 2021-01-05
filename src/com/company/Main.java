package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] gridGame = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridGame[i][j] = (char)32;
            }
        }
        viewGrid(gridGame);
        play(gridGame);
    }
    public static void viewGrid(char [][] grid) {
        for (int i = 0; i < 9; i++) System.out.print("-");
        System.out.println();
        System.out.printf("| %s %s %s |%n", grid[0][0], grid[0][1], grid[0][2]);
        System.out.printf("| %s %s %s |%n", grid[1][0], grid[1][1], grid[1][2]);
        System.out.printf("| %s %s %s |%n", grid[2][0], grid[2][1], grid[2][2]);
        for (int i = 0; i < 9; i++) System.out.print("-");
        System.out.println();
    }
    public static void play(char [][] grid) {
        String inputX;
        String inputY;
        int numberX = 0;
        int numberY = 0;
        int move = 1;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            inputX = scanner.next();
            inputY = scanner.next();
            if (inputX.matches("\\d+") || inputY.matches("\\d+")) {
                numberX = Integer.parseInt(inputX);
                numberY = Integer.parseInt(inputY);
            } else {
                System.out.println("You should enter numbers!");
            }
            if (1>numberX || numberX>3 ||1 > numberY || numberY>3){
                System.out.println("Coordinates should be from 1 to 3!");

            } else if (grid[numberX-1][numberY-1]==' ') {
                if(move % 2 != 0){
                    grid[numberX - 1][numberY - 1] = 'X';
                } else {
                    grid[numberX - 1][numberY - 1] = 'O';
                }
                viewGrid(grid);
                move++;
                if (resultGame(grid)) break;
            } else if(grid[numberX-1][numberY-1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            }

        } while (1>numberX || numberX>3 ||1> numberY || numberY>3||(grid[numberX-1][numberY-1] != ' '));
    }
    public static boolean resultGame(char[][]grid) {
        int rows0 = 0;
        int rows1 =0;
        int rows2 = 0;
        int col0 = 0;
        int col1 = 0;
        int col2 = 0;
        int diag0 = 0;
        int diag1 = grid[0][2] + grid[1][1] + grid[2][0];
        for (int i = 0; i < grid.length; i++) {
            rows0 += grid[0][i];
            rows1 += grid[1][i];
            rows2 += grid[2][i];
            col0 += grid[i][0];
            col1 += grid[i][1];
            col2 += grid[i][2];
            diag0 += grid[i][i];
        }
        int emptySlot = 0;
        for (char[] chars : grid) {
            for (int j = 0; j < grid.length; j++) {
                if (chars[j] == ' ') emptySlot++;
            }
        }
        if (rows0==264 || rows1==264 ||rows2==264 || col0==264 || col1==264 || col2==264 || diag0==264||diag1==264){
            System.out.println("X wins");
            return true;
        } else if (rows0==237 || rows1==237 || rows2==237 || col0==237 || col1==237 || col2==237 || diag0==237 || diag1==237) {
            System.out.println("O wins");
            return true;
        }else  if (emptySlot == 0){
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}
