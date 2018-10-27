package com.example.guia.ej_nivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoJugador extends AppCompatActivity {

    EditText txtJugador;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);
        txtJugador=findViewById(R.id.txtJugador);
        btnGuardar=findViewById(R.id.btnGuardar);
        setTitle("Nuevo jugador");

    }
    public void OnClickNuevo(View v){
        String jugador = txtJugador.getText().toString();
        Intent act = new Intent();
        act.putExtra("NOMBRE",jugador);
        setResult(MainActivity.JUGADORNUEVO, act);
        finish();
    }
}
