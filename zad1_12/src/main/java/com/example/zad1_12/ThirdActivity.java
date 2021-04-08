package com.example.zad1_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity  {
    public static final String SUMKA = "sumka";
    private TextView result;
    private Button bEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        double d = intent.getDoubleExtra(SUMKA, 0);

        result = (TextView) findViewById(R.id.result);
        bEnd = (Button) findViewById(R.id.bEnd); //guziczek wróć


        if (d != 0) {
            String wynik = String.format("Razem należy zapłacić %s", d);
            result.setText(wynik);
        } else {
            result.setText("Brak danych do obliczenia");
        }

        bEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
