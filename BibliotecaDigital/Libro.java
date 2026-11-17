public class Libro
{
    private final double precioFisico = 20;
    private final double precioEbook = 10;
    
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private int paginasLeidas = 0;
    private boolean disponibleEnEbook = false;
    //constructor
    public Libro(String miTitulo, String miAutor, int miNumeroPaginas) {
        this.titulo = miTitulo;
        this.autor = miAutor;
        this.numeroPaginas = miNumeroPaginas;
    }
    //setters
    public void disponible(boolean value){
        this.disponibleEnEbook = value;
    }
    public void paginas (int value){
        this.paginasLeidas = value;
    }
    //getters
    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public int getNumeroPag(){
        return this.numeroPaginas;
    }
    public int getPaginasLeidas() {
       return this.paginasLeidas;
    }
    public boolean getDisponibleEnEbook() {
        return this.disponibleEnEbook;
    }
    public double getPrecioFisico() {
        return this.precioFisico;
    }
    public double getPrecioEbook() {
        return this.precioEbook;
    }
    //funciones
    public double calcularProgresoLectura(){
        /*
        System.out.println("BREAK");
        System.out.println(this.paginasLeidas);
        System.out.println(this.numeroPaginas);
        System.out.println("BREAK");
        */
        return ((double)this.paginasLeidas / (double)this.numeroPaginas)*100;
    }
    public void mostrarEstadoLectura(){
        double percent = calcularProgresoLectura();
        if (percent < 25) {
            System.out.println("Estás comenzando el libro, ¡sigue leyendo!");
        }else if (percent < 75) {
            System.out.println("Vas a buen ritmo, ¡sigue así!");
        }else {
            System.out.println("Casi terminas el libro, ¡no te rindas!");
        }
    }
    public double calcularPrecioTotal() {
        if (disponibleEnEbook) {
            return this.precioEbook;
        }else {
            return this.precioFisico;
        }
    }
    public void anyadirPaginasLeidas(int paginas){
        this.paginasLeidas += paginas;
        if (paginasLeidas >= numeroPaginas){
            this.paginasLeidas = this.numeroPaginas;
        }
    }
}