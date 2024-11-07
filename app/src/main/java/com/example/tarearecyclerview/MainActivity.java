package com.example.tarearecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactoAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ContactoAdapter adapter;
    private List<Contacto> listaContactos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Crear datos para la lista
        listaContactos = new ArrayList<>();
        listaContactos.add(new Contacto(R.drawable.avatar1, "Juan", "Pérez", "juan@mail.com", "123456789"));
        listaContactos.add(new Contacto(R.drawable.avatar2, "María", "González", "maria@mail.com", "987654321"));
        listaContactos.add(new Contacto(R.drawable.avatar1, "Pedro", "García", "pedro@mail.com", "123456789"));
        listaContactos.add(new Contacto(R.drawable.avatar2, "Lucía", "Gómex", "lucia@mail.com", "987654321"));
        listaContactos.add(new Contacto(R.drawable.avatar2, "Carlos", "Piñeiro", "carlos@mail.com", "987654321"));


        // Crear y asociar el adaptador
        adapter = new ContactoAdapter(listaContactos, MainActivity.this,MainActivity.this);
        recyclerView.setAdapter(adapter);


        // Establecer el LayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setVerticalScrollBarEnabled(true);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    //Fuera del onCreate implemento el onItemClick

    @Override
    public void onItemClick(View view, int position) {
        Contacto contacto = listaContactos.get(position);
        String mensaje = "Nombre: " + contacto.getNombre() + " - Teléfono: " + contacto.getTelefono();
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}