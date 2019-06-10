package com.example.bottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SliderView sliderView;
    ImageView  stack, chat;
    FrameLayout layout;
    NestedScrollView scrollView;
    ConstraintLayout constraintLayout;
    ImageView Register;
    LinearLayout notification;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.sliderView);
        notification = findViewById(R.id.bottom_notification_li);
        notification.setOnClickListener(this);
        stack = findViewById(R.id.bottom_stack);
        chat = findViewById(R.id.bottom_chat);
        layout = findViewById(R.id.frame_popup);
        scrollView = findViewById(R.id.nested_scroll);
        constraintLayout = findViewById(R.id.constraint);
        constraintLayout.setOnClickListener(this);
        Register = findViewById(R.id.register);
        Register.setOnClickListener(this);

        SliderAdapter adapter = new SliderAdapter(this);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using 	  SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();


    }



    @Override
    public void onClick(View v) {
        Intent intent;
        Fragment fragment;

        switch (v.getId()){

            case R.id.register:

                intent = new Intent(this, UserRegistration.class);
                startActivity(intent);
                break;

            case R.id.constraint:

                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                }
                break;

            case R.id.bottom_notification_li:

                if (layout.getVisibility() == View.VISIBLE){
                    layout.setVisibility(View.GONE);
                } else {
                    Animation bottomUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_up);
                    layout.startAnimation(bottomUp);
                    layout.setVisibility(View.VISIBLE);
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                }
                break;



        }
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_popup, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
