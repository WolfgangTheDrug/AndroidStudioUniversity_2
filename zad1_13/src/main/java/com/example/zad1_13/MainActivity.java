package com.example.zad1_13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MyFragment.ActivityActions {

    private TextView tv;
    private Button button;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textActivity);
        button = (Button) findViewById(R.id.buttonActivity);
        FragmentManager fm = getSupportFragmentManager();
        myFragment = (MyFragment) fm.findFragmentById(R.id.fragment_content);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFragment.clearEditText();
            }
        });
    }


    @Override
    public void setTextTop(String text) {
        tv.setText(text);
    }
}