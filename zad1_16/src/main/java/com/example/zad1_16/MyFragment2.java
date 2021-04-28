package com.example.zad1_16;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment2 extends Fragment {
    private TextView tv;
    private String color;
    private String text;

    private Button pay;
    private Button back;
    private Button delete;
    public static final String COLOR = "color";
    public static final String TEXT = "text";


    MyFragment2(String color, String text){
        this.color = color;
        this.text = text;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2_content, container, false);
        String[] items = {"item1", "item2", "item3", "item4", "item5", "item6"};

        ListView listView = (ListView) view.findViewById(R.id.listView1);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_element,
                items
        );

        listView.setAdapter(listViewAdapter);

        pay = (Button) view.findViewById(R.id.button);
        back = (Button) view.findViewById(R.id.button2);
        delete = (Button) view.findViewById(R.id.button3);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(), "Przekierowanie do kasy...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(), "Wracanie...", Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(), "Usunięto przedmioty z koszyka.", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
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
