package com.example.administrator.objectanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ObjectAnimator animator;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.iv);
    }


    // 透明度动画
    public void alpha(View v) {

        // imageView.setAlpha(alpha)

//        imageView.clearAnimation();  // 这个并没有用

        if (animatorSet != null) animatorSet.cancel();
        if (animator != null) animator.cancel();

        // 然后接下来的代码是模版代码
        // target: 用于指定 动画作用到哪个 控件上
        // propertyName:属性的名称
        // 具体的 动画效果 的 参数值
        animator = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f,
                1.0f);

        // 还是要设置 三个参数
        // 时长, 重复的次数, 重复的模式
        animator.setDuration(2000);
        animator.setRepeatCount(0); // 重复次数
        animator.setRepeatMode(ObjectAnimator.RESTART); // 重复的模式  只有在repeatCount大于0或为INFINITE的时候setRepeatMode才会生效。

        animator.start();
//        animator.cancel();  //马上就会取消，并且不会还原，保持原来的效果，这里会变成透明度为零（看不见了）
    }

    // 平移动画
    public void translate(View v) {

        // imageView.setTranslationX(translationX)

//        imageView.clearAnimation();   这个并没有用

        if (animatorSet != null) animatorSet.cancel();
        if (animator != null) animator.cancel();

        animator = ObjectAnimator.ofFloat(imageView, "translationX",
                0, 100);

        animator.setDuration(2000);
        animator.setRepeatCount(0); // 重复无限多次
        animator.setRepeatMode(ObjectAnimator.REVERSE); // 重复的模式

        animator.start();

    }

    // 缩放动画
    public void scale(View v) {

        // imageView.setScaleX(scaleX);

//        imageView.clearAnimation();   这个并没有用

        if (animatorSet != null) animatorSet.cancel();
        if (animator != null) animator.cancel();

        animator = ObjectAnimator.ofFloat(imageView, "scaleY", 0.0f,2.0f);

        animator.setDuration(2000);
        animator.setRepeatCount(0); // 重复无限多次
        animator.setRepeatMode(ObjectAnimator.REVERSE); // 重复的模式

        animator.start();

    }

    // 旋转动画
    public void rotate(View v) {

        // imageView.setRotationX(rotationX)

//        imageView.clearAnimation(); 这个并没有用

        if (animatorSet != null) animatorSet.cancel();
        if (animator != null) animator.cancel();

        animator = ObjectAnimator.ofFloat(imageView, "rotationY", 0,360);

        animator.setDuration(2000);
        animator.setRepeatCount(0); // 重复无限多次
        animator.setRepeatMode(ObjectAnimator.REVERSE); // 重复的模式

        animator.start();

    }

    public void set(View v) {

//        imageView.clearAnimation(); 这个并没有用

        if (animator != null) animator.cancel();
        if (animatorSet != null) animatorSet.cancel();

        animatorSet = new AnimatorSet();

        ObjectAnimator tax = ObjectAnimator.ofFloat(imageView, "translationX", 0,100);

        tax.setDuration(2000);
        tax.setRepeatCount(0); // 重复无限多次
//		tax.setRepeatMode(ObjectAnimator.REVERSE); // 重复的模式

        ObjectAnimator tay = ObjectAnimator.ofFloat(imageView, "translationY", 0,100);

        tay.setDuration(2000);
        tay.setRepeatCount(0);
//		tay.setRepeatMode(ObjectAnimator.REVERSE);

        // 指定 按照 顺序 播放
//		set.playSequentially(tax,tay);

        //指定同时播放
        animatorSet.playTogether(tax,tay);

        animatorSet.start();
    }
}
