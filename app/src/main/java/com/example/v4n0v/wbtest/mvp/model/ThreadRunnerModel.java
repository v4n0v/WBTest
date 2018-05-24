package com.example.v4n0v.wbtest.mvp.model;

import android.os.Handler;

/// класс, отвечающий за запуск потоков
public class ThreadRunnerModel {
    // определяю кол-во потоков
    private static final int THREADS_COUNT = 2;
    public ThreadRunnerModel(Handler handler) {
        this.handler = handler;
    }
    private Handler handler;

    // создается регламентированное кол-во потоков и запускается
    public void execute() throws InterruptedException {
        CounterRunnable[] threads = new CounterRunnable[THREADS_COUNT];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CounterRunnable(handler);
        }

        for (int i = 0; i < threads.length; i++) {
            new Thread(threads[i]).start();
        }
    }
}
