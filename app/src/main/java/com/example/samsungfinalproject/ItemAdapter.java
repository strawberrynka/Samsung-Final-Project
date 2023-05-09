//package com.example.samsungfinalproject;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
//
//    private List<Item> itemList;
//
//    public ItemAdapter(List<Item> itemList) {
//        this.itemList = itemList;
//    }
//
//    @NonNull
//    @Override
//    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_shop, parent, false);
//        return new ItemViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
//        Item item = itemList.get(position);
//        holder.nameTextView.setText(item.getName());
//        holder.priceTextView.setText(String.valueOf(item.getPrice()));
//        holder.typeTextView.setText(item.getType());
//        holder.buyButton.setOnClickListener(v -> {
//            //TODO: Действия по нажатию на кнопку buy
//        });
//        holder.imageView.setImageResource(item.getImageResource());
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemList.size();
//    }
//
//    public static class ItemViewHolder extends RecyclerView.ViewHolder {
//
//        TextView nameTextView, priceTextView, typeTextView;
//        ImageView imageView;
//        Button buyButton;
//
//        public ItemViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTextView = itemView.findViewById(R.id.nameTextView);
//            priceTextView = itemView.findViewById(R.id.priceTextView);
//            typeTextView = itemView.findViewById(R.id.typeTextView);
//            imageView = itemView.findViewById(R.id.imageView);
//            buyButton = itemView.findViewById(R.id.buyButton);
//        }
//    }
//}
