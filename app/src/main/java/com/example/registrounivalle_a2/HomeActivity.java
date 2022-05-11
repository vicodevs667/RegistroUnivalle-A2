package com.example.registrounivalle_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    //Atributos -> Vistas
    private TextView txtResultado;
    private Button btnCalcular;
    private Spinner spOpciones;

    //Atributos -> variables para procesar.
    String nombre, apellido;
    //Estructura que contenga toda la lista obtenida
    //de una fuente de datos.
    ArrayList<String> opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        recibirDatosIntent();
        mostrarDatos();
        //Configurar el Spinner
        popularSpinner();
        btnCalcular.setOnClickListener(view -> {
            obtenerDatosSpinner();
        });
    }

    private void obtenerDatosSpinner() {
        //1 Pueden obtener el valor del item o elemento seleccionado
        String valor = spOpciones.getSelectedItem().toString();
        //2 Pueden obtener el indice o quizas la posicion del item o elemento seleccionado
        int posicion = spOpciones.getSelectedItemPosition();
        switch (valor) {
            case "Notas":
                break;
        }
        switch (posicion){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void popularSpinner() {
        cargarListaOpciones();
        /*
        Ustedes necesitan un Adaptador que es un
        elemento que transforma datos en vistas
        para cargar cada una de sus opciones de la
        estructura de datos en su componente spinner
        El ArrayAdapter es el transformador mas simple que
        existe en Android por defecto y cuando se crea una
        instancia de este componente se deben considerar 3 parametros:
        1: Contexto de la pantalla donde se va a dibujar el elemento visual
        2: el diseño o layout que va a dibujar para cada elemento de su Lista.
            Este elemento que dibuja termina siendo un Item del Spinner
        3: es la estructura o coleccion con los datos a cargar
         */
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );
        //al Spinner se le setea el adaptador, para que este
        //pueda usar ese elemento para dibujar sus items
        spOpciones.setAdapter(adaptador);
    }

    private void cargarListaOpciones(){
        //Suponiendo que se cargo de una fuente como una DB
        //se deberia hacer un bucle e ir incorporando registro
        //por registro a la lista o array
        opciones = new ArrayList<>(
                Arrays.asList("Selecciona tu opcion", "Notas", "Faltas")
        );
        //Agregando nuevas opciones
        opciones.add("Algo Nuevo");
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
        spOpciones = findViewById(R.id.spOpciones);
        btnCalcular = findViewById(R.id.btnCalcular);
    }
}