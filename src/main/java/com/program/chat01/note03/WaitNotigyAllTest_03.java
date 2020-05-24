package com.program.chat01.note03;

public class WaitNotigyAllTest_03 {
    // 创建资源
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    // 获取resourceB共享资源的监视器锁
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        // 线程A阻塞，并释放获取到的resourceA的锁
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 创建线程
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    // 获取resourceB共享资源的监视器锁
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        // 线程A阻塞，并释放获取到的resourceA的锁
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 创建线程
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    // 获取resourceB共享资源的监视器锁
                    System.out.println("threadC begin notify");
//                    resourceA.notifyAll();
                    resourceA.notify();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();

        // 等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
