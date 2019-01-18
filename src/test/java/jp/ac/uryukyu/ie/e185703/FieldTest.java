package jp.ac.uryukyu.ie.e185703;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void changeStoneColor() {
        Field field = new Field();
        field.changeStoneColor(4, 4, "W");
        assertEquals("W", field.getStone(4,4).getColor());
    }
}