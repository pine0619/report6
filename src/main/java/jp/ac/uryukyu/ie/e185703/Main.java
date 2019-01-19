package jp.ac.uryukyu.ie.e185703;

public class Main {
    public static void main(String args[]){
        Field field = new Field();
        System.out.println("あなたの色は黒です。");
        while(true){
            System.out.println("あなたの番です。");
            field.turnStone("●");
            field.cpuTurnStone("○");
        }
    }

}

