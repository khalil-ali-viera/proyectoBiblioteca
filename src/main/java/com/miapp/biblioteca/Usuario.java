package com.miapp.biblioteca;

import java.util.ArrayList;

public class Usuario {

	// ESTADO: ATRIBUTOS;
	private String nombre;
	private String id;
	private ArrayList<Libro> librosPrestados;

	// COMPORTAMIENTO: FUNCIONES, PROCEDIMIENTOS Y MÉTODOS;
	// MÉTODO CONSTRUCTOR POR DEFECTO;
	public Usuario() {
	}

	// MÉTODO CONSTRUCTOR CON PARÁMETROS;
	public Usuario(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
		this.librosPrestados = new ArrayList<Libro>();
	}

	// MÉTODOS GETTERS Y SETTERS;
	public String getNombre() { // getter nombre
		return nombre;
	}

	public void setNombre(String nombre) { // setter nombre
		this.nombre = nombre;
	}

	public String getId() { // getter id
		return id;
	}

	public void setId(String id) { // setter id
		this.id = id;
	}

	public ArrayList<Libro> getLibrosPrestados() { // getter librosPrestados
		return librosPrestados;
	}
	
	// MÉTODO/S PROPIOS DE LA CLASE Usuario;
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", id=" + id + ", librosPrestados=" + librosPrestados + "]";
	}

}
