package com.example.zad1_16;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment2 extends Fragment {
    private TextView tv;
    private String color;
    private String text;

    public static final String COLOR = "color";
    public static final String TEXT = "text";

    private String invertHexColor(String hexColor) {
        char[] hexChar = hexColor.substring(1).toCharArray(); // array sześciu cyfr heksadecymalnych
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(String.valueOf(hexChar[2*i]), 16); // wyciąnij co drugą cyfrę
            value = 0xF - value; // odwróć tę cyfrę względem bazy?
            hexChar[2*i] = (Integer.toHexString(value)).charAt(0); // zamień starą cyfrę na nową
        } // nadal mam sześć cyfr
        return  "#" + new String(hexChar);
    }

    MyFragment2(String color, String text){
        this.color = color;
        this.text = text;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content, container, false);
        tv = view.findViewById(R.id.text_fragment);
        tv.setBackgroundColor(Color.parseColor(color));
        tv.setTextColor(Color.parseColor(invertHexColor(color)));
        tv.setText(text);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(COLOR, color);
        outState.putString(TEXT, text);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            color = savedInstanceState.getString(COLOR);
            text = savedInstanceState.getString(TEXT);
        }
    }

}
