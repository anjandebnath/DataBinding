package com.example.user06.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user06.databinding.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        PersonVOField personVOField = new PersonVOField();
        personVOField.name.set("Elon Musk");
        personVOField.occupation.set("Entrepreneur, Engineer, Inventor, Investor");

        binding.setPersonField(personVOField);

        binding.change.setOnClickListener(v -> {
            personVOField.name.get();

        });

    }
}
