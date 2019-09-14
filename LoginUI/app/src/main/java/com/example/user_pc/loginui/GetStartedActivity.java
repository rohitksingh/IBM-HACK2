package com.example.user_pc.loginui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GetStartedActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdaptor sliderAdaptor;
    private TextView[] mDots;
    private TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        setupUIViews();

        mSlideViewPager.setAdapter(sliderAdaptor);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        skip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(GetStartedActivity.this, "Hey", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(GetStartedActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupUIViews() {
        mSlideViewPager = (ViewPager) findViewById(R.id.slide_view_pager);
        mDotLayout = (LinearLayout) findViewById(R.id.dots_layout);
        sliderAdaptor = new SliderAdaptor( GetStartedActivity.this);
        skip = findViewById(R.id.skipIntro);

    }

    public void addDotsIndicator( int position ) {

        mDots = new TextView[3];
        mDotLayout.removeAllViews(); // Extremely important

        for (int i=0; i<mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
