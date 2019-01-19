package jp.ac.uryukyu.ie.e185703;

public class Main {
    public static void main(String args[]){
        Field field = new Field();
        while(true){
            if(field.judgeExistCanReverseStone("○").size() != 0){
                field.turnStone("○");
            }
            if(field.judgeExistCanReverseStone("●").size() == 0 && field.judgeExistCanReverseStone("○").size() == 0){
                break;
            }
            if(field.judgeExistCanReverseStone("●").size() != 0) {
                field.cpuTurnStone("●");
            }
            if(field.judgeExistCanReverseStone("●").size() == 0 && field.judgeExistCanReverseStone("○").size() == 0){
                break;
            }

        }
        field.judgeWinner();
    }

}

