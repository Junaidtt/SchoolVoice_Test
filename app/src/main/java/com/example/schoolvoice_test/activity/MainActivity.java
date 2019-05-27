package com.example.schoolvoice_test.activity;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.schoolvoice_test.adapter.ViewPagerAdapter;
import com.example.schoolvoice_test.model.DbOperations;
import com.example.schoolvoice_test.R;

public class MainActivity extends AppCompatActivity {

    //Button initialisation
     Button viewButton,likeButton;
     ImageButton closeButton,actionIcon;
     TextView textCount;
     DbOperations dbOperations = new DbOperations();

    // activity life cycle methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize vies
        initViews();

        // insert into action table if table is empty
        if (dbOperations.isEmptyData(this)){
            dbOperations.prepareData(MainActivity.this);
        }

    }

    // initialise view objects
    private void initViews(){

        viewButton = (Button)findViewById(R.id.viewButton);
        likeButton = (Button)findViewById(R.id.likesButton);
        closeButton = (ImageButton) findViewById(R.id.closeButton);
        actionIcon = (ImageButton) findViewById(R.id.actionIconId);
        textCount = (TextView)findViewById(R.id.countTextId);

        likeButton.setTextColor(Color.parseColor("#d3d3d3"));
        viewButton.setTextColor(Color.parseColor("#000000"));
        actionIcon.setImageResource(R.drawable.ic_eye);
        textCount.setText(String.valueOf(dbOperations.getViewsCount(MainActivity.this)));

        final ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

                switch (position){

                    case 0:
                        onViewstapped();
                        break;
                    case 1:
                        onLikesTapped();
                        break;

                     default:
                         Log.i("ViewPage Position","Default view");
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        // On click listener button
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0,true);
               // onViewstapped();

            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1,true);
               // onLikesTapped();
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Update on views Tapoped
    private void onViewstapped(){

        actionIcon.setImageResource(R.drawable.ic_eye);
        likeButton.setTextColor(Color.parseColor("#d3d3d3"));
        viewButton.setTextColor(Color.parseColor("#000000"));
        textCount.setText(String.valueOf(dbOperations.getViewsCount(MainActivity.this)));
    }

    // update on Likes tapped
    private  void onLikesTapped(){

        actionIcon.setImageResource(R.drawable.ic_heart);
        viewButton.setTextColor(Color.parseColor("#d3d3d3"));
        likeButton.setTextColor(Color.parseColor("#000000"));
        textCount.setText(String.valueOf(dbOperations.getLikesCount(MainActivity.this)));
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        dbOperations.releaseDb();
    }
}
