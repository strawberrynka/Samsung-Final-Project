//package com.example.samsungfinalproject;
//
//import android.content.ClipData;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class ShopFragment extends Fragment {
//
//    public ShopFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_shop, container, false);
//
//        // Настройка RecyclerView
//        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
//        ArrayList<ClipData.Item> items = new ArrayList<>();
//        items.add(new Item("Миска", 50, R.drawable.bowl, Item.TYPE_BOWL));
//        items.add(new Item("Декор", 300, R.drawable.decor, Item.TYPE_DECOR));
//        items.add(new Item("Лоток", 150, R.drawable.litter_box, Item.TYPE_LITTER_BOX));
//        items.add(new Item("Поилка", 100, R.drawable.water_bowl, Item.TYPE_WATER_BOWL));
//        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        return view;
//    }
//}
