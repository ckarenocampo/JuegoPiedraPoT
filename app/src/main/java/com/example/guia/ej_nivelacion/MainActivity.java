package com.example.guia.ej_nivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static int JUGADORNUEVO=1;
    Button btnNuevo,btnJugar,btnPuntaje;
    public static ArrayList<Jugador> listaJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnJugar = findViewById(R.id.btnJugar);
        btnPuntaje = findViewById(R.id.btnPuntajes);
        listaJugadores=new ArrayList<>();
        setTitle("Piedra, Papel o Tijera");


    }

    public void OnClickNuevo(View v){
        Intent intent = new Intent(MainActivity.this,NuevoJugador.class);
        startActivityForResult(intent,JUGADORNUEVO);
    }
    public void OnClickJugar(View v){
        Intent intent = new Intent(MainActivity.this,Lista.class);
        startActivity(intent);
    }
    public void OnClickPuntos(View v){
        Intent intent = new Intent(MainActivity.this,Lista.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==JUGADORNUEVO){
                if(data==null)return;
                String nombre = data.getExtras().getString("NOMBRE");
                Jugador jug = new Jugador(listaJugadores.size()+1,nombre,0,0,0);
                listaJugadores.add(jug);
        }
    }
}
