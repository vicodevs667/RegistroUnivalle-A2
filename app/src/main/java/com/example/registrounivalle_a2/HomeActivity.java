package com.example.registrounivalle_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    //Atributos -> Vistas
    private TextView txtResultado;

    //Atributos -> variables para procesar.
    String nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        recibirDatosIntent();
        mostrarDatos();
    }

    private void mostrarDatos() {
        txtResultado.setText("Nombre: " + nombre + "\n"
        + " Apellido: " + apellido);
    }

    private void recibirDatosIntent() {
        nombre = this.getIntent().getExtras().getString("nombre_persona", "");
        apellido = this.getIntent().getExtras().getString("apellido_persona", "");

    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
    }
}