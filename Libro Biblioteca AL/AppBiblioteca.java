import java.util.Scanner;

/**
 * 
 */
public class AppBiblioteca
{

   /**
     *  Dentro del main():
     *  - define y crea el teclado 
     *  - pide por teclado los datos de dos libros        
     *  - crea un objeto miBiblioteca usando el constructor 1
     *  - muestra la información de miBiblioteca
     *  
     *  - presta el libro 1
     *  - muestra ahora cuántos libros disponibles hay en miBiblioteca
     *  
     *  - pide ahora por teclado los datos de otros dos libros
     *  - crea ahora un objeto tuBiblioteca usando el 2º constructor      
     *  - muestra tuBiblioteca
     *  
     *  - pide a tuBiblioteca un nuevo libro (llamando al método nuevoLibro()
     *  - muestra la información de este libro
     *  
     *  - escribe el nombre del libro con más páginas en tuBiblioteca
     *  
     *  
     *  - Sal a línea de comandos y ejecuta el programa
     */
    public static void main(String[] args)   {
        //TODO
        //Scanner.next asignación
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el titulo del primer libro:");
        String titulo1 = scanner.nextLine();
        System.out.println("Introduce el numero de paginas del primer libro:");
        int paginas1 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduce el titulo del segundo libro:");
        String titulo2 = scanner.nextLine();
        System.out.println("Introduce el numero de paginas del segundo libro:");
        int paginas2 = scanner.nextInt();
        //creacion de biblioteca y mostrar biblioteca
        Biblioteca miBiblioteca = new Biblioteca(titulo1,paginas1,titulo2,paginas2);
        System.out.println(miBiblioteca.toString());
        System.out.println();
        //Prestar el libro 1 y cuenta de libros disponibles
        miBiblioteca.prestarLibro1();
        System.out.println("Numero de libros disponibles: " + miBiblioteca.cuantosDisponibles());
        //Scaner.next asignacion 2 libros
        System.out.println("Construcción de la nueva biblioteca");
        scanner.nextLine();
        System.out.println("Introduce el titulo del primer libro:");
        String titulo3 = scanner.nextLine();
        System.out.println("Introduce el numero de paginas del primer libro:");
        int paginas3 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduce el titulo del segundo libro:");
        String titulo4 = scanner.nextLine();
        System.out.println("Introduce el numero de paginas del segundo libro:");
        int paginas4 = scanner.nextInt();
        //Creación de los objetos libro3 y libro4 junto a la creacion de tuBiblioteca y mostrar biblioteca
        Libro libro3 = new Libro(titulo3,paginas3);
        Libro libro4 = new Libro(titulo4,paginas4);
        Biblioteca tuBiblioteca = new Biblioteca(libro3,libro4);
        System.out.println(tuBiblioteca.toString());
        System.out.println();
        //Crear un nuevo libro y mostrar la información
        System.out.println(tuBiblioteca.nuevoLibro().toString());
        System.out.println();
        //Escribir el libro con mas paginas de tuBiblioteca
        System.out.println("Titulo del libro con mas paginas de tuBiblioteca: " + tuBiblioteca.masPaginas());
    }
}
