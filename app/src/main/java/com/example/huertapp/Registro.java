package com.example.huertapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Patterns;
import android.view.View;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.huertapp.databinding.ActivityRegistroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Registro extends AppCompatActivity {

    ActivityRegistroBinding binding;
    FirebaseAuth firebaseAuth;
    AwesomeValidation awesomeValidation;
    String emailError = "Por favor, ingrese un email válido";
    String passwError = "Su contraseña tiene que tener al menos 6 caracteres";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        firebaseAuth = FirebaseAuth.getInstance();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC); //utilizamos la versión básica de AwesomeValidation
        awesomeValidation.addValidation(binding.editEmailID, Patterns.EMAIL_ADDRESS, emailError); //si no se mete una dirección de correo salta el error
        awesomeValidation.addValidation(binding.editPassw1ID, ".{6,}", passwError); //si la contraseña no tiene al menos 6 caracteres salta el error
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.btnRegisID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (awesomeValidation.validate() && coincidenPassw() && !validarCampos()) { //si email y password tienen el formato correcto y las dos contraseñas coinciden y el campoUser esta rellenado

                    firebaseAuth.createUserWithEmailAndPassword(binding.editEmailID.getText().toString(), binding.editPassw1ID.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Snackbar.make(view, "Usuario creado con éxito", Snackbar.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MisHuertos.class);
                                startActivity(intent);
                                finish();

                            } else {
                                String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                                errorToast(errorCode); // en caso de que hubiese algún otro tipo de error incluso después de haber introducido todos los campos correctamente
                            }
                        }
                    });

                } else if (!coincidenPassw()) {
                    Snackbar.make(view, "Las contraseñas no coinciden", Snackbar.LENGTH_LONG).show();
                } else if (validarCampos()) {
                    Snackbar.make(view, "Rellene todos los campos", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    private void errorToast(String error) {
    }

    public boolean coincidenPassw() {
        return (binding.editPassw1ID.getText().toString().equals(binding.editPassw2ID.getText().toString()));
    }

    public boolean validarCampos() {
        return (binding.editUserID.getText().toString().isEmpty());
    }
}