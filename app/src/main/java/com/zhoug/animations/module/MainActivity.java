package com.zhoug.animations.module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private View bottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomView=findViewById(R.id.ll_bottom);

        addListener();
    }

    private void addListener(){

        findViewById(R.id.btn1).setOnClickListener(v->{
            if(bottomView.getVisibility()==View.GONE){
                bottomView.setVisibility(View.VISIBLE);
            }else{
                bottomView.setVisibility(View.GONE);
            }

        });

        findViewById(R.id.btn2).setOnClickListener(v->{
            Intent intent=new Intent(this,NextActivity.class);

            startActivity(intent);

        });

    }
}
