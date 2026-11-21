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
    public void realizarVenta(Accesorios venta) {
        venderBolsos(venta.getNumBolsos());
        venderCinturones(venta.getNumCinturones());
        venderSombreros(venta.getNumSombreros());
    }
    public void cargarAccesorios(Accesorios carga) {
        almacen.almacenarBolsos(carga.getNumBolsos());
        almacen.almacenarCinturones(carga.getNumCinturones());
        almacen.almacenarSombreros(carga.getNumSombreros());
    }
    public void venderBolsos(int numBolsos) {
        if (numBolsos <= 0) {
            return;
        }
        if (!almacen.eliminarBolsos(numBolsos)) {
            System.out.println("No se ha podido ejecutar la operación de venta de bolsos");
            return;
        }
        caja.aumentarVentasBolsos(numBolsos);
        caja.aumentarFacturacion(numBolsos * Constantes.PRECIO_BOLSO);
    }
    public void venderCinturones(int numCinturones) {
        if (numCinturones <= 0) {
            return;
        }
        if (!almacen.eliminarCinturones(numCinturones)) {
            System.out.println("No se ha podido ejecutar la operación de venta de cinturones");
            return;
        }
        caja.aumentarVentasCinturones(numCinturones);
        caja.aumentarFacturacion(numCinturones * Constantes.PRECIO_CINTURON);
    }
    public void venderSombreros(int numSombreros) {
        if (numSombreros <= 0) {
            return;
        }
        if (!almacen.eliminarSombreros(numSombreros)) {
            System.out.println("No se ha podido ejecutar la operación de venta de sombreros");
            return;
        }
        caja.aumentarVentasSombreros(numSombreros);
        caja.aumentarFacturacion(numSombreros * Constantes.PRECIO_SOMBRERO);
    }


    
    


    //**************************************

}
