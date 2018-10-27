package com.example.guia.ej_nivelacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorJugador extends ArrayAdapter<Jugador> {
    public AdaptadorJugador(@NonNull Context context, List<Jugador> object) {
        super(context, 0,object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Jugador jugador = getItem(position);
        if(convertView==null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_jugador,parent,false);
        }

        TextView lblcontador = convertView.findViewById(R.id.lblContador);
        TextView lblnombre = convertView.findViewById(R.id.lblNombre);
        TextView lblVictoria = convertView.findViewById(R.id.lblVictoria);
        TextView lblEmpate = convertView.findViewById(R.id.lblEmpate);
        TextView lblDerrota = convertView.findViewById(R.id.lblDerrota);
        lblcontador.setText(String.valueOf(position+1));
        lblnombre.setText(jugador.getNombre());
        lblVictoria.setText("Victorias: "+String.valueOf(jugador.getVictoria()));
        lblEmpate.setText("Empates: "+String.valueOf(jugador.getEmpate()));
        lblDerrota.setText("Derrotas:  "+String.valueOf(jugador.getDerrota()));
        return convertView;
    }
}
