package com.example.huertapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.huertapp.databinding.ActivityDetallePlantaBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;

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

        Date fecha = new Date();

        String[] accion = {"Riego", "Poda", "Recolecta"};
        String[] observacion = {"Como le gusta que la riegen", "Se han encontrado bichos", "Muchos tomates esta vez"};
        String[] fechaArray = {fecha.toString(), fecha.toString(), fecha.toString()};

        AdaptadorDetallePlanta adaptador = new AdaptadorDetallePlanta(DetallePlanta.this, accion, observacion, fechaArray);
        binding.listViewID.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_planta, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.riegoID: {
                Intent intent = new Intent(getApplicationContext(), Riego.class);
                startActivity(intent);
                break;
            }

            case R.id.podaID: {
                Intent intent = new Intent(getApplicationContext(), Poda.class);
                startActivity(intent);
                break;
            }

            case R.id.abonoID: {
                Intent intent = new Intent(getApplicationContext(), Abono.class);
                startActivity(intent);
                break;
            }

            case R.id.fumigacionID: {
                Intent intent = new Intent(getApplicationContext(), Fumigacion.class);
                startActivity(intent);
                break;
            }

            case R.id.anadirRecolectaID: {
                Intent intent = new Intent(getApplicationContext(), Recolecta.class);
                startActivity(intent);
                break;
            }

            /*case R.id.borrarPlantaID: {
                Intent intent = new Intent(getApplicationContext(), CrearHuerto.class);
                startActivity(intent);
                break;
            }*/

            case R.id.perfilID: {
                Intent intent = new Intent(getApplicationContext(), Perfil.class);
                startActivity(intent);
                break;
            }

            case R.id.logOutID: {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(DetallePlanta.this, "Sesión finalizada", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
        }
        return true;
    }
}