package com.example.v4n0v.wbtest.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.v4n0v.wbtest.R;
import com.example.v4n0v.wbtest.mvp.presenter.MainPresenter;


public class MainActivity extends MvpAppCompatActivity implements MainView {

    Button buttonStart;

    @InjectPresenter
    MainPresenter presenter;

    // отработка нажатия кнопки
    public void onButtonClick(View view) {
        presenter.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // инициализация вьюшек активности
    @Override
    public void init() {
        buttonStart = findViewById(R.id.buttonStart);
    }

    @Override
    public void setButtonText(String text) {
        buttonStart.setText(text);
    }
}
