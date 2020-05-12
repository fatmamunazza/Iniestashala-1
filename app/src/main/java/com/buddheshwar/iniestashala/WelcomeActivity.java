package com.buddheshwar.iniestashala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {
SliderView sliderView;
List<ImageSliderModel> imageSliderModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

       imageSliderModelList=new ArrayList<>();
       sliderView=findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.iniestashala_logo));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.logo));

        sliderView.setSliderAdapter(new ImageSliderAdapter(this,imageSliderModelList));

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);

        sliderView.setIndicatorSelectedColor(Color.WHITE);

        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();
    }

    public void openLoginActivity(View view) {

        startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
    }
}
