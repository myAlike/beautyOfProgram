package com.program.chat01.note07;

public class InterrupteTest3 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        // 启动子线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterruptec:" + threadOne.interrupted());
        //获取中断标志并重置
        System.out.println("isInterruptec:" + Thread.interrupted());
        //获取中断标志并重置
        System.out.println("isInterruptec:" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        // 等待子线程执行完毕
        threadOne.join();
        System.out.println("main thread is over");
    }
}
