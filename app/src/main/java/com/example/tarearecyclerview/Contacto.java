package com.example.tarearecyclerview;

public class Contacto {


        private int foto;
        private String nombre;
        private String apellidos;
        private String email;
        private String telefono;


        //Constructor
        public Contacto(int foto, String nombre, String apellidos, String email, String telefono) {
            this.foto = foto;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.email = email;
            this.telefono = telefono;
        }


        //Getters & Setters:
        public int getFoto() {
            return foto;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public String getEmail() {
            return email;
        }

        public String getTelefono() {
            return telefono;
        }
    }
