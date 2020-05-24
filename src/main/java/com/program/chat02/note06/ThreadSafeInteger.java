package com.program.chat02.note06;

public class ThreadSafeInteger {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
