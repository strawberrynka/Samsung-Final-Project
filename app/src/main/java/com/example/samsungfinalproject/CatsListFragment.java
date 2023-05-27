package com.example.samsungfinalproject;

// CatsListFragment.java

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CatsListFragment extends Fragment {

    private ListView listViewCats;
    private CatAdapter catAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cats_list, container, false);

        // список котов из базы данных
        List<Cat> cats = getCatList();

        // адаптер и ListView
        catAdapter = new CatAdapter(requireContext(), cats);
        listViewCats = view.findViewById(R.id.list_view_cats);
        listViewCats.setAdapter(catAdapter);

        return view;
    }

    // Метод для получения списка котов
    private List<Cat> getCatList() {
        List<Cat> cats = new ArrayList<>();

        return cats;
    }
}