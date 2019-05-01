package com.ce.foolchat;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.hyphenate.chat.EMClient;


public class firstPage extends AppCompatActivity {
    private ImageView img1;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        if (EMClient.getInstance().isConnected()){
            Intent intent=new Intent(firstPage.this,MainActivity.class);
            startActivity(intent);
        }
        img1 = findViewById(R.id.imageView);
        bt1 = findViewById(R.id.button);
        ObjectAnimator scaleAnim1 = ObjectAnimator.ofFloat(img1, "scaleX", 0f, 2f, 1.6f);
        ObjectAnimator scaleAnim2 = ObjectAnimator.ofFloat(img1, "scaleY", 0f, 2f, 1.6f);
        scaleAnim1.setDuration(6000);
        scaleAnim1.start();
        scaleAnim2.setDuration(6000);
        scaleAnim2.start();

        ObjectAnimator alphaAnim1 = ObjectAnimator.ofFloat(bt1, "alpha", 0f, 3f);
        alphaAnim1.setDuration(10000);
        //alphaAnim1.setRepeatCount(1);//设置重复播放的次数
        //alphaAnim1.setRepeatMode(ObjectAnimator.); 设置播放的模式
        alphaAnim1.start();


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在按钮响应函数中添加如下两句话就ok了
                Intent intent=new Intent(firstPage.this,LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}
