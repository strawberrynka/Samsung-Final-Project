package com.example.samsungfinalproject;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {


    public Cat cat;
    public Player player;


    private void updateCoinCount(MyDatabaseHelper dbHelper, SQLiteDatabase db) {

        int coinCount = dbHelper.getCoinCount();
        // Обновите текстовое поле или элемент интерфейса пользователя с количеством монет
        TextView coinsView = findViewById(R.id.coins_text_view);
        coinsView.setText(String.valueOf(coinCount));
    }


    // Метод для конвертации dp в пиксели
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создание объекта Context
        Context context = getApplicationContext();

        // Создаем намерение для запуска MusicService
        Intent intent = new Intent(this, MusicService.class);
        intent.setAction(MusicService.ACTION_PLAY);
        startService(intent);

        player = new Player(context);
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(this, player);
        SQLiteDatabase db = dbHelper.getWritableDatabase();



//        TextView coinsView = findViewById(R.id.coins_text_view);


//        coinsView.setBackgroundResource(R.drawable.coins);
        updateCoinCount(dbHelper, db);
//        coinsView.setText(coinCount); // устанавливает количество монет равным 100

        //TextView textViewOwnedCatCount = findViewById(R.id.textViewOwnedCatCount);
        //textViewOwnedCatCount.setText(String.valueOf(ownedCatCount));

        ImageButton catsButton = findViewById(R.id.cats_button);

        ImageButton pettingButton = findViewById(R.id.petting_button);

// Назначение обработчика щелчка кнопки
        pettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Воспроизведение звука при нажатии
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.meow);
                mediaPlayer.start();
            }
        });

        catsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatsListFragment fragment = new CatsListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.list_view_cats, fragment);
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


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
