package com.company;

public class Main {

    public static void main(String[] args) {
        Cell[][] board = new Cell[4][4];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                board[i][j]= new Cell((int)(Math.random()*4));}}

       for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(board[i][j].getStatus() + " ");
            System.out.println(" ");}

        Matrix test = new Matrix(board, 4, 4);
        test.simulateGeneration();
        System.out.println(" ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(board[i][j].getStatus() + " ");
            System.out.println(" ");
        }
    }
}

