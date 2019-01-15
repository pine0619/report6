package jp.ac.uryukyu.ie.e185703;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Stone> Stone_list;
    private String[][] board;

    /**
     * コンストラクタ。Stoneを入れた９×９の配列を作成する。
     */
    public Field(){
        this.Stone_list = new ArrayList<>();
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                Stone stone = new Stone(x, y);
                this.Stone_list.add(stone);
            }
        }
    }

    /**
     * 石を取得するためのメソッド
     * @param x　x座標
     * @param y　y座標
     * @return stone
     */
    public Stone getStone(int x, int y){
        for(Stone stone : this.Stone_list){
            int pos[] = stone.getPosition();
            if(pos[0] == x && pos[1] == y){
                return stone;
            }
        }
        return null;
    }

    /**
     * 石の色を変えるためのメソッド
     * @param x　x座標
     * @param y　y座標
     * @param color 変えたい色
     */
    public void change_stone_color(int x, int y, String color){
        Stone stone = this.getStone(x, y);
        stone.setColor(color);
    }

    /**
     * 盤面を出力するためのメソッド
     */
    public void print_board(){
        board = new String[9][9];
        for(int y = 0; y < 9; y++){
            for(int x = 0; x < 9; x++){
                board[y][x] = this.getStone(x, y).getColor();
            }
        }

        System.out.println("  1 2 3 4 5 6 7 8");
        for(int y = 1; y <= 8; y++){
            System.out.print(y);
            for(int x = 1; x <= 8; x++){
                System.out.printf("%2s", board[y][x]);
            }
            System.out.printf("\n");
        }
    }

}

