package com.example.samsungfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public Cat cat;
    public Player player;


    private void updateCoinCount(MyDatabaseHelper dbHelper, SQLiteDatabase db) {

        int coinCount = dbHelper.getCoinCount();
        // Обновите текстовое поле или элемент интерфейса пользователя с количеством монет
        TextView coinsView = findViewById(R.id.coins_text_view);
        coinsView.setText(String.valueOf(coinCount));
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создание объекта Context
        Context context = getApplicationContext();

        player = new Player(context);
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        int ownedCatCount = player.getOwnedCatCount();



//        TextView coinsView = findViewById(R.id.coins_text_view);


//        coinsView.setBackgroundResource(R.drawable.coins);
        updateCoinCount(dbHelper, db);
//        coinsView.setText(coinCount); // устанавливает количество монет равным 100

        TextView textViewOwnedCatCount = findViewById(R.id.textViewOwnedCatCount);
        textViewOwnedCatCount.setText(String.valueOf(ownedCatCount));

        ImageButton catsButton = findViewById(R.id.cats_button);

        catsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatsListFragment fragment = new CatsListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_cats_list, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        ImageButton settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(v -> {
            SettingsFragment fragment = new SettingsFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.settings_layout, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });


        //dbHelper.addCat("Whiskers", "Male", "tile000.png");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}














