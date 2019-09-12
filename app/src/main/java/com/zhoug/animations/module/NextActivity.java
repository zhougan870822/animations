package com.zhoug.animations.module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public void next(View view) {
        Intent intent = new Intent(this, Next2Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_popu_in,R.anim.anim_popu_out_right );

    }
}
