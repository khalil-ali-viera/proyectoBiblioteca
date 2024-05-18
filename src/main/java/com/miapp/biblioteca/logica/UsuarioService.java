package com.miapp.biblioteca.logica;

import java.util.ArrayList;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.Libro;

public class UsuarioService {

	// ESTADO: ATRIBUTOS;
	private ArrayList<Usuario> usuarios;

	// COMPORTAMIENTO: FUNCIONES, PROCEDIMIENTOS Y MÉTODOS;
	// MÉTODO CONSTRUCTOR POR DEFECTO;
	public UsuarioService() {
	}

	// MÉTODO CONSTRUCTOR CON PARÁMETROS;
	public UsuarioService(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	// MÉTODOS GETTERS Y SETTERS;

	// MÉTODOS PROPIOS DE LA CLASE UsuarioService;
	/*
	 * CRUD
	 */

	// CREATE
	public void create(String nombre, String id) {
		Usuario nuevoUsuario = new Usuario(nombre, id);
		usuarios.add(nuevoUsuario);
	}

	// READ
	// READ ALL
	public ArrayList<Usuario> readAll() {
		return usuarios;
	}

	// READ BY ID
	public Usuario readById(String id) {
		for (Usuario usuario : usuarios) {
			if (usuario.getId().equals(id)) {
				return usuario;
			}
		}
		return null;
	}

	// UPDATE BY ID
	public void updateById(String id, String nuevoNombre) {
		for (Usuario usuario : usuarios) {
			if (usuario.getId().equals(id)) {
				usuario.setNombre(nuevoNombre);
				;
			}
		}
	}

	// DELETE BY ID
	public void deleteById(String id) {
		usuarios.removeIf(usuario -> usuario.getId().equals(id));
	}

	// PRESTAR LIBRO
	public void prestarLibroAUsuario(Usuario usuario, Libro libro) {
		if (libro.getDisponible()) {
			usuario.getLibrosPrestados().add(libro);
			libro.setDisponible(false);
		} else {
			System.out.println("El libro no se encuentra disponible");
		}
	}

	// DEVOLVER LIBRO
	public void devolverLibro(Usuario usuario, Libro libro) {
		if (usuario.getLibrosPrestados().contains(libro)) {
			usuario.getLibrosPrestados().remove(libro);
			libro.setDisponible(true);
		}
	}

	// ENLISTAR LIBROS PRESTADOS DE UN USUARIO
	public ArrayList<Libro> enlistarLibrosUsuario(Usuario usuarios) {
		return usuarios.getLibrosPrestados();
	}
}
