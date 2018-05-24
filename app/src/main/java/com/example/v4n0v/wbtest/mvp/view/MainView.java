package com.example.v4n0v.wbtest.mvp.view;

import com.arellomobile.mvp.MvpView;

/**
 * интерфейс вьюшки
 */

public interface MainView extends MvpView {
    void init();
    void setButtonText(String text);
}
