package com.example.zad1_15;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewPagerFragment extends Fragment {

    private TextView tvPl;
    private TextView tvAng;
    private Button button;
    private String color;
    private String textPl;
    private String textAng;
    private boolean kliknieto = false;

    public ViewPagerFragment(String color, String textPl, String textAng) {
        super();
        this.color = color;
        this.textPl = textPl;
        this.textAng = textAng;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        tvPl = view.findViewById(R.id.textPL);
        tvAng = view.findViewById(R.id.textANG);
        button = view.findViewById(R.id.buttonODP);

        tvPl.setBackgroundColor(Color.parseColor(color));
        tvAng.setBackgroundColor(Color.parseColor(color));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvAng.setText(textAng);
                kliknieto = true;
            }
        });

        tvPl.setText(textPl);

        if (kliknieto) {
            tvAng.setText(textAng);
        }

        return view;
    }

}
