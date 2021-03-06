package com.example.zad1_12;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    public static final String KEY = "tutaj stala do intencji";

    private EditText etName;
    private EditText etPrice;
    private EditText etAmount;
    private Button bNext;
    private double sum = 0;
//    private TextView podgladCzyProgramDziala; D Z I A Ł A !!!
    private Button bSum;

    @Override
    protected void onStart() {
        super.onStart();
        etName.requestFocus();
        etName.setText("");
        etPrice.setText("");
        etAmount.setText("");
    }

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
            startActivityForResult(intent, REQUEST_CODE);
        }
    };

    private View.OnClickListener goToThirdActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            double product = Double.parseDouble("0" + Double.toString(sum));

            intent.putExtra(ThirdActivity.SUMKA, product);
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
//        podgladCzyProgramDziala = (TextView) findViewById(R.id.textView3); D Z I A Ł A !!!
        bSum = (Button) findViewById(R.id.sumButton);

        bNext.setOnClickListener(action); // (*) c.d.
        bSum.setOnClickListener(goToThirdActivity);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        // czy przyszło odpowiednie żądanie
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // czy mamy wynik o kluczu KEY
            if (intent.hasExtra(KEY)) {
                double part = intent.getDoubleExtra(KEY, 0);
                // dla sprawdzenia komunikacji wyświetlmy na ekranie:
                Toast.makeText(getApplicationContext(), "" + part, Toast.LENGTH_SHORT).show();
                // tutaj obliczenia na bieżąco sumy wszystkich towarów
                // UZUPEŁNIĆ
                sum += part;
//                podgladCzyProgramDziala.setText(String.format("Suma wynosi %s.", sum)); D Z I A Ł A !!!
            }
        }
    }

}