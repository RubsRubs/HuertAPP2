package com.example.huertapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.example.huertapp.databinding.ActivityDetallePlantaBinding;

public class DetallePlanta extends AppCompatActivity {

    ActivityDetallePlantaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetallePlantaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbarID);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_planta, menu);
        return super.onCreateOptionsMenu(menu);
    }
}