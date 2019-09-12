package com.zhoug.animations.module;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    private View bottomView;
    private View tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomView = findViewById(R.id.ll_bottom);
        tv = findViewById(R.id.tv);

        addListener();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_circle);
        animation.setDuration(3000);

        tv.startAnimation(animation);
    }

    private void addListener() {

        findViewById(R.id.btn1).setOnClickListener(v -> {
            Dialog dialog = new Dialog(this);
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.gravity = Gravity.BOTTOM;
            dialog.getWindow().setAttributes(attributes);
            dialog.setContentView(R.layout.dialog_view);
            dialog.getWindow().setWindowAnimations(R.style.anim_show_from_bottom);
            dialog.show();

        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            Intent intent = new Intent(this, NextActivity.class);
            Bundle translateBundle = new Bundle();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                startActivity(intent,translateBundle );
            }else{
                startActivity(intent);
            }
            //需要在startAtivity方法或者是finish方法调用之后执行
            //参数1:启动的activity显示动画
            //参数2:本activity退出动画,
            overridePendingTransition(R.anim.anim_popu_in_top,R.anim.anim_popu_out );

        });

    }
}
