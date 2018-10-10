package com.example.user06.databinding.recycler.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.user06.databinding.R;
import com.example.user06.databinding.databinding.ActivityRecyclerBinding;
import com.example.user06.databinding.recycler.adapter.PostsAdapter;
import com.example.user06.databinding.recycler.model.Post;

public class RecyclerActivity extends AppCompatActivity implements PostsAdapter.PostsAdapterListener {

    ActivityRecyclerBinding activityRecyclerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        Toolbar toolbar = activityRecyclerBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public void onPostClicked(Post post) {

    }
}
