package com.example.zad1_12;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPrice;
    private EditText etAmount;
    private Button bNext;

    private View.OnClickListener action = new View.OnClickListener() { // inny sposób ogarnięcia listenera (*)
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String name = etName.getText().toString();

            double price = Double.parseDouble("0" + etPrice.getText().toString()); //branczles programing łął
            int amount = Integer.parseInt("0" + etAmount.getText().toString()); //egen branczles uhu
            intent.putExtra(SecondActivity.PIERWSZA, name);
            intent.putExtra(SecondActivity.DRUGA, price);
            intent.putExtra(SecondActivity.TRZECIA, amount);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.nameEditText);
        etPrice = (EditText) findViewById(R.id.priceEditText);
        etAmount = (EditText) findViewById(R.id.amountEditText);
        bNext = (Button) findViewById(R.id.calcButton);

        bNext.setOnClickListener(action); // (*) c.d.
    }
}