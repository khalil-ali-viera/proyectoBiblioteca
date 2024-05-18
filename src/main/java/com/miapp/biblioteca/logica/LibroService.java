package com.miapp.biblioteca.logica;

import java.util.ArrayList;
import com.miapp.biblioteca.Libro;

public class LibroService {

	// ESTADO: ATRIBUTOS;
	private ArrayList<Libro> biblioteca; // Lista de Libros almacenados en una ArrayList;

	// COMPORTAMIENTO: FUNCIONES, PROCEDIMIENTOS Y MÉTODOS;
	// MÉTODO CONSTRUCTOR POR DEFECTO;
	public LibroService() {
	}

	// MÉTODO CONSTRUCTOR CON PARÁMETROS;
	public LibroService(ArrayList<Libro> biblioteca) {
		this.biblioteca = biblioteca;
	}

	// MÉTODOS GETTERS Y SETTERS;

	// MÉTODOS PROPIOS DE LA CLASE LibroService;
	/*
	 * CRUD
	 */

	// CREATE
	public void create(String titulo, String autor, String ISBN, String genero) {
		Libro nuevoLibro = new Libro(titulo, autor, ISBN, genero);
		biblioteca.add(nuevoLibro);
	}

	// READ
	// READ ALL
	public ArrayList<Libro> readAll() {
		return biblioteca;
	}

	// READ BY ISBN
	public Libro readByISBN(String ISBN) {
		for (Libro libro : biblioteca) {
			if (libro.getISBN().equals(ISBN)) {
				return libro;
			}
		}
		return null;
	}

	// READ BY TITULO
	public ArrayList<Libro> readByTitulo(String titulo) {
		ArrayList<Libro> listaLibrosTitulo = new ArrayList<>();
		for (Libro libro : biblioteca) {
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				listaLibrosTitulo.add(libro);
			}
		}
		return listaLibrosTitulo;
	}

	// READ BY AUTOR
	public ArrayList<Libro> readByAutor(String autor) {
		ArrayList<Libro> listaLibrosAutor = new ArrayList<>();
		for (Libro libro : biblioteca) {
			if (libro.getAutor().equalsIgnoreCase(autor)) {
				listaLibrosAutor.add(libro);
			}
		}
		return listaLibrosAutor;
	}

	// READ BY GENERO
	public ArrayList<Libro> readByGenero(String genero) {
		ArrayList<Libro> listaLibrosGenero = new ArrayList<>();
		for (Libro libro : biblioteca) {
			if (libro.getGenero().equalsIgnoreCase(genero)) {
				listaLibrosGenero.add(libro);
			}
		}
		return listaLibrosGenero;
	}

	// UPDATE BY ISBN
	public void updateByISBN(String ISBN, String nuevoTitulo, String nuevoAutor, String nuevoGenero) {
		for (Libro libro : biblioteca) {
			if (libro.getISBN().equals(ISBN)) {
				libro.setTitulo(nuevoTitulo);
				libro.setAutor(nuevoAutor);
				libro.setGenero(nuevoGenero);
			}
		}

	}

	// DELETE BY ISBN
	public void deleteByISBN(String ISBN) {
		biblioteca.removeIf(libro -> libro.getISBN().equals(ISBN));
	}

	// VERIFY BY ISBN
	public boolean estaDisponible(Libro libro) {
		return libro.getDisponible();
	}

}
