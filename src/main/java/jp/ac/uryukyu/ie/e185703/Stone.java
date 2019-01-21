package jp.ac.uryukyu.ie.e185703;


public class Stone {
    private int x;
    private int y;
    private String color;//B:黒, W:白, E:空　null:おけない場所（盤面外）

    /**
     * コンストラクタ。石の座標と色(空を表す"E")を指定する。
     * @param x　x座標
     * @param y　y座標
     */
    public Stone(int x, int y){
        this.x = x;
        this.y = y;
        color = null;
    }

    /**
     * 石の色を指定するメソッド。
     * @param color　変えたい色(B:黒, W:白, E:空)
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * 石の色を返すメソッド。
     * @return 石の色
     */
    public String getColor(){
        return color;
    }

    /**
     * 石があるマスの座標を返すメソッド。
     * @return 石があるマスの座標。
     */
    public int[] getPosition(){
        int pos[] = {this.x, this.y};
        return pos;
    }

}
