public class Tienda {

    private Almacen almacen;
    private Caja caja;

    /* TODO ******************************
    DESARROLLE LOS CONSTRUCTORES QUE SE PIDEN
     */
    public Tienda() {
        this.almacen = new Almacen();
        this.caja = new Caja();
    }
    public Tienda(int numeroBolsos, int numeroSombreros, int numeroCinturones) {
        this.almacen = new Almacen (numeroBolsos,numeroSombreros,numeroCinturones);
        this.caja = new Caja();
    }
    //*************************************

    public Almacen getAlmacen() {
        return almacen;
    }

    public Caja getCaja() {
        return caja;
    }

       /* TODO ****************************
    DESARROLLE LOS METODOS QUE SE PIDEN
     */
    public void 


    //**************************************

}
