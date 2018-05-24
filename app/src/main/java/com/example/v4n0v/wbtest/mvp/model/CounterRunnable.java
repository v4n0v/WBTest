package com.example.v4n0v.wbtest.mvp.model;

import android.os.Handler;
import com.example.v4n0v.wbtest.common.ResultWriter;
import java.util.concurrent.atomic.AtomicBoolean;
import timber.log.Timber;

public class CounterRunnable implements Runnable {
    private static AtomicBoolean isFinished = new AtomicBoolean(false);
    private String name;
    private Handler handler;
    private static int THREAD_COUNT;

    static {
        THREAD_COUNT = 0;
    }

    // передаю хэндлер, присваиваю имя потока
    CounterRunnable(Handler handler) {
        THREAD_COUNT++;
        this.name = "поток " + THREAD_COUNT;
        this.handler = handler;
    }


    @Override
    public void run() {
        // считаю до 100, записываю в файл, логирую происходящее
        for (int i = 1; i < 101; i++) {
            String info = this.name + ": текущее значение " + i + "\n";
            ResultWriter.writeText(info);
            Timber.d(info);
        }

        // как только операция закончена, отпределяется первый, справившийся, поток
        if (!isFinished.getAndSet(true)) {
            ResultWriter.writeText(this.name + ": закончил первым");
            Timber.d(this.name + ": закончил первым" + "\n");
        } else {
            ResultWriter.writeText(this.name + ": закончил вторым");
            Timber.d(this.name + ": закончил вторым" + "\n");
        // посылаю коллбэк об успешном окончании работы потоко
            handler.sendEmptyMessage(1);
        }
    }
}