package com.priyanka.newsfresh.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.priyanka.newsfresh.Fragments.EntertainentFragment;
import com.priyanka.newsfresh.Fragments.HealthFragment;
import com.priyanka.newsfresh.Fragments.HomeFragment;
import com.priyanka.newsfresh.Fragments.ScienceFragment;
import com.priyanka.newsfresh.Fragments.SportsFragment;
import com.priyanka.newsfresh.Fragments.TechnologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {
      int tabcount;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
               return new HomeFragment();
           case 1:
               return new SportsFragment();
           case 2:
               return new HealthFragment();
           case 3:
               return new ScienceFragment();
           case 4:
               return new EntertainentFragment();
           case 5:
               return new TechnologyFragment();
           default:
               return null;
       }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
