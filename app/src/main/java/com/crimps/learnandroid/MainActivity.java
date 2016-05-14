package com.crimps.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //匿名内部类实现监听
        //初始化控件
        Button buttonOne;
        buttonOne = (Button) findViewById(R.id.buttonOne);
        //添加监听事件
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("info", "Button one was clicked");
            }
        });

        //外部类实现监听
        Button buttonTwo;
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new MyOnClickListener() {
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this, "button two was clicked", Toast.LENGTH_LONG).show();
            }
        });

        //接口方式实现
        Button buttonThree;
        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(this);

        //AutoCompleteTextView
        //初始化控件
        AutoCompleteTextView autoCompleteTextView;
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        //添加数据源
        String[] resc = {"PEK", "XMN", "SHA", "PPT", "XMU", "CUK", "P1", "P2", "P3", "P4", "p5", "p7", "p8"};
        //添加一个适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, resc);
        //控件与适配器绑定
        autoCompleteTextView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Button three was clicked", Toast.LENGTH_SHORT).show();
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