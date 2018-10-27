package com.example.guia.ej_nivelacion;

public class Jugador {

    int id;
    String Nombre;
    int Victoria;
    int Derrota;
    int Empate;

    public Jugador(int id, String nombre, int victoria, int derrota, int empate) {
        this.id = id;
        Nombre = nombre;
        Victoria = victoria;
        Derrota = derrota;
        Empate = empate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getVictoria() {
        return Victoria;
    }

    public void setVictoria(int victoria) {
        Victoria = victoria;
    }

    public int getDerrota() {
        return Derrota;
    }

    public void setDerrota(int derrota) {
        Derrota = derrota;
    }

    public int getEmpate() {
        return Empate;
    }

    public void setEmpate(int empate) {
        Empate = empate;
    }
}
