package com.example.user06.databinding.recycler.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.user06.databinding.R;
import com.example.user06.databinding.databinding.ActivityRecyclerBinding;
import com.example.user06.databinding.recycler.adapter.PostsAdapter;
import com.example.user06.databinding.recycler.model.Post;
import com.example.user06.databinding.recycler.model.User;

public class RecyclerActivity extends AppCompatActivity implements PostsAdapter.PostsAdapterListener {

    ActivityRecyclerBinding activityRecyclerBinding;
    private User user;
    CustomClickHandlers clickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        Toolbar toolbar = activityRecyclerBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        renderProfile();
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


    }

    @Override
    public void onPostClicked(Post post) {

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
}
