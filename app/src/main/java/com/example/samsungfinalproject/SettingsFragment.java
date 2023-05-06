package com.example.samsungfinalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

public class SettingsFragment extends Fragment {

    private Switch musicSwitch, soundSwitch;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Находим переключатели в макете
        musicSwitch = view.findViewById(R.id.music_switch);
        soundSwitch = view.findViewById(R.id.sound_switch);

        return view;
    }
}
