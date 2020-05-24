package com.program.chat01.note11;

public class TestThreadLocal {
    // (1) 创建ThreadLocal变量
    static ThreadLocal<String> localVariable = new ThreadLocal<String>();

    public static void main(String[] args) {
        // (2) 设置线程变量
        localVariable.set("hello world");
        // (3) 启动子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread:" + localVariable.get());
            }
        });
        thread.start();
        // (5) 主线程输出线程变量值
        System.out.println("main:"+localVariable.get());
    }
}
