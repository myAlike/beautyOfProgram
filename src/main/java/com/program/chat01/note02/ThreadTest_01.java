package com.program.chat01.note02;

public class ThreadTest_01 {
    public static class Mythread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static void main(String[] args) {
        // 创建线程
        Mythread thread = new Mythread();
        // 启动线程
        thread.start();
    }
}
