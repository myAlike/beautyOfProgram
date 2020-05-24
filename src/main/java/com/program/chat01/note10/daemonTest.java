package com.program.chat01.note10;

public class daemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){}
            }
        });
        //启动子线程
        thread.start();
        System.out.println("main thread is over");
    }
}
