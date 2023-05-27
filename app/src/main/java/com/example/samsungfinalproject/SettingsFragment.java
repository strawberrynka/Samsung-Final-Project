package com.example.samsungfinalproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private Switch musicSwitch, soundSwitch;

    private MediaPlayer mediaPlayer;

    public SettingsFragment() {
        // нужен пустой public конструктор
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, null);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.music);
        mediaPlayer.setLooping(true);

        ImageButton buttonDone = view.findViewById(R.id.button_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        musicSwitch = view.findViewById(R.id.music_switch);
        soundSwitch = view.findViewById(R.id.sound_switch);

        musicSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    mediaPlayer.start();
                } else {

                    mediaPlayer.pause();
                }
            }
        });

        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();


        stopMusic();
    }

    private void stopMusic() {
        // Остановка музыки
        Intent intent = new Intent(getActivity(), MusicService.class);
        getActivity().stopService(intent);
    }

}
