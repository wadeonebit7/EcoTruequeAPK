package com.example.ecotrueque;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleObjetoActivity extends AppCompatActivity {

    TextView txtnombre;
    TextView txtcategoria;
    Button botonvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_detalle_objeto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtnombre = findViewById(R.id.dProducto);
        txtcategoria = findViewById(R.id.dCategoria);
        botonvolver = findViewById(R.id.botonvolver);

        Intent intentRecibido = getIntent();

        String nameproducto = intentRecibido.getStringExtra("NAME_PRODUCT");
        String categoria = intentRecibido.getStringExtra("CATEGORY");

        txtnombre.setText("Producto: " + nameproducto);
        txtcategoria.setText("Categoria: " + categoria);

        botonvolver.setOnClickListener(v -> {
            Intent intent = new Intent(DetalleObjetoActivity.this, MenuPrincipalActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            startActivity(intent);
        });
    }
}