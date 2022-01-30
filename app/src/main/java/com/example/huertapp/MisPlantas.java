package com.example.huertapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.huertapp.databinding.ActivityMisPlantasBinding;

public class MisPlantas extends AppCompatActivity {

    ActivityMisPlantasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMisPlantasBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbarID);
    }

    @Override
    protected void onStart() {
        super.onStart();

        int[] foto = {R.drawable.huer6, R.drawable.huer7, R.drawable.huer8};
        String[] nombre = {"Planta1", "Planta2", "Planta3"};

        Adaptador adaptador = new Adaptador(MisPlantas.this, foto, nombre);
        binding.listViewID.setAdapter(adaptador);

        binding.listViewID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion2, long l) {

                Bundle bundle = getIntent().getExtras();
                bundle.putInt("posicion2", posicion2);
                Intent intent = new Intent(getApplicationContext(), DetallePlanta.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mis_plantas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            /*case R.id.anadirPlantaID: {

                break;
            }

            case R.id.borrarHuertoID: {

                break;
            }*/

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