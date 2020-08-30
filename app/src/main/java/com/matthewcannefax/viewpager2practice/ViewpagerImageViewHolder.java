package com.matthewcannefax.viewpager2practice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewpagerImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public ViewpagerImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
    }

    public void bind(Image image) {
        imageView.setImageDrawable(image.getDrawable());
    }

    public void unbindListeners() {
    }
}
