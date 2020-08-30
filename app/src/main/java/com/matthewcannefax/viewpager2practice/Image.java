package com.matthewcannefax.viewpager2practice;

import android.graphics.drawable.Drawable;

import java.util.Objects;

public class Image {
    private Drawable drawable;
    private int id;

    public Image(int id, Drawable drawable) {
        this.id = id;
        this.drawable = drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id == image.id &&
                Objects.equals(drawable, image.drawable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drawable, id);
    }
}
