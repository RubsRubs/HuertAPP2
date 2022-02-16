package com.example.huertapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.huertapp.databinding.ActivityMisHuertosBinding;
import com.example.huertapp.databinding.ActivityPerfilBinding;
import com.example.huertapp.databinding.ActivityRegistroBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Perfil extends AppCompatActivity {

    ActivityPerfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPerfilBinding.inflate(getLayoutInflater());
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
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.misHuertosID: {
                Intent intent = new Intent(getApplicationContext(), MisHuertos.class);
                startActivity(intent);
                break;
            }


            case R.id.logOutID: {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Perfil.this, "Sesión finalizada", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
        }
        return true;
    }
}