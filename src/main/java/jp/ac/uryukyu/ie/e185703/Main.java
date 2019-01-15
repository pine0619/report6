package jp.ac.uryukyu.ie.e185703;

public class Main {
    public static void main(String args[]){
        Field field = new Field();
        field.change_stone_color(4,4,"B");
        field.change_stone_color(5,5, "B");
        field.change_stone_color(5, 4, "W");
        field.change_stone_color(4, 5, "W");
        field.print_board();
    }

}
