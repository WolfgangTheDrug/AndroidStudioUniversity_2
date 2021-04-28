package com.example.zad1_16;

import androidx.appcompat.app.AppCompatActivity;
        import androidx.drawerlayout.widget.DrawerLayout;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] strsMenu = new String[]{"Oferta", "Koszyk", "Wiadomości"};
    private Fragment[] tabFr;
    private String colors[] = {"#FFFFFF", "#111111", "#123456"}; //do poprawy, dodać losowe generowanie kolorów!
    //losowanie liczby 16-tkowej, konwersja na stringa

    public String getRandomColor() {
        int number = 0;
        String hexValue = "", color = "#";

        for (int i = 0; i < 3; i++) {
            number = (int) ( Math.random() * Math.pow(16, 2) );
            hexValue = Integer.toHexString(number);
            color += hexValue.length() == 1 ? "0" + hexValue : hexValue;
        }
        return color;
    }

    private String invertHexColor(String hexColor) {
        char[] hexChar = hexColor.substring(1).toCharArray(); // array sześciu cyfr heksadecymalnych
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(String.valueOf(hexChar[2*i]), 16); // wyciąnij co drugą cyfrę
            value = 0xF - value; // odwróć tę cyfrę względem bazy?
            hexChar[2*i] = (Integer.toHexString(value)).charAt(0); // zamień starą cyfrę na nową
        } // nadal mam sześć cyfr
        return  "#" + new String(hexChar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        listView = findViewById(R.id.left_drawer);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_list, strsMenu);

        MyFragment offer = new MyFragment(getRandomColor(), "Oto nasza oferta!");
        MyFragment2 cart = new MyFragment2(getRandomColor(), "Nic nie znajduje się w koszyku");
        MyFragment3 messages = new MyFragment3(getRandomColor(), "Brak wiadomości do wyświetlenia");

        tabFr = new Fragment[strsMenu.length];
        tabFr[0] = offer;
        tabFr[1] = cart;
        tabFr[2] = messages;

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.content_frame, tabFr[position])
                        .commit();
                drawerLayout.closeDrawers();
            }
        });


    }
}