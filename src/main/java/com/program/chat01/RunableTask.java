package com.program.chat01;

public class RunableTask implements Runnable{



    public static void main(String[] args) {
        RunableTask task = new RunableTask();
        new Thread(task).start();
    }

    @Override
    public void run() {
        System.out.println("I am a child thread");
    }
}
