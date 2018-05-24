package com.example.v4n0v.wbtest.mvp.presenter;

import android.os.Handler;
import android.os.Message;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.v4n0v.wbtest.mvp.model.ThreadRunnerModel;
import com.example.v4n0v.wbtest.mvp.view.MainView;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>  {
    private ThreadRunnerModel model;

    // коллбэк ожидающий завершение события из потоков, по завершении, сообщает вьюшке поменять текст кнопки
    private Handler uiHandler = new Handler(msg -> {
        switch (msg.what) {
            case 1:
                getViewState().setButtonText("Start");
                return true;
        }
        return false;
    });

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();
        model = new ThreadRunnerModel(uiHandler);
        getViewState().setButtonText("Start");

    }

    public void start() {
        getViewState().setButtonText("Stop");
        try {
            model.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
