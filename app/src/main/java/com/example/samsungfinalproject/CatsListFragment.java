//package com.example.samsungfinalproject;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class CatsListFragment extends Fragment {
//
//    public CatsListFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_cats_list, container, false);
//
//        // Настройка RecyclerView
//        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
//        ArrayList<String> cats = new ArrayList<>();
//        cats.add("Кот Мурзик");
//        cats.add("Кот Барсик");
//        cats.add("Кот Васька");
//        CatsAdapter adapter = new CatsAdapter(getActivity(), cats);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        return view;
//    }
//
//}
