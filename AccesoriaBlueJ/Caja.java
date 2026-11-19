public class Caja {

    private int numeroVentas;
    private int numeroBolsosVendidos;
    private int numeroCinturonesVendidos;
    private int numeroSombrerosVendidos;
    private double facturacion;

    /* TODO ++++++++++++++++++++++++++
    DESARROLLE EL CONSTRUCTOR QUE SE PIDE
     */
    public Caja() {
        this.numeroVentas = 0;
        this.numeroBolsosVendidos = 0;
        this.numeroCinturonesVendidos = 0;
        this.numeroSombrerosVendidos = 0;
        this.facturacion = 0.0;
        actualizarNumeroVentas();
    }   
    //+++++++++++++++++++++++++++++++++

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public int getNumeroSombrerosVendidos() {
        return numeroSombrerosVendidos;
    }

    public int getNumeroBolsosVendidos() {
        return numeroBolsosVendidos;
    }

    public int getNumeroCinturonesVendidos() {
        return numeroCinturonesVendidos;
    }

    public double getFacturacion() {
        return facturacion;
    }

    /* TODO **************************
    DESARROLLE LOS METODOS QUE SE PIDEN
     */
    public void actualizarNumeroVentas() {
        this.numeroVentas += (numeroBolsosVendidos +
            numeroCinturonesVendidos +
            numeroSombrerosVendidos);
    }
    
    public void aumentarVentasBolsos (int ventas) {
        numeroBolsosVendidos += ventas;
    }
    public void aumentarVentasSombreros (int ventas) {
        numeroSombrerosVendidos += ventas;
    }
    public void aumentarVentasCinturones (int ventas) {
        numeroCinturonesVendidos += ventas;
    }
    public void aumentarFacturacion(double dinero) {
        facturacion += dinero;
    }
    
    public double obtenerIVAAcumulado() {
        return (facturacion * 0.21);
    }


    //********************************


}
