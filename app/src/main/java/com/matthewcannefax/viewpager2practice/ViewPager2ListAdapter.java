package com.matthewcannefax.viewpager2practice;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ViewPager2ListAdapter extends ListAdapter<Image, ViewpagerImageViewHolder> {
    protected ViewPager2ListAdapter() {
        super(new ImageDiffCallback());
    }

    @NonNull
    @Override
    public ViewpagerImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewpagerImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewpagerImageViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public void onViewRecycled(@NonNull ViewpagerImageViewHolder holder) {
        Log.d("RECYCLED", "Something recycled");
    }
}
