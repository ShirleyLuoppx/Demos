package com.ppx.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * TextSwitcher就是一个textview的功能额外加上了能像跑马灯滚动切换内容的效果
 */
public class TestActivity extends AppCompatActivity {

    private TextSwitcher textSwitcher;
    private List<String> strList;
    private Handler handler;
    private int index = 0;
    private AnimationSet inAnimationSet;
    private AnimationSet outAnimationSet;
    private static final int DURATION = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textSwitcher = findViewById(R.id.textswitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return new TextView(TestActivity.this);
            }
        });

        strList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strList.add("内容 " + i);
        }

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                if (msg.what == 1001) {
                    index++;
                    index = index % strList.size();

                    textSwitcher.setText(strList.get(index));
                    handler.sendEmptyMessageDelayed(1001, 2000);
                }
                Log.d("TAG", "handleMessage: index = " + index);
            }
        };

        //相当于一个textview但是不能给这个控件设置文字内容的大小样式这些
        textSwitcher.setText(strList.get(0));
        createAnimation();
        textSwitcher.setInAnimation(inAnimationSet);
        textSwitcher.setOutAnimation(outAnimationSet);
        handler.sendEmptyMessageDelayed(1001, 2000);
    }

    private void createAnimation() {
        AlphaAnimation alphaAnimation;
        TranslateAnimation translateAnimation;

        int h = textSwitcher.getHeight();
        if (h <= 0) {
            textSwitcher.measure(0, 0);
            h = textSwitcher.getMeasuredHeight();
        }

        inAnimationSet = new AnimationSet(true);
        outAnimationSet = new AnimationSet(true);

        alphaAnimation = new AlphaAnimation(0, 1);
        translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, h, Animation.ABSOLUTE, 0);
        inAnimationSet.addAnimation(alphaAnimation);
        inAnimationSet.addAnimation(translateAnimation);
        inAnimationSet.setDuration(DURATION);

        alphaAnimation = new AlphaAnimation(1, 0);
        translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -h);
        outAnimationSet.addAnimation(alphaAnimation);
        outAnimationSet.addAnimation(translateAnimation);
        outAnimationSet.setDuration(DURATION);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1001);
    }
}
