package com.example.zad1_15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private static ViewPagerFragment[] tabFragm;
    private Button check;

    public String getRandomColor() {
        int number = 0;
        String hexValue = "", color = "#";

        for (int i = 0; i < 3; i++) {
            number = (int) ( Math.random() * Math.pow(16, 2) );
            hexValue = Integer.toHexString(number);
            color += hexValue.length() == 1 ? "0" + hexValue : hexValue;
        }
        return color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = findViewById(R.id.buttonCheck);

        TypedArray slowka = getResources().obtainTypedArray(R.array.dictionary);
        tabFragm = new ViewPagerFragment[slowka.length()];
        for (int i = 0; i < tabFragm.length; i++){

            String[] separated = slowka.getString(i).split(":");
            
            String polishWord = separated[0];
            String englishWord = separated[1];

            tabFragm[i] = new ViewPagerFragment(getRandomColor(), polishWord, englishWord);
        }
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), String.format("%s na %s", ViewPagerFragment.correctCounter, ViewPagerFragment.howMany), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

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