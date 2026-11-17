
/**
 * Una biblioteca tiene únicamente dos libros
 */
public class Biblioteca
{
    private Libro libro1;
    private Libro libro2;

    /**
     * Constructor 1 . Crea los libros  a partir de los valores de los parámetros
     */
    public Biblioteca(String titulo1, int paginas1, String titulo2, int paginas2)  {
         //TODO
         this.libro1 = new Libro(titulo1,paginas1);
         this.libro2 = new Libro(titulo2,paginas2);
    }

    /**
     * Constructor 2 . Crea los libros  a partir de los parámetros
     */
    public Biblioteca(Libro libro1, Libro libro2)   {
          //TODO
          this.libro1 = libro1;
          this.libro2 = libro2;
    }

    /**
     * Se presta  el libro1 si está  disponible 
     */
    public void prestarLibro1() {
         //TODO
         libro1.prestar();

    }
    /**
     * Se presta  el libro2 si está  disponible 
     */
    public void prestarLibro2() {
          //TODO
          libro2.prestar();

    }

    /**
     *  Devuelve la cantidad de libros disponibles en la biblioteca
     *
     */
    public int cuantosDisponibles()    {
        //TODO
        int count = 0;
        if(libro1.estaDisponible()) {
            count++;
        }
        if(libro2.estaDisponible()) {
            count++;
        }
        return count;
    }

     /**
     *  Devuelve el título del libro con más páginas
     *  Si coinciden en páginas se devuelve "Mismo nº de páginas"
     *
     */
    public String masPaginas()    {
        //TODO
        if (libro1.masPaginasQue(libro2)) {
            return libro1.getTitulo();
        }
        return libro2.getTitulo();
    }

    /**
     * crea y devuelve un nuevo libro con el título de libro1 y las páginas de  libro2
     */
    public Libro nuevoLibro() {
       //TODO
       Libro nuevoLibro = new Libro(libro1.getTitulo(),libro2.getPaginas());
         return nuevoLibro;
    }

    /**
     * Representación textual de la biblioteca
     */
    public  String toString()      {
         //TODO
         String str = libro1.toString();
         str += "\n___________________________________________\n";
         str += libro2.toString();
         return str;
         
    }
}
