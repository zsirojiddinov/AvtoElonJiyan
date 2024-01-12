package com.example.avtoelon.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avtoelon.R;
import com.example.avtoelon.listener.OnProductItemClickListener;
import com.example.avtoelon.model.AutoCar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyVH> {
    List<AutoCar> list;
    OnProductItemClickListener listener;

    public RvAdapter(List<AutoCar> list, OnProductItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.price.setText(((int) list.get(position).getPrice()) + " $");
        holder.address.setText(list.get(position).getRegion());
        holder.yili.setText(list.get(position).getYear());
        holder.odometer.setText(String.valueOf(list.get(position).getOdometer()));
        holder.date.setText(list.get(position).getPublishedDate());
        holder.showCount.setText(String.valueOf(list.get(position).getShow_count()));
        Picasso.get().load(list.get(position).getImageList()).into(holder.image);
        holder.itemView.setOnClickListener(view -> listener.onItemClick(list.get(position), position));

        holder.delete.setOnClickListener(v -> listener.onItemDelete(list.get(position), position));
        holder.like.setOnClickListener(v -> listener.onChangeLike(list.get(position), position));
        if (list.get(position).isLike()) {
            holder.like.setBackgroundResource(R.drawable.ic_like_true);
        } else holder.like.setBackgroundResource(R.drawable.ic_like_false);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView yili;
        TextView odometer;
        TextView address;
        TextView date;
        TextView showCount;
        ImageView image;
        ImageView delete;
        ImageView like;


        public MyVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.carName);
            price = itemView.findViewById(R.id.price);
            yili = itemView.findViewById(R.id.yili);
            odometer = itemView.findViewById(R.id.odometer);
            address = itemView.findViewById(R.id.address);
            date = itemView.findViewById(R.id.date);
            showCount = itemView.findViewById(R.id.showCount);
            image = itemView.findViewById(R.id.image);
            delete = itemView.findViewById(R.id.deleteIcon);
            like = itemView.findViewById(R.id.saveIcon);
        }
    }

}
