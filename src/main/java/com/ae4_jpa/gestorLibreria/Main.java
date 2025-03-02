package com.ae4_jpa.gestorLibreria;


import com.ae4_jpa.gestorLibreria.controller.*;
import com.ae4_jpa.gestorLibreria.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestorLibreriaPU");
        EntityManager em = emf.createEntityManager();

        // Instanciar controllers para cada entidad
        AutorController autorController = new AutorController(em);
        EditorialController editorialController = new EditorialController(em);
        LibroController libroController = new LibroController(em);
        LibreriaController libreriaController = new LibreriaController(em);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar Autores");
            System.out.println("2. Gestionar Editoriales");
            System.out.println("3. Gestionar Libros");
            System.out.println("4. Gestionar Librerías");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarAutores(scanner, autorController);
                    break;
                case 2:
                    gestionarEditoriales(scanner, editorialController);
                    break;
                case 3:
                    gestionarLibros(scanner, libroController);
                    break;
                case 4:
                    gestionarLibrerias(scanner, libreriaController);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        }
        System.out.println("Fin del programa.");
        scanner.close();
        em.close();
        emf.close();
    }

    private static void gestionarAutores(Scanner scanner, AutorController autorController) {
        boolean salirAutores = false;
        while (!salirAutores) {
            System.out.println("\n--- GESTIÓN DE AUTORES ---");
            System.out.println("1. Crear Autor");
            System.out.println("2. Listar Autores");
            System.out.println("3. Buscar Autor por ID");
            System.out.println("4. Buscar Autor por nombre");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del autor: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese los apellidos: ");
                    String apellidos = scanner.nextLine();
                    Autor autor = new Autor();
                    autor.setNombre(nombre);
                    autor.setApellidos(apellidos);
                    autor.setFechaNacimiento(new Date());
                    autorController.createAutor(autor);
                    System.out.println("Autor creado con éxito.");
                    break;
                case 2:
                    List<Autor> autores = autorController.getAllAutores();
                    System.out.println("Lista de Autores:");
                    for (Autor a : autores) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del autor: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Autor autorEncontrado = autorController.getAutorById(id);
                    if (autorEncontrado != null) {
                        System.out.println("Autor encontrado: " + autorEncontrado);
                    } else {
                        System.out.println("No se encontró autor con ID " + id);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    List<Autor> autoresPorNombre = autorController.getAutoresByNombre(nombreBusqueda);
                    if (autoresPorNombre.isEmpty()) {
                        System.out.println("No se encontraron autores con ese nombre.");
                    } else {
                        for (Autor a : autoresPorNombre) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 5:
                    salirAutores = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void gestionarEditoriales(Scanner scanner, EditorialController editorialController) {
        boolean salirEditoriales = false;
        while (!salirEditoriales) {
            System.out.println("\n--- GESTIÓN DE EDITORIALES ---");
            System.out.println("1. Crear Editorial");
            System.out.println("2. Listar Editoriales");
            System.out.println("3. Buscar Editorial por ID");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la editorial: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el país: ");
                    String pais = scanner.nextLine();
                    Editorial editorial = new Editorial();
                    editorial.setNombre(nombre);
                    editorial.setPais(pais);
                    editorialController.createEditorial(editorial);
                    System.out.println("Editorial creada con éxito.");
                    break;
                case 2:
                    List<Editorial> editoriales = editorialController.getAllEditoriales();
                    System.out.println("Lista de Editoriales:");
                    for (Editorial e : editoriales) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID de la editorial: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Editorial editorialEncontrada = editorialController.getEditorialById(id);
                    if (editorialEncontrada != null) {
                        System.out.println("Editorial encontrada: " + editorialEncontrada);
                    } else {
                        System.out.println("No se encontró editorial con ese ID.");
                    }
                    break;
                case 4:
                    salirEditoriales = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void gestionarLibros(Scanner scanner, LibroController libroController) {
        boolean salirLibros = false;
        while (!salirLibros) {
            System.out.println("\n--- GESTIÓN DE LIBROS ---");
            System.out.println("1. Crear Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Buscar Libro por ID");
            System.out.println("4. Buscar Libro por Título");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el género del libro: ");
                    String genero = scanner.nextLine();
                    Libro libro = new Libro();
                    libro.setTitulo(titulo);
                    libro.setGenero(genero);
                    libro.setFechaEdicion(new Date());
                    libroController.createLibro(libro);
                    System.out.println("Libro creado con éxito.");
                    break;
                case 2:
                    List<Libro> libros = libroController.getAllLibros();
                    System.out.println("Lista de Libros:");
                    for (Libro l : libros) {
                        System.out.println(l);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del libro: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Libro libroEncontrado = libroController.getLibroById(id);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                        System.out.println("No se encontró libro con ese ID.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el título a buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    List<Libro> librosPorTitulo = libroController.getLibrosByTitulo(tituloBusqueda);
                    if (librosPorTitulo.isEmpty()) {
                        System.out.println("No se encontraron libros con ese título.");
                    } else {
                        for (Libro l : librosPorTitulo) {
                            System.out.println(l);
                        }
                    }
                    break;
                case 5:
                    salirLibros = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void gestionarLibrerias(Scanner scanner, LibreriaController libreriaController) {
        boolean salirLibrerias = false;
        while (!salirLibrerias) {
            System.out.println("\n--- GESTIÓN DE LIBRERÍAS ---");
            System.out.println("1. Crear Librería");
            System.out.println("2. Listar Librerías");
            System.out.println("3. Buscar Librería por ID");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la librería: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la dirección: ");
                    String direccion = scanner.nextLine();
                    Libreria libreria = new Libreria();
                    libreria.setNombre(nombre);
                    libreria.setDireccion(direccion);
                    libreriaController.createLibreria(libreria);
                    System.out.println("Librería creada con éxito.");
                    break;
                case 2:
                    List<Libreria> librerias = libreriaController.getAllLibrerias();
                    System.out.println("Lista de Librerías:");
                    for (Libreria l : librerias) {
                        System.out.println(l);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID de la librería: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Libreria libreriaEncontrada = libreriaController.getLibreriaById(id);
                    if (libreriaEncontrada != null) {
                        System.out.println("Librería encontrada: " + libreriaEncontrada);
                    } else {
                        System.out.println("No se encontró librería con ese ID.");
                    }
                    break;
                case 4:
                    salirLibrerias = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
