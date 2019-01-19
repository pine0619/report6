package jp.ac.uryukyu.ie.e185703;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private List<Stone> Stone_list;
    private String[][] board;

    /**
     * コンストラクタ。Stoneを入れた１０×１０の配列を作成する。
     */
    public Field(){
        this.Stone_list = new ArrayList<>();
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                Stone stone = new Stone(x, y);
                this.Stone_list.add(stone);
            }
        }
        for(int y = 1; y < 9; y++){
            for(int x = 0; x < 9; x++){
                getStone(x, y).setColor("E");
            }
        }
        changeStoneColor(4,4,"●");
        changeStoneColor(5,5, "●");
        changeStoneColor(5, 4, "○");
        changeStoneColor(4, 5, "○");
    }

    /**
     * 石を取得するためのメソッド。
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
     * 石の色を変えるためのメソッド。
     * @param x　x座標
     * @param y　y座標
     * @param color 変えたい色
     */
    public void changeStoneColor(int x, int y, String color){
        Stone stone = this.getStone(x, y);
        stone.setColor(color);
    }

    /**
     * 盤面を出力するためのメソッド。
     */
    public void printBoard(){
        board = new String[10][10];
        for(int y = 0; y < 10; y++){
            for(int x = 0; x < 10; x++){
                board[y][x] = this.getStone(x, y).getColor();
            }
        }
        System.out.println("    1   2   3   4   5   6   7   8  x");
        for(int y = 1; y <= 8; y++){
            System.out.print(y);
            for(int x = 1; x <= 8; x++){
                System.out.printf("%4s", board[y][x]);
            }
            System.out.printf("\n\n");
        }
        System.out.println("y");
    }

    /**
     *ある方向において、その方向にひっくり返すことができる石があるかどうか判定するメソッド。
     * @param x 置きたいマスのx座標。
     * @param y 置きたいマスのy座標。
     * @param vectX 調べたい方向のx成分。
     * @param vectY 調べたい方向のy成分。
     * @param color 自分の色。
     * @return 調べた方向の中でひっくり返せる石の数。
     */
    public int judgeReverse(int x, int y, int vectX, int vectY, String color){
        int numReverseStone = 0;
        x += vectX;
        y += vectY;
        while(getStone(x, y).getColor() != color){
            if(getStone(x, y).getColor() == "E"){
                return 0;
            }else if(getStone(x, y).getColor() == null){
                return 0;
            }
            numReverseStone++;
            x += vectX;
            y += vectY;
        }
        return numReverseStone;
    }

    /**
     * judgeReverseメソッドを使って、プレイヤーの指定した座標に石が置けるか判定し、
     * 返すことができる石を実際に返すメソッド。
     * @param color 自分の色。
     */
    public void turnStone(String color){
        printBoard();
        System.out.println("あなたの色は" + color + "です。");
        Coordinate input = new Coordinate();
        //指定したマスの色が"E"かどうか。
        if(getStone(input.x, input.y).getColor() != "E"){
            System.out.println("このマスには石を置けません。");
            turnStone(color);
        }
        int numCanReverseLine = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0){
                    continue;
                }else if(judgeReverse(input.x, input.y, j, i, color) == 0) {
                    continue;
                }else{
                    changeStoneColor(input.x, input.y, color);
                    for(int k = 1; k <= judgeReverse(input.x, input.y, j, i, color); k++){
                        changeStoneColor(input.x + j * k, input.y + i * k, color);
                    }
                    numCanReverseLine++;
                }
            }
        }
        if(numCanReverseLine == 0){
            System.out.println("このマスには石を置けません。");
            turnStone(color);
        }
    }

    public void cpuTurnStone(String color){
        List<Stone> list = judgeExistCanReverseStone(color);
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        Stone stone = list.get(index);
        int xnum = stone.getPosition()[0];
        int ynum = stone.getPosition()[1];
        changeStoneColor(xnum, ynum, color);
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                for(int k = 1; k <= judgeReverse(xnum, ynum, j, i, color); k++){
                    changeStoneColor(xnum + j * k, ynum + i * k, color);
                }
            }
        }
    }

    public void judgeWinner(){
        int numBlackStone = 0;
        int numWhiteStone = 0;
        for(int y = 1; y <= 8; y ++){
            for(int x = 1; x <= 8; x++){
                if(getStone(x, y).getColor() == "○"){
                    numBlackStone++;
                }else if(getStone(x, y).getColor() == "●"){
                    numWhiteStone++;
                }
            }
        }
        printBoard();
        System.out.println("○ :" + numBlackStone + "　VS　" +  "● :" + numWhiteStone);
        if(numBlackStone > numWhiteStone){
            System.out.println("あなたの勝ちです！");
        }else if(numBlackStone == numWhiteStone){
            System.out.println("同点です！");
        }else{
            System.out.println("CPUの勝ちです！");
        }
    }

    public List<Stone> judgeExistCanReverseStone(String color){
        List<Stone> cansReverseStoneList = new ArrayList<Stone>();
        for(int y = 1; y < 9; y++){
            for(int x = 1; x < 9; x++){
                if(getStone(x, y).getColor() == "E"){
                    int numCanReverseLine = 0;
                    for(int i = -1; i <= 1; i++){
                        for(int j = -1; j <= 1; j++){
                            if(i == 0 && j == 0){
                                continue;
                            }else if(judgeReverse(x, y, j, i, color) == 0) {
                                continue;
                            }else{
                                numCanReverseLine++;
                            }
                        }
                    }
                    if(numCanReverseLine != 0){
                        cansReverseStoneList.add(getStone(x, y));
                    }
                }
            }
        }
        return cansReverseStoneList;
    }

}

