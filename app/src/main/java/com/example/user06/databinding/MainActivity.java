package com.example.user06.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user06.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
       /* binding.textView.setText("Entrepreneur, Engineer, Inventor, Investor");
        binding.textView2.setText("Elon mask");*/
        PersonVO personVO = new PersonVO("Elon Musk", "Entrepreneur, Engineer, Inventor, Investor");

        // this will be the name according to variable name in the xml layout
        binding.setPerson(personVO);

        binding.change.setOnClickListener(v -> {
              personVO.setName("Steve Jobs");
              personVO.setOccupation("CEO of Apple");
        });

    }
}
