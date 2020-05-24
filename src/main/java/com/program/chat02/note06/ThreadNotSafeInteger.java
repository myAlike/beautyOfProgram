package com.program.chat02.note06;

public class ThreadNotSafeInteger {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
