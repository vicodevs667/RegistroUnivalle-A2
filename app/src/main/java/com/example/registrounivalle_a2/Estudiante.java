package com.example.registrounivalle_a2;

//Clase POJO plain old java object
public class Estudiante {
    private int codigoEstudiante;
    private String nombre;
    private String apellido;
    private String email;
    private int celular;

    public Estudiante(String nombre, String apellido, String email, int celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public int getCelular() {
        return celular;
    }
}
