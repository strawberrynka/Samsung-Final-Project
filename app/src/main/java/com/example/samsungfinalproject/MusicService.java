package com.example.samsungfinalproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {

    public static final String ACTION_PLAY = "com.example.samsungfinalproject.ACTION_PLAY";
    public static final String ACTION_PAUSE = "com.example.samsungfinalproject.ACTION_PAUSE";


    private MediaPlayer mediaPlayer;

    private boolean isMusicPlaying = false;


    @Override
    public void onCreate() {
        super.onCreate();
        // Создаем и настраиваем MediaPlayer для воспроизведения музыки
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true); // Включаем зацикливание музыки
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        if (action != null) {
            if (action.equals(ACTION_PLAY) && !isMusicPlaying) {
                // Запуск воспроизведения
                mediaPlayer.start();
                isMusicPlaying = true;
            } else if (action.equals(ACTION_PAUSE) && isMusicPlaying) {
                // Пауза воспроизведения
                mediaPlayer.pause();
                isMusicPlaying = false;
            }
        }
        return START_STICKY;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        // Освобождаем ресурсы MediaPlayer при уничтожении сервиса
        mediaPlayer.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Метод не используется, возвращаем null
        return null;
    }
}