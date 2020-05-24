package com.program.chat01.note02;

public class RunableTask_02 implements Runnable{



    public static void main(String[] args) {
        RunableTask_02 task = new RunableTask_02();
        new Thread(task).start();
    }

    @Override
    public void run() {
        System.out.println("I am a child thread");
    }
}
