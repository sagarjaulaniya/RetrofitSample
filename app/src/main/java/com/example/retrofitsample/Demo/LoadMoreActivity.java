package com.example.retrofitsample.Demo;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.example.retrofitsample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadMoreActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    List<String> itemArrayList = new ArrayList<>();
    boolean isScrolling = false;
    int currentItem, totalItem, scrollOutItem;
    LinearLayoutManager layoutManager;
    RecyclerViewloadingAdapter loadingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more);
        recyclerView = findViewById(R.id.rvload);
        progressBar = findViewById(R.id.progress_circular);

        int i = 1;
        while (i < 20) {
            itemArrayList.add("Item " + i);
            i++;
        }

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadingAdapter = new RecyclerViewloadingAdapter(this, itemArrayList);
        recyclerView.setAdapter(loadingAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItem = layoutManager.getChildCount();
                totalItem = layoutManager.getItemCount();
                scrollOutItem = layoutManager.findFirstVisibleItemPosition();
                if (isScrolling && (currentItem + scrollOutItem == totalItem)) {
                    isScrolling = false;
                    fetchData();
                }
            }
        });
    }

    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    itemArrayList.add("Item " + Math.floor(Math.random() * 100));
                    loadingAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 1500);
    }
}
