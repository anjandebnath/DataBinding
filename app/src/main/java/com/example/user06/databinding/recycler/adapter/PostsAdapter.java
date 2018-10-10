package com.example.user06.databinding.recycler.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user06.databinding.R;
import com.example.user06.databinding.databinding.PostRowItemBinding;
import com.example.user06.databinding.recycler.model.Post;

import java.util.List;

/**
 * Created by Anjan Debnath on 10/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder>{


    private List<Post> postList;
    private LayoutInflater layoutInflater;
    private PostsAdapterListener listener;

    public interface PostsAdapterListener {
        void onPostClicked(Post post);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        PostRowItemBinding binding;

        public MyViewHolder(PostRowItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        /*public MyViewHolder(View itemView) {
            super(itemView);
        }*/
    }

    public PostsAdapter(List<Post> postList, PostsAdapterListener listener){
        this.postList = postList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        PostRowItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.binding.setPost(postList.get(position));
        holder.binding.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPostClicked(postList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
