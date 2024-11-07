package com.example.tarearecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter <ContactoAdapter.ContactoViewHolder> {

    private List<Contacto> listaContactos;
    private Context contexto;
    private OnItemClickListener listener;

    // Interfaz para manejar los clics
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }



    //Constructor del adaptador
    public ContactoAdapter(List<Contacto> listaContactos, Context contexto, OnItemClickListener listener) {
        this.listaContactos = listaContactos;
        this.contexto = contexto;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContactoAdapter.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflo el layout del contacto
        View itemView = LayoutInflater.from(contexto)
                .inflate(R.layout.layout_contacto, parent, false);
        return new ContactoViewHolder(itemView,listener);
    }

    // Clase ViewHolder para mantener las vistas de cada contacto
    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        ImageView Imagen;
        TextView Nombre, Apellidos, Email, Telefono;

        public ContactoViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            Imagen = itemView.findViewById(R.id.idImagen);
            Nombre = itemView.findViewById(R.id.idNombre);
            Apellidos = itemView.findViewById(R.id.idApellidos);
            Email = itemView.findViewById(R.id.idEmail);
            Telefono = itemView.findViewById(R.id.idTelefono);

            // Configurar el click para cada elemento, pasando la View y la posición
            itemView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onItemClick(view, getAdapterPosition());
                }
            });


        };
    }


            @Override
        public void onBindViewHolder (@NonNull ContactoViewHolder holder,int position){
            Contacto contacto = listaContactos.get(position);
            holder.Imagen.setImageResource(contacto.getFoto());
            holder.Nombre.setText("Nombre: " + contacto.getNombre());
            holder.Apellidos.setText("Apellidos: " + contacto.getApellidos());
            holder.Email.setText("Email: " + contacto.getEmail());
            holder.Telefono.setText("Teléfono: " + contacto.getTelefono());
        }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }


    public int getCount() {
        return listaContactos.size();
    }
}