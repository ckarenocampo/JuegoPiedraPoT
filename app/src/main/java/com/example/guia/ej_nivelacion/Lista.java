package com.example.guia.ej_nivelacion;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista extends AppCompatActivity {

    public static int PUNTAJES=1;
    ListView listView;
    private ArrayAdapter adapter;
    Boolean Listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        adapter = new AdaptadorJugador(Lista.this,MainActivity.listaJugadores);
        listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setTitle("Lista de jugadores");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String jugador = MainActivity.listaJugadores.get(position).getNombre();
                int ganados = MainActivity.listaJugadores.get(position).getVictoria();
                int perdidos = MainActivity.listaJugadores.get(position).getDerrota();
                int empatados = MainActivity.listaJugadores.get(position).getEmpate();
                int id = MainActivity.listaJugadores.get(position).getId();

                Intent intent = new Intent(Lista.this,IniciarJuego.class);
                intent.putExtra("NOMBRE",jugador);
                intent.putExtra("GANADOS",ganados);
                intent.putExtra("PERDIDOS",perdidos);
                intent.putExtra("EMPATADOS",empatados);
                intent.putExtra("ID",id);
                startActivityForResult(intent, PUNTAJES);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PUNTAJES){
            if(data==null)return;
            String nombre = data.getExtras().getString("NOMBRE");
            int vic = data.getIntExtra("VICTORIAS",0);
            int der = data.getIntExtra("DERROTAS",0);
            int emp = data.getIntExtra("EMPATES",0);
            int id = data.getIntExtra("ID",0);

            Jugador jug = new Jugador(id,nombre,vic,der,emp);
            MainActivity.listaJugadores.add(jug);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

}
