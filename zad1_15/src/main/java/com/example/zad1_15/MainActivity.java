package com.example.zad1_15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.res.TypedArray;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private static ViewPagerFragment[] tabFragm;
//    private String polishWords[] = {"Komputer", "Monitor", "Klawiatura", "Mysz"};
//    private String englishWords[] = {"Computer", "Monitor", "Keyboard", "Mouse"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypedArray slowka = getResources().obtainTypedArray(R.array.slowka);
        tabFragm = new ViewPagerFragment[slowka.length()];
        for (int i = 0; i < tabFragm.length; i++){
            // tu wygenerowanie losowego koloru...
            String temp = slowka.getString(i);
            int index = temp.indexOf(":");

            String plWord = temp.substring(0, index);
            String engWord = temp.substring(index + 1);

            tabFragm[i] = new ViewPagerFragment("#12345F", plWord, engWord);
        }
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

    }

    ///////////////////////////////////////////

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return tabFragm[position];
        }

        @Override
        public int getCount() {
            return tabFragm.length;
        }
    }

}