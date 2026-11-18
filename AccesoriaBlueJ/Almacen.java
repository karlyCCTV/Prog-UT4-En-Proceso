public class Almacen {

    private int numeroBolsos;
    private int numeroCinturones;
    private int numeroSombreros;

    /* TODO ++++++++++++++++++++++++++
    DESARROLLE LOS CONSTRUCTORES QUE SE PIDEN
     */
    public Almacen(){
        this.numeroBolsos = 0;
        this.numeroCinturones = 0;
        this.numeroSombreros = 0;
    }
    public Almacen(int numBolsos, int numCinturones, int numSombreros){
        this.numeroBolsos = numBolsos;
        this.numeroCinturones = numCinturones;
        this.numeroSombreros = numSombreros;
    }

    // ++++++++++++++++++++++++++++++++

    public int getNumeroBolsos() {
        return numeroBolsos;
    }

    public void setNumeroBolsos(int numeroBolsos) {
        this.numeroBolsos = numeroBolsos;
    }

    public int getNumeroCinturones() {
        return numeroCinturones;
    }

    public void setNumeroCinturones(int numeroCinturones) {
        this.numeroCinturones = numeroCinturones;
    }

    public int getNumeroSombreros() {
        return numeroSombreros;
    }

    public void setNumeroSombreros(int numeroSombreros) {
        this.numeroSombreros = numeroSombreros;
    }

        /* TODO ++++++++++++++++++++++++++
    DESARROLLE LOS METODOS QUE SE PIDEN
     */
    public boolean almacenarBolsos(int numero) {
        if (this.numeroBolsos + numero > Constantes.CAPACIDAD_BOLSOS) {
            System.out.println("Se excede la capacidad máxima");
            return false;
        }
        this.numeroBolsos += numero;
        return true;
    }
    public boolean almacenarSombreros(int numero) {
        if (this.numeroSombreros + numero > Constantes.CAPACIDAD_SOMBREROS) {
            System.out.println("Se excede la capacidad máxima");
            return false;
        }
        this.numeroSombreros += numero;
        return true;
    }
    public boolean almacenarCinturones(int numero) {
        if (this.numeroCinturones + numero > Constantes.CAPACIDAD_CINTURONES) {
            System.out.println("Se excede la capacidad máxima");
            return false;
        }
        this.numeroCinturones += numero;
        return true;
    }




    // ++++++++++++++++++++++++++++++++



    public void mostrarInfoAlmacen(){
        System.out.print(toString());
    }
}
