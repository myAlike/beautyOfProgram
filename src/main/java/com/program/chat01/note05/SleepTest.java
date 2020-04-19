package com.program.chat01.note05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepTest {
    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                LOCK.lock();
                try {
                    System.out.println("child  threadA is in sleep");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    LOCK.unlock();
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取独占锁
                LOCK.lock();
                try {
                    System.out.println("child  threadB is in sleep");
                    Thread.sleep(1000);
                    System.out.println("child threadB is in awaled");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    LOCK.unlock();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();
    }
}
