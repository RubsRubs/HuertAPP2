package com.example.huertapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.huertapp.databinding.ActivityRegistroBinding;

public class Registro extends AppCompatActivity {

    ActivityRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.btnRegisID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MisHuertos.class);
                startActivity(intent);
            }
        });
    }
}