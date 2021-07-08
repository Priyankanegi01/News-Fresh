package com.priyanka.newsfresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.priyanka.newsfresh.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {
      TabLayout tabLayout;
      TabItem mHome,mSports,mHealth,mEntertainment,mScience,mTechonology;
      PagerAdapter pagerAdapter;
      Toolbar mToolbar;
      ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        mToolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);

        mEntertainment=findViewById(R.id.enetertainment);
        mHealth=findViewById(R.id.health);
        mSports=findViewById(R.id.sports);
        mScience=findViewById(R.id.science);
        mTechonology=findViewById(R.id.technology);
        mHome=findViewById(R.id.home);

        viewPager=findViewById(R.id.fragment_container_viewpager);
        tabLayout=findViewById(R.id.newsSections);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1|tab.getPosition()==2|tab.getPosition()==3|tab.getPosition()==4|tab.getPosition()==5){
                  pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}