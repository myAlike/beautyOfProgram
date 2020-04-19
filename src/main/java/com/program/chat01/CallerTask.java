package com.program.chat01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) {
        // 创建异步任务
        FutureTask<String> futureTask = new FutureTask<String>(new CallerTask());
        // 启动线程
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
