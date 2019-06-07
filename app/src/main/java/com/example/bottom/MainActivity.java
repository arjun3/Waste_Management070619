package com.example.bottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {

    SliderView sliderView;
    ImageView notification, stack, chat;
    LinearLayout layout;
    NestedScrollView scrollView;
//    CoordinatorLayout coordinator;
    ConstraintLayout constraintLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = findViewById(R.id.sliderView);

        notification = findViewById(R.id.bottom_notification);
        stack = findViewById(R.id.bottom_stack);
        chat = findViewById(R.id.bottom_chat);
        layout = findViewById(R.id.li_popup);
        scrollView = findViewById(R.id.nested_scroll);
//        coordinator = findViewById(R.id.coordinator);
        constraintLayout = findViewById(R.id.constraint);



        SliderAdapter adapter = new SliderAdapter(this);
        sliderView.setSliderAdapter(adapter);



        sliderView.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using 	  SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);

                } else {
                    Animation bottomUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_up);
                    layout.startAnimation(bottomUp);
                    layout.setVisibility(View.VISIBLE);

                }

            }
        });

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout.getVisibility() == View.VISIBLE) {
                    layout.setVisibility(View.GONE);
                }
            }
        });


    }

}
