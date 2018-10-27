package com.example.guia.ej_nivelacion;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class IniciarJuego extends AppCompatActivity implements View.OnClickListener {
    private TextView txtJugador;
    String nombre;
    Button btnPiedra,btnPapel, btnTijera, btnTerminar, btnRandom;
    TextView lblPuntos, lblGanados,lblPerdidos,lblEmpatados;
    int puntosJugador=0;
    int valorJugador=0, valorCPU=0, ganados=0, perdidos=0, empatados=0,id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_juego);
        txtJugador = findViewById(R.id.lblJugador);
        btnPiedra = findViewById(R.id.btnPiedra);
        btnPapel = findViewById(R.id.btnPapel);
        btnTijera = findViewById(R.id.btnTijera);
        btnRandom = findViewById(R.id.btnRandom);
        btnTerminar = findViewById(R.id.btnTerminar);
        lblPuntos = findViewById(R.id.lblPuntos);
        lblGanados=findViewById(R.id.lblGanados);
        lblPerdidos=findViewById(R.id.lblPerdidos);
        lblEmpatados=findViewById(R.id.lblEmpatados);
        setTitle("Piedra, Papel o Tijera");
        btnPiedra.setOnClickListener(this);
        btnPapel.setOnClickListener(this);
        btnTijera.setOnClickListener(this);
        btnRandom.setOnClickListener(this);
        btnTerminar.setOnClickListener(this);

        nombre = getIntent().getStringExtra("NOMBRE");
        ganados = getIntent().getIntExtra("GANADOS",0);
        perdidos = getIntent().getIntExtra("PERDIDOS",0);
        empatados = getIntent().getIntExtra("EMPATADOS",0);
        id = getIntent().getIntExtra("ID",0);

        txtJugador.setText(nombre);
        lblGanados.setText(ganados+"");
        lblPerdidos.setText(perdidos+"");
        lblEmpatados.setText(empatados+"");

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPiedra:
                valorJugador = 1;//PIEDRA
                Toast.makeText(this, "Piedra"+valorJugador, Toast.LENGTH_SHORT).show();
                btnRandom.setEnabled(true);
                btnPiedra.setEnabled(false);
                btnPapel.setEnabled(false);
                btnTijera.setEnabled(false);
                if(valorCPU==1){
                    empatados++;
                }else{
                    if(valorCPU==2){
                        perdidos++;
                        puntosJugador-=3;
                    }else{
                        ganados++;
                        puntosJugador+=6;
                    }
                }
                lblGanados.setText(ganados+"");
                lblPerdidos.setText(perdidos+"");
                lblEmpatados.setText(empatados+"");
                lblPuntos.setText(puntosJugador+"");

                break;
            case R.id.btnPapel:
                valorJugador = 2;//PAPEL
                Toast.makeText(this, "Papel"+valorJugador, Toast.LENGTH_SHORT).show();
                btnRandom.setEnabled(true);
                btnPiedra.setEnabled(false);
                btnPapel.setEnabled(false);
                btnTijera.setEnabled(false);
                if(valorCPU==2){
                    empatados++;
                }else{
                    if(valorCPU==1){
                        ganados++;
                        puntosJugador+=6;
                    }else{
                        perdidos++;
                        puntosJugador-=3;
                    }
                }
                lblGanados.setText(ganados+"");
                lblPerdidos.setText(perdidos+"");
                lblEmpatados.setText(empatados+"");
                lblPuntos.setText(puntosJugador+"");
                break;
            case R.id.btnTijera:
                valorJugador = 3;//TIJERA
                Toast.makeText(this, "Tijera"+valorJugador, Toast.LENGTH_SHORT).show();
                btnRandom.setEnabled(true);
                btnPiedra.setEnabled(false);
                btnPapel.setEnabled(false);
                btnTijera.setEnabled(false);
                if(valorCPU==3){
                    empatados++;
                }else{
                    if(valorCPU==1){
                        perdidos++;
                        puntosJugador-=3;
                    }else{
                        ganados++;
                        puntosJugador+=6;
                    }
                }
                lblGanados.setText(ganados+"");
                lblPerdidos.setText(perdidos+"");
                lblEmpatados.setText(empatados+"");
                lblPuntos.setText(puntosJugador+"");

                break;
            case R.id.btnRandom:
                valorCPU = (int) (Math.random() * 3) + 1;
               /* if(valorCPU==1){
                    Toast.makeText(this, "Piedra", Toast.LENGTH_SHORT).show();
                }else{
                    if(valorCPU==2){
                        Toast.makeText(this, "Papel", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Tijera", Toast.LENGTH_SHORT).show();
                    }
                }*/
                btnRandom.setEnabled(false);
                btnPiedra.setEnabled(true);
                btnPapel.setEnabled(true);
                btnTijera.setEnabled(true);
                break;
            case R.id.btnTerminar:
                Intent act = new Intent();
                act.putExtra("NOMBRE",nombre);
                act.putExtra("VICTORIAS",ganados);
                act.putExtra("DERROTAS",perdidos);
                act.putExtra("EMPATES",empatados);
                act.putExtra("ID",id);
                setResult(Lista.PUNTAJES, act);
                finish();
                break;
        }
    }

}
