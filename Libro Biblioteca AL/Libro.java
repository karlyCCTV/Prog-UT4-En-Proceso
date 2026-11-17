/**
 * Modela un libro que hay en una biblioteca
 * Todo libro tiene un título, un nº de páginas y un atributo
 * disponible que indica si está disponible o no (a true si lo está,
 * a false si no lo está)
 * 
 */
public class Libro
{     
   //TODO 
   private String titulo;
   private int paginas;
   private boolean disponible;
   
    /**
     * Constructor - crea un libro a partir del título y
     * las páginas indicadas como parámetros
     * Inicialmente todo libro está disponible
     */
    public Libro(String titulo, int paginas){
        this.titulo = titulo;
        this.paginas = paginas;
        this.disponible = true;
    }

    /**
     * accesor para el título
     */
   //TODO    
   public String getTitulo(){
       return this.titulo;
   }

    /**
     * accesor para las páginas
     */
   //TODO 
   public int getPaginas() {
       return this.paginas;
   }
   
   
    /**
     * accesor de nombre estaDisponible() 
     * para el atributo disponible
     */
    ////TODO 
    public boolean estaDisponible() {
        return this.disponible;
    }

    /**
     * devuelve true si el libro actual tiene más páginas que el recibido como parámetro
     */
    public  boolean masPaginasQue(Libro otro)    {
       //TODO 
       return this.paginas > otro.getPaginas();
    }

    /**
     * se presta un libro, éste deja de estar disponible
     */
    public void prestar()    {
        //TODO 
        if(disponible) {
            this.disponible = false;
        }
    }    

    /**
     * se devuelve un libro, vuelve a estar disponible
     */
    public void devolver()    {
       //TODO 
       if(!disponible) {
           this.disponible = true;
       }
       
    }

    /**
     * Representación textual del libro
     *       Título: XXXXXXXXXX
     *      Páginas: XXX
     *   Disponible: XXX
     *   
     *   Dos columnas, 1ª columna ocupa 15 posiciones alineada a la derecha
     *                 2ª columna alineada a la izquierda
     */
    public  String toString()    {
        //TODO 
        String str = "Título: " + getTitulo() + "\n";
        str += "Páginas: " + getPaginas() + "\n";
        str += "Disponible: " + estaDisponible();
        return str;
    }

}
