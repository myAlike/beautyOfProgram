package com.program.chat01.note09;

public class DeadLockTest {
    // 创建资源
    private static Object resourcesA = new Object();
    private static Object resourcesB = new Object();

    public static void main(String[] args) {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourcesA) {
                    System.out.println(Thread.currentThread() + " get ResourcesA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get sourceB");
                    synchronized (resourcesB) {
                        System.out.println(Thread.currentThread() + "get esourceB");
                    }
                }
            }
        });

        // 创建线程A
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourcesB) {
                    System.out.println(Thread.currentThread() + " get ResourcesB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + "waiting get sourceA");
                    synchronized (resourcesA) {
                        System.out.println(Thread.currentThread() + "get esourceA");
                    }
                }
            }
        });
        // 启动线程
        threadA.start();
        threadB.start();
    }
}
