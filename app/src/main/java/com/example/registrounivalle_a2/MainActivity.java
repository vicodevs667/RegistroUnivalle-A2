package com.example.registrounivalle_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
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

    private ArrayList<String> campos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnRegistrar.setOnClickListener(view -> {
            obtenerInformacion();
            mostrarMensaje();
            //validar cada campo
        });
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
        String nombre = etNombre.getText().toString();
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