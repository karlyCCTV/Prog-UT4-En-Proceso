public class Main
{
    public static void main(String[] args){
        Libro Libro1 = new Libro("El Quijote", "Miguel de cervante", 1200);
        Libro Libro2 = new Libro("1984","George Orwell", 400);
        Libro Libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez",450);
        Libro Libro4 = new Libro("El Hobbit", "J.R.R. Tolkien", 300);
        
        mostrarDatos(Libro1);
        mostrarDatos(Libro2);
        mostrarDatos(Libro3);
        mostrarDatos(Libro4);
        
        Libro1.paginas(100);
        Libro2.paginas(200);
        Libro3.paginas(300);
        Libro4.paginas(400);
        
        mostrarDatos(Libro1);
        mostrarDatos(Libro2);
        mostrarDatos(Libro3);
        mostrarDatos(Libro4);
    }
    public static void mostrarDatos(Libro miLibro){
        
        
        System.out.println("**************************************");
        System.out.println("Título del libro: " + miLibro.getTitulo());
        System.out.println("Autor: " + miLibro.getAutor());
        System.out.println("Progreso de lectura: " + (int)miLibro.calcularProgresoLectura() + "%");
        
        System.out.print("Estado de lectura: ");
        miLibro.mostrarEstadoLectura();
        
        System.out.println("El precio total del libro es: " + miLibro.calcularPrecioTotal() + "€");
        System.out.println("**************************************");
    }
}