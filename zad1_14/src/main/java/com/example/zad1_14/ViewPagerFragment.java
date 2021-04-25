package com.example.zad1_14;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ViewPagerFragment extends Fragment {
    private TextView tvPl;
    private TextView tvAng;
    private Button button;
    private String color;
    private String textPl;
    private String textAng;
    private boolean click = false;

    public ViewPagerFragment(String color, String textPl, String textAng) {
        super();
        this.color = color;
        this.textPl = textPl;
        this.textAng = textAng;
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        tvPl =  view.findViewById(R.id.text_pl);
        tvAng = view.findViewById(R.id.text_ang);
        button = view.findViewById(R.id.button_odp);
        tvPl.setBackgroundColor(Color.parseColor(color));
        tvAng.setBackgroundColor(Color.parseColor(color));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAng.setText(textAng);
                click = true;
            }
        });

        tvPl.setText(textPl);

        if (click) {
            tvAng.setText(textAng);
        }

        return view;
    }
}
