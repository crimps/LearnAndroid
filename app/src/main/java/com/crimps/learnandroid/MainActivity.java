package com.crimps.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonOne;
    private Button buttonTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //匿名内部类实现监听
        //初始化控件
        buttonOne = (Button) findViewById(R.id.buttonOne);
        //添加监听事件
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "Button one was clicked");
            }
        });

        //外部类实现监听
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new MyOnClickListener() {
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this, "button two was clicked", Toast.LENGTH_LONG).show();
            }
        });

    }
}

class MyOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        if(v.getAlpha() > 0.5f) {
            v.setAlpha(0.5f);
        } else {
            v.setAlpha(1.0f);
        }
    }
}