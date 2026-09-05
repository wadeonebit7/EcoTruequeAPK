package com.example.ecotrueque;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PublicarObjetoActivity extends AppCompatActivity {

    EditText producto;
    RadioGroup categoria;
    Button botonpublicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_publicar_objeto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        producto = findViewById(R.id.eldiabloproducto);
        categoria = findViewById(R.id.rgCategorias);

        botonpublicar = findViewById(R.id.botonpublicar);
        botonpublicar.setOnClickListener(v -> {

            // Logica para extraer nombre de producto
            String nombreProducto = producto.getText().toString().trim();
                if (nombreProducto.isEmpty()) {
                producto.setError("Primero ingresa el nombre del producto");
                return;
            }
            // Logica para extraer la categoria (RadioButton) dentro del RadioGroup
            int idSelectCategoria = categoria.getCheckedRadioButtonId();
            RadioButton radioSelect = findViewById(idSelectCategoria);
            String categoria = radioSelect.getText().toString();

            Intent intent = new Intent( PublicarObjetoActivity.this, DetalleObjetoActivity.class);

            intent.putExtra("NAME_PRODUCT", nombreProducto);
            intent.putExtra("CATEGORY", categoria);

            startActivity(intent);
        });
    }
}