//package com.example.samsungfinalproject;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.ViewHolder> {
//    private ArrayList<Cat> mCats;
//
//    public CatsAdapter(ArrayList<Cat> cats) {
//        mCats = cats;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater = LayoutInflater.from(context);
//
//        // Inflate the custom layout
//        View catView = inflater.inflate(R.layout.item_cat, parent, false);
//
//        // Return a new holder instance
//        ViewHolder viewHolder = new ViewHolder(catView);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        // Get the data model based on position
//        Cat cat = mCats.get(position);
//
//        // Set item views based on your views and data model
//        TextView nameTextView = holder.nameTextView;
//        nameTextView.setText(cat.getName());
//        ImageView catImageView = holder.catImageView;
//        catImageView.setImageResource(cat.getImageResource());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mCats.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView nameTextView;
//        public ImageView catImageView;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            nameTextView = (TextView) itemView.findViewById(R.id.tv_cat_name);
//            catImageView = (ImageView) itemView.findViewById(R.id.iv_cat_image);
//        }
//    }
//}
