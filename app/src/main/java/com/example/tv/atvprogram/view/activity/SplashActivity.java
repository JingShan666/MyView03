package com.example.tv.atvprogram.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tv.atvprogram.R;

/**
 * Created by Liu on 2017/8/24 0024.
 * 欢迎页面
 * 功能：加载一个广告页面
 */

public class SplashActivity extends Activity{
    private Button btn_count_time;
    private int time=5;

    /**
     *Handler与Message结合实现倒计时
     */
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){

                case 1:
                    time--;
                    Log.e("time:",time+"");
                    btn_count_time.setText(time+"s");
                    if (time>0){
                        Message message= handler.obtainMessage(1);
                        handler.sendMessageDelayed(message,1000);
                    }else {
                        btn_count_time.setVisibility(View.GONE);
                        Intent intent= new Intent(SplashActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        initView();
    }

    private void initView() {
        btn_count_time= findViewById(R.id.bt_count_time);
        btn_count_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_count_time.setVisibility(View.GONE);
                Intent intent= new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Message message= handler.obtainMessage(1);
        handler.sendMessageDelayed(message,1000);
    }
}
