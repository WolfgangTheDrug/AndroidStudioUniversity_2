package com.example.zad1_13;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    private EditText et;
    private Button button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        et = (EditText) view.findViewById(R.id.editTextFragment);
        button = (Button) view.findViewById(R.id.buttonFragment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ActivityActions) getActivity()).setTextTop(et.getText().toString());
            }
        });

        return view;
    }

    public void clearEditText(){
        et.setText("");
    }

    /////////////////////////////////////////////////////
    public interface ActivityActions {
        void setTextTop(String text);
    }

}

// piękna króciutka klasa! <3