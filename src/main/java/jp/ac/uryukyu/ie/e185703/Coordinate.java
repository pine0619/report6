package jp.ac.uryukyu.ie.e185703;

import java.util.Scanner;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(){
        get_user_input();
    }

    /**
     * プレイヤーの入力した座標を取得するためのメソッド。
     */
    public void get_user_input(){
        System.out.println("置きたいマスの座標を入力してください。：x-y");
        Scanner user_input = new Scanner(System.in);
        String str = user_input.nextLine();
        String[] str_list = str.split("-");
        this.x = Integer.parseInt(str_list[0]);
        this.y = Integer.parseInt(str_list[1]);
    }
}
