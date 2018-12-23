package jp.ac.uryukyu.ie.e185703;

import java.util.ArrayList;

public class Field {

    private Stone[][] board;

    /**
     *コンストラクタ
     *初期盤面の生成
     *Stoneのインスタンスを生成し、配列boardに追加する。
     */
    public Field(){
        board = new Stone[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Stone stone = new Stone(i, j);
                board[i][j] = stone;
            }
        }
        board[4][4].setColor("B");
        board[5][5].setColor("B");
        board[4][5].setColor("W");
        board[5][4].setColor("W");
    }

    /**
     * 盤面を整形し、出力するためのメソッド。
     */
    public void print_board(){
        System.out.println("  1 2 3 4 5 6 7 8");
        for(int i = 1; i <= 8; i++){
            System.out.print(i);
            for(int j = 1; j <= 8; j++){
                System.out.printf("%2s", board[i][j].getColor());
            }
            System.out.printf("\n");
        }
    }

}
