package com.miapp.biblioteca.gui;

import java.util.ArrayList;
import java.util.Scanner;
import com.miapp.biblioteca.Libro;
import com.miapp.biblioteca.Usuario;
import com.miapp.biblioteca.logica.LibroService;
import com.miapp.biblioteca.logica.UsuarioService;

public class Main {

	public static void main(String[] args) {

		// CREAR ARRAYLIST DE LIBROS;
		ArrayList<Libro> bibliotecaDT = new ArrayList<>();

		// CREAR ARRAYLIST DE USUARIOS;
		ArrayList<Usuario> usuariosDT = new ArrayList<>();

		// INSTANCIAR OBJETO DE LIBROSERVICE PARA ALMACENAR LIBROS EN
		// biblioteca(LibroService) Y UTILIZAR SUS MÉTODOS;
		LibroService libroService = new LibroService(bibliotecaDT);

		// INSTANCIAR OBJETO DE USUARIOSERVICE PARA ALMACENAR USUARIOS EN
		// usuarios(UsuarioService) Y UTILIZAR SUS MÉTODOS;
		UsuarioService usuarioService = new UsuarioService(usuariosDT);

		// CREO UN OBJETO DE LA CLASE SCANNER PARA PODER INGRESAR POR TECLADO;
		Scanner sc = new Scanner(System.in);

		// CREO LA VARIABLE OPCION PARA QUE EL USUARIO TENGA UNA OPCIÓN DEL 1 AL 9;
		int opcion;

		// DO-WHILE
		do {
			System.out.println(" == Biblioteca DT Virtual == ");
			System.out.println("1 - Crear Libro");
			System.out.println("2 - Actualizar Libro");
			System.out.println("3 - Buscar Libro por ISBN");
			System.out.println("4 - Buscar Libro por titulo");
			System.out.println("5 - Listar Libros");
			System.out.println("6 - Eliminar Libro");
			System.out.println("7 - Prestamos Libros");
			System.out.println("8 - Devoluciones");
			System.out.println("9 - Salir");
			System.out.println(" == Seleccione una opción == ");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			// CREAR LIBRO;
			case 1:
				System.out.println("Ingrese Titulo:");
				String crearTitulo = sc.nextLine();

				System.out.println("Ingrese Autor:");
				String crearAutor = sc.nextLine();

				System.out.println("Ingrese ISBN:");
				String crearISBN = sc.nextLine();

				System.out.println("Ingrese Genero:");
				String crearGenero = sc.nextLine();

				libroService.create(crearTitulo, crearAutor, crearISBN, crearGenero);
				break;

			// ACTUALIZAR LIBRO;
			case 2:
				System.out.println("Ingrese el ISBN del libro a actualizar:");
				String actualizarPorISBN = sc.nextLine();

				System.out.println("Ingrese el nuevo Titulo:");
				String nuevoTitulo = sc.nextLine();

				System.out.println("Ingrese el nuevo Autor:");
				String nuevoAutor = sc.nextLine();

				System.out.println("Ingrese el nuevo Genero");
				String nuevoGenero = sc.nextLine();

				libroService.updateByISBN(actualizarPorISBN, nuevoTitulo, nuevoAutor, nuevoGenero);
				break;

			// BUSCAR LIBRO POR ISBN;
			case 3:
				System.out.println("Ingrese el ISBN del libro a buscar:");
				String buscarPorISBN = sc.nextLine();

				Libro buscadoPorISBN = libroService.readByISBN(buscarPorISBN);

				if (buscadoPorISBN != null) {
					System.out.println("Libro encontrado: " + buscadoPorISBN.getTitulo());
				} else {
					System.out.println("Libro no encontrado");
				}
				break;

			// BUSCAR LIBRO POR TITULO;
			case 4:
				System.out.println("Ingrese el Titulo del libro a buscar:");
				String buscarPorTitulo = sc.nextLine();

				ArrayList<Libro> buscadoPorTitulo = libroService.readByTitulo(buscarPorTitulo);

				if (!buscarPorTitulo.isEmpty()) {
					System.out.println("Libros encontrados:");
					for (Libro libro : buscadoPorTitulo) {
						System.out.println(libro.getTitulo());
					}
				} else {
					System.out.println("No se ha encontrado el libro por el titulo.");
				}
				break;

			// LISTAR LIBROS;
			case 5:
				System.out.println("Lista de libros");

				ArrayList<Libro> buscadoTodosLosLibros = libroService.readAll();

				for (Libro libro : buscadoTodosLosLibros) {
					System.out.println(libro.getTitulo() + "(" + libro.getISBN() + ")");
				}
				break;

			// ELIMINAR LIBRO;
			case 6:
				System.out.println("Ingrese el ISBN del libro a eliminar:");
				String eliminarPorISBN = sc.nextLine();

				libroService.deleteByISBN(eliminarPorISBN);
				break;

			// PRESTAMOS LIBROS;
			// CREAR USUARIO;
			case 7:
				System.out.println("Ingrese nombre del usuario:");
				String usuarioNombre = sc.nextLine();

				System.out.println("Ingrese id del usuario:");
				String usuarioId = sc.nextLine();

				usuarioService.create(usuarioNombre, usuarioId);

				System.out.println("Ingrese el id del usuario:");
				String usuarioIdBuscado = sc.nextLine();

				Usuario usuarioPrestamo = usuarioService.readById(usuarioIdBuscado);

				System.out.println("Ingrese el ISBN del libro a prestar:");
				String libroPrestamoPorISBN = sc.nextLine();

				Libro libroPrestamoPorISBNEncontrado = libroService.readByISBN(libroPrestamoPorISBN);

				if (usuarioPrestamo != null && libroPrestamoPorISBNEncontrado != null
						&& libroPrestamoPorISBNEncontrado.getDisponible()) {

					usuarioService.prestarLibroAUsuario(usuarioPrestamo, libroPrestamoPorISBNEncontrado);
					System.out.println("Se presto el libro con éxito");

				} else {
					System.out.println("Usuario no encontrado o libro no encontrado o libro no disponible");
				}
				break;

			// DEVOLUCIONES;
			case 8:
				System.out.println("Ingrese el ID del usuario: ");
				String idUsuarioDevolucion = sc.nextLine();

				Usuario usuarioDevolucion = usuarioService.readById(idUsuarioDevolucion);

				System.out.println("Ingrese el ISBN del libro:");
				String ISBNLibroDevolucion = sc.nextLine();

				Libro libroDevolucion = libroService.readByISBN(ISBNLibroDevolucion);

				if (usuarioDevolucion != null && libroDevolucion != null && !libroDevolucion.getDisponible()) {

					usuarioService.devolverLibro(usuarioDevolucion, libroDevolucion);
					System.out.println("Libro devuelto");

				} else {
					System.out.println("No coincide");
				}

				break;

			// SALIR;
			default:
				System.out.println("La opción ingresada es invalida.");
				break;
			}

		} while (opcion != 9);
	}

}
