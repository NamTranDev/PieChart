package com.luantc.test;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.luantc.test.animation.ChartAnimator;
import com.luantc.test.animation.Easing;
import com.luantc.test.animation.EasingFunction;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    View pie1, pie2, pie3, pie4, pie5;
    CircleLayout pie;
    ViewModel pie1View;
    ViewModel pie2View;
    ViewModel pie3View;
    ViewModel pie4View;
    ViewModel pie5View;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pie1 = (View) findViewById(R.id.pie1);
        pie2 = (View) findViewById(R.id.pie2);
        pie3 = (View) findViewById(R.id.pie3);
        pie4 = (View) findViewById(R.id.pie4);
        pie5 = (View) findViewById(R.id.pie5);
/*
        Bitmap a = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.b);
        Bitmap c = BitmapFactory.decodeResource(getResources(), R.drawable.c);
        Bitmap d = BitmapFactory.decodeResource(getResources(), R.drawable.d);
        Bitmap e = BitmapFactory.decodeResource(getResources(), R.drawable.e);

        pie1.setBackground(new BitmapDrawable(getResources(),a));
        pie2.setBackground(new BitmapDrawable(getResources(),b));
        pie3.setBackground(new BitmapDrawable(getResources(),c));
        pie4.setBackground(new BitmapDrawable(getResources(),d));
        pie5.setBackground(new BitmapDrawable(getResources(),e));*/

        setViewModel();

        pie1.setOnClickListener(this);
        pie4.setOnClickListener(this);
        pie2.setOnClickListener(this);
        pie3.setOnClickListener(this);
        pie5.setOnClickListener(this);

        /*
         * All code below is NOT required. I've added it just for demonstration
		 * of different layout modes
		 */

        pie = (CircleLayout) findViewById(R.id.pie);

        pie.setAnimationOnly(true);
    }

    @Override
    public void onClick(final View v) {

        int id = v.getId();

        defaultHighLight();

        if (id == R.id.pie1){

            Toast.makeText(getApplicationContext(), "" + pie1View.getPercentage(), Toast.LENGTH_SHORT).show();
            pie1View.setNeedHighlight(true);
            pie.invalidate();
            animation(pie1);

        }else if (id == R.id.pie2){

            Toast.makeText(getApplicationContext(), "" + pie2View.getPercentage(), Toast.LENGTH_SHORT).show();
            pie2View.setNeedHighlight(true);
            pie.invalidate();
            animation(pie2);

        }else if (id == R.id.pie3){

            Toast.makeText(getApplicationContext(), "" + pie3View.getPercentage(), Toast.LENGTH_SHORT).show();
            pie3View.setNeedHighlight(true);
            pie.invalidate();
            animation(pie3);

        }else if (id == R.id.pie4){

            Toast.makeText(getApplicationContext(), "" + pie4View.getPercentage(), Toast.LENGTH_SHORT).show();
            pie4View.setNeedHighlight(true);
            pie.invalidate();
            animation(pie4);

        }else if (id == R.id.pie5){

            Toast.makeText(getApplicationContext(), "" + pie5View.getPercentage(), Toast.LENGTH_SHORT).show();
            pie5View.setNeedHighlight(true);
            pie.invalidate();
            animation(pie5);

        }
    }

    private void animation(View view){
        AnimationSet animSet = new AnimationSet(true);
        animSet.setInterpolator(new DecelerateInterpolator());
        animSet.setFillAfter(true);
        animSet.setFillEnabled(true);
        CircleLayout.LayoutParams params = pie.layoutParams(view);
        Log.d("angle", String.valueOf(params.startAngle) + "  >>> " + String.valueOf(params.endAngle));
        int start = (int) ((params.endAngle + params.startAngle) / 2);
        pie.animate().rotation(180 - start);
    }

    private void defaultHighLight(){
        pie1View.setNeedHighlight(false);
        pie2View.setNeedHighlight(false);
        pie3View.setNeedHighlight(false);
        pie4View.setNeedHighlight(false);
        pie5View.setNeedHighlight(false);
    }

    private void setViewModel(){
        pie1View = new ViewModel(15f, false);
        pie2View = new ViewModel(10f, false);
        pie3View = new ViewModel(30f, false);
        pie4View = new ViewModel(5f, false);
        pie5View = new ViewModel(40f, false);

        pie1.setTag(pie1View);
        pie2.setTag(pie2View);
        pie3.setTag(pie3View);
        pie4.setTag(pie4View);
        pie5.setTag(pie5View);
    }
}
