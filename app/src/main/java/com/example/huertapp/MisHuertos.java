package com.example.huertapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.huertapp.databinding.ActivityMisHuertosBinding;

public class MisHuertos extends AppCompatActivity {

    ActivityMisHuertosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMisHuertosBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbarID);
    }

    @Override
    protected void onStart() {
        super.onStart();

        int[] foto = {R.drawable.huer1, R.drawable.huer4, R.drawable.huer5};
        String[] nombre = {"Huerto1", "Huerto2", "Huerto3"};

        Adaptador adaptador = new Adaptador(MisHuertos.this, foto, nombre);
        binding.listViewID.setAdapter(adaptador);

        binding.listViewID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion1, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt("posicion1", posicion1);
                Intent intent = new Intent(getApplicationContext(), MisPlantas.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.crearID: {
                Intent intent = new Intent(getApplicationContext(), CrearHuerto.class);
                startActivity(intent);
                break;
            }

            case R.id.perfilID: {
                Intent intent = new Intent(getApplicationContext(), Perfil.class);
                startActivity(intent);
                break;
            }

            case R.id.logOutID: {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
        }
        return true;
    }
}