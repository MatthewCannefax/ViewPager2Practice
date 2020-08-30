package com.matthewcannefax.viewpager2practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.matthewcannefax.viewpager2practice.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ViewPager2 viewPager2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        final List<Image> images = new ArrayList<>();
        images.add(new Image(1, getDrawable(R.drawable.ic_android_black_24dp)));
        images.add(new Image(2, getDrawable(R.drawable.ic_baseline_ac_unit_24)));
        images.add(new Image(3, getDrawable(R.drawable.ic_baseline_bathtub_24)));
        images.add(new Image(4, getDrawable(R.drawable.ic_baseline_atm_24)));

        final ViewPager2ListAdapter adapter = new ViewPager2ListAdapter();
        viewPager2 = findViewById(R.id.viewPager2);
        textView = findViewById(R.id.textview);
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.setAdapter(adapter);
        adapter.submitList(images);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                textView.setText(String.format("%s - %s", adapter.getCurrentList().get(position).getId(), images.size()));
                if (position == 0) {
                    images.add(0, images.get(images.size() - 1));
                    images.remove(images.get(images.size() -1));
                    adapter.submitList(new ArrayList<>(images));
                } else  if (position == adapter.getItemCount() - 1) {
                    images.add(images.size(), images.get(0));
                    images.remove(0);
                    adapter.submitList(new ArrayList<>(images));
                }
            }
        });

    }
}