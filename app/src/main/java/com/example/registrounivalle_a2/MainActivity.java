package com.example.registrounivalle_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etApellido, etEmail, etCelular, etCodigo;
    private Button btnRegistrar;
    private Switch swEstudiante;

    String nombre;
    private ArrayList<String> campos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        etCodigo.setVisibility(View.GONE);
        btnRegistrar.setOnClickListener(view -> {
            obtenerInformacion();
            contarCaracteres();
            //mostrarMensaje();
            //validar cada campo
        });
        /*
        Para poder interactuar con el evento que pasa en los
        checkboxes y switches que es su marcado y desmarcado
        se debe configurar un Listener para que pueda estar
        pendiente a cuando pasa el evento.
        y el evento se llama CheckedChanged
         */
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gestionarVistaCodigo(b);
            }
        });
    }

    private void gestionarVistaCodigo(boolean marcado) {
        if(marcado) {
            etCodigo.setVisibility(View.VISIBLE);
        } else {
            etCodigo.setVisibility(View.GONE);
        }
    }

    private void mostrarVentana(boolean b) {
        String mensaje = "no estoy marcado";
        if(b) {
            mensaje = "estoy marcado";
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }

    private void contarCaracteres() {
        if (swEstudiante.isChecked()) { //true si esta marcado o false si no esta marcado
            Toast.makeText(this,"Caracteres: " + nombre.length(),
                    Toast.LENGTH_SHORT).show();
        }
    }


    private void inicializarVistas() {
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEmail = findViewById(R.id.etEmail);
        etCelular = findViewById(R.id.etCelular);
        etCodigo = findViewById(R.id.etCodigo);
        swEstudiante = findViewById(R.id.swEstudiante);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }

    private void obtenerInformacion() {
        nombre = etNombre.getText().toString();
        String apellido = etApellido.getText().toString();
        String email = etEmail.getText().toString();
        String celular = etCelular.getText().toString();
        String codigo = etCodigo.getText().toString();
        campos = new ArrayList<>(Arrays.asList(nombre, apellido, email, celular, codigo));
    }

    private void mostrarMensaje() {
        if(validarCampos(campos)) {
            String mensaje = campos.get(0) + ", " + campos.get(1) + ", " +
                    campos.get(2) + ", " + campos.get(3);
           Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Falta llenar campos", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validarCampos(ArrayList campos) {
        for (int i = 0; i < campos.size(); i++) {
            if (campos.get(i).toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}