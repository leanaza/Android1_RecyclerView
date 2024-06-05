package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;
    List<Item> filteredItems;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
        this.filteredItems = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(filteredItems.get(position).getName());
        holder.emailView.setText(filteredItems.get(position).getdes());
        holder.imageView.setImageResource(filteredItems.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return filteredItems.size();
    }

    public void filter(String query) {
        filteredItems.clear();
        if (query.isEmpty()) {
            filteredItems.addAll(items);
        } else {
            String filterPattern = query.toLowerCase().trim();
            for (Item item : items) {
                if (item.getName().toLowerCase().contains(filterPattern)) {
                    filteredItems.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
