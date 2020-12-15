package com.app.sizzlingbites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductioryActivity extends AppCompatActivity {
/* ImageView logo,appName,splashImage;
 LottieAnimationView lottieAnimationView;*/

  ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_introductiory );
        viewPager=findViewById( R.id.pager );
     /*   logo=findViewById( R.id.logo );
        appName=findViewById( R.id.name );
        splashImage=findViewById( R.id.background );
        lottieAnimationView=findViewById( R.id.animationView );







        splashImage.animate().translationX(-1600).setDuration( 1000 ).setStartDelay( 4000 );
        logo.animate().translationX(1400).setDuration( 1000 ).setStartDelay( 4000 );
        lottieAnimationView.animate().translationX(1400).setDuration( 1000 ).setStartDelay( 4000 );
        appName.animate().translationX(1400  ).setDuration( 1000 ).setStartDelay( 4000 );*/
        adapter myadapter=new adapter( getSupportFragmentManager() );
        viewPager.setAdapter( myadapter );



    }
}