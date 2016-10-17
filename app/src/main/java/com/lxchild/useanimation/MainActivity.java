package com.lxchild.useanimation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);

        addAnimToList();
    }

    private void addAnimToList() {
        String[] arr1 = new String[]{"孙悟空","猪八戒","沙僧","唐僧"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.array_item, arr1);
        ListView list1 = (ListView) findViewById(R.id.list);
        list1.setAdapter(adapter1);
    }

    private void anim() {
        animation = AnimationUtils.loadAnimation(this, R.anim.animation_test);
        btn.startAnimation(animation);
    }

    private void anim2() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        btn.startAnimation(alphaAnimation);
    }

    private void anim3() {
        btn.setBackgroundResource(R.drawable.frame_animation);
        AnimationDrawable drawable = (AnimationDrawable) btn.getBackground();
        drawable.start();
    }

    public void onClick(View view) {

        anim3();
    }

    public void onClick1(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
      //  overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
    }
}
