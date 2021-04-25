package com.example.zad1_14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerFragment[] viewPagerFragments;
    private String[] polish = {"kot", "pies", "rosomak"};
    private String[] english = {"cat", "dog", "wolverine"};
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPagerFragments = new ViewPagerFragment[polish.length];
        for (int i = 0; i < viewPagerFragments.length; i++){
            viewPagerFragments[i] = new ViewPagerFragment(String.format("#%s%s%s", getRandomNumber(0x00, 0xFF), getRandomNumber(0x00, 0xFF), getRandomNumber(0x00, 0xFF)), polish[i], english[i]);
        }
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return viewPagerFragments[position];
        }

        @Override
        public int getCount() {
            return viewPagerFragments.length;
        }
    }

}