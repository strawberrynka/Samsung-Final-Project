package com.example.samsungfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class CatAdapter extends ArrayAdapter<Cat> {

    public CatAdapter(Context context, List<Cat> cats) {
        super(context, 0, cats);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_cat, parent, false);
        }

        Cat cat = getItem(position);

        // Настройка данных кота в элементе списка
        TextView catNameTextView = convertView.findViewById(R.id.tv_cat_name);
        TextView catGenderTextView = convertView.findViewById(R.id.tv_cat_gender);
        ImageView catImageView = convertView.findViewById(R.id.iv_cat_image);

        catNameTextView.setText(cat.getName());
        catGenderTextView.setText(cat.getGender());

        String imagePath = cat.getImagePath();
        Picasso.get().load(new File(imagePath)).into(catImageView);

        return convertView;
    }
}
