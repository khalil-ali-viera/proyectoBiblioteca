package com.miapp.biblioteca;

public class Libro {

	// ESTADO: ATRIBUTOS;
	private String titulo;
	private String autor;
	private String ISBN;
	private String genero;
	private boolean disponible;

	// COMPORTAMIENTO: FUNCIONES, PROCEDIMIENTOS Y MÉTODOS;
	// MÉTODO CONSTRUCTOR POR DEFECTO;
	public Libro() {
	}

	// MÉTODO CONSTRUCTOR CON PARÁMETROS;
	public Libro(String titulo, String autor, String ISBN, String genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		this.genero = genero;
		this.disponible = true;
	}

	// MÉTODOS GETTERS Y SETTERS;
	public String getTitulo() { // getter titulo
		return titulo;
	}

	public void setTitulo(String titulo) { // setter titulo
		this.titulo = titulo;
	}

	public String getAutor() { // getter autor
		return autor;
	}

	public void setAutor(String autor) { // setter autor
		this.autor = autor;
	}

	public String getISBN() { // getter ISBN
		return ISBN;
	}

	public void setISBN(String ISBN) { // setter ISBN
		this.ISBN = ISBN;
	}

	public String getGenero() { // getter genero
		return genero;
	}

	public void setGenero(String genero) { // setter genero
		this.genero = genero;
	}

	public boolean getDisponible() { // getter disponible
		return disponible;
	}

	public void setDisponible(boolean disponible) { // setter disponible
		this.disponible = disponible;
	}

	// MÉTODO/S PROPIOS DE LA CLASE Libro;
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", genero=" + genero
				+ ", disponible=" + disponible + "]";
	}

}
