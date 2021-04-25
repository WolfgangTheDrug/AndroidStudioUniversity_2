package com.example.zad1_15;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewPagerFragment extends Fragment {

    private final String textColor;
    private TextView tvPl;
    private EditText etAng;
    private Button button;
    private String backgroundColor;
    private String textPl;
    private String textAng;
    private boolean kliknieto = false;
    public static int correctCounter = 0;
    public static int howMany = 5;

    private String invertHexColor(String hexColor) {
        char[] hexChar = hexColor.substring(1).toCharArray(); // array sześciu cyfr heksadecymalnych
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(String.valueOf(hexChar[2*i]), 16); // wyciąnij co drugą cyfrę
            value = 0xF - value; // odwróć tę cyfrę względem bazy?
            hexChar[2*i] = (Integer.toHexString(value)).charAt(0); // zamień starą cyfrę na nową
        } // nadal mam sześć cyfr
        return  "#" + new String(hexChar);
    }

    public ViewPagerFragment(String backgroundColor, String textPl, String textAng) {
        super();
        this.backgroundColor = backgroundColor;
        this.textColor = invertHexColor(backgroundColor);
        this.textPl = textPl;
        this.textAng = textAng;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        tvPl = view.findViewById(R.id.textPL);
        etAng = view.findViewById(R.id.etANG);
        button = view.findViewById(R.id.buttonODP);

        tvPl.setBackgroundColor(Color.parseColor(backgroundColor));
        etAng.setBackgroundColor(Color.parseColor(backgroundColor));
        tvPl.setTextColor(Color.parseColor(textColor));
        etAng.setTextColor(Color.parseColor(textColor));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAng.getText().toString().equals(textAng)) {
                    Toast toast = Toast.makeText(getContext(), "Bravo!", Toast.LENGTH_SHORT);
                    toast.show();
                    if (kliknieto) {
                        correctCounter += 0;
                    } else {
                        correctCounter += 1;
                        kliknieto = true;
                    }
                } else {
                    Toast toast = Toast.makeText(getContext(), "Spróbuj jeszcze raz!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        tvPl.setText(textPl);

        return view;
    }

}