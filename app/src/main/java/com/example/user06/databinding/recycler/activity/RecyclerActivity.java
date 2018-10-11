package com.example.user06.databinding.recycler.activity;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import com.example.user06.databinding.R;
import com.example.user06.databinding.databinding.ActivityRecyclerBinding;
import com.example.user06.databinding.recycler.adapter.PostsAdapter;
import com.example.user06.databinding.recycler.model.Post;
import com.example.user06.databinding.recycler.model.User;
import com.example.user06.databinding.recycler.utils.GridSpacingItemDecoration;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements PostsAdapter.PostsAdapterListener {

    private ActivityRecyclerBinding activityRecyclerBinding;
    private User user;
    private CustomClickHandlers clickHandlers;
    private PostsAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        Toolbar toolbar = activityRecyclerBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clickHandlers = new CustomClickHandlers(this);

        initRecyclerView();

        renderProfile();
    }

    @Override
    public void onPostClicked(Post post) {

    }

    private void initRecyclerView() {
        recyclerView = activityRecyclerBinding.content.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        mAdapter = new PostsAdapter(getPosts(), this);
        recyclerView.setAdapter(mAdapter);
    }


    private void renderProfile(){

        user = new User();
        user.setName("David Attenborough");
        user.setEmail("david@natgeo.com");
        user.setProfileImage("https://api.androidhive.info/images/nature/david.jpg");
        user.setAbout("Naturalist");

        // ObservableField doesn't have setter method, instead will
        // be called using set() method
        user.numberOfPosts.set(3400L);
        user.numberOfFollowers.set(3050890L);
        user.numberOfFollowing.set(150L);


        // display user
        activityRecyclerBinding.setUser(user);

        activityRecyclerBinding.setHandler(clickHandlers);


    }

    private ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Post post = new Post();
            post.setImageUrl("https://api.androidhive.info/images/nature/" + i + ".jpg");

            posts.add(post);
        }

        return posts;
    }



    public class CustomClickHandlers{

        Context mContext;

        public CustomClickHandlers(Context context){
            mContext = context;
        }

        public void onProfileInfoFabClicked(View view){

            user.setName("Sir David Attenborough");
            user.setProfileImage("https://api.androidhive.info/images/nature/david1.jpg");

            // updating ObservableField
            user.numberOfPosts.set(5500L);
            user.numberOfFollowers.set(5050890L);
            user.numberOfFollowing.set(180L);

        }

    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
