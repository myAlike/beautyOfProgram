package com.program.chat01.note07;

public class InterrupteTest4 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().interrupted()){

                }
                System.out.println("threadOne isInterrupted:" + Thread.currentThread().isInterrupted());
            }
        });

        // 启动子线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        // 等待子线程执行完毕
        threadOne.join();
        System.out.println("main thread is over");
    }
}
