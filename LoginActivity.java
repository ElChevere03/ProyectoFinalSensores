package com.example.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    //Declaracion de variables
    TextView bienvenidoLabel, continuarLabel;
    ImageView loginImageView;
    TextInputLayout usuarioTextField, contrasenaTextField;
    MaterialButton inicioSesion;
    String name="ian", contra="123";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginImageView = findViewById(R.id.loginImageView);
        bienvenidoLabel = findViewById(R.id.bienvenidoLabel);
        continuarLabel = findViewById(R.id.continuarLabel);
        usuarioTextField =  (TextInputLayout)findViewById(R.id.usuarioTextField);
        contrasenaTextField = ( TextInputLayout)findViewById(R.id.contrasenaTextField);
        inicioSesion = findViewById(R.id.inicioSesion);


        inicioSesion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, OptionsActivity.class);

                String usuario = usuarioTextField.getEditText().getText().toString().trim();
                String contraseña = contrasenaTextField.getEditText().getText().toString().trim();

                if(TextUtils.isEmpty(usuario)) {

                    usuarioTextField.setError("Usuario Incorrecto");
                }else if (TextUtils.isEmpty(contraseña)){

                    contrasenaTextField.setError("Contraseña Incorrecta");
                }else {
                    startActivity(intent);
                    finish();
                }




            }

        });
    }
}