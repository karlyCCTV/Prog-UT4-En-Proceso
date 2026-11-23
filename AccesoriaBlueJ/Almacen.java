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
    public Almacen(int numBolsos, int numSombreros, int numCinturones){
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
        if ((this.numeroBolsos + numero) > Constantes.CAPACIDAD_BOLSOS) {
            System.out.println("Se excede la capacidad máxima de bolsos");
            return false;
        }
        this.numeroBolsos += numero;
        return true;
    }
    public boolean almacenarSombreros(int numero) {
        if (this.numeroSombreros + numero > Constantes.CAPACIDAD_SOMBREROS) {
            System.out.println("Se excede la capacidad máxima de sombreros");
            return false;
        }
        this.numeroSombreros += numero;
        return true;
    }
    public boolean almacenarCinturones(int numero) {
        if (this.numeroCinturones + numero > Constantes.CAPACIDAD_CINTURONES) {
            System.out.println("Se excede la capacidad máxima de cinturones");
            return false;
        }
        this.numeroCinturones += numero;
        return true;
    }
    
    public boolean eliminarBolsos(int numero) {

        if (this.numeroBolsos < numero) {
            System.out.println("No hay existencias");
            return false;
        }
        this.numeroBolsos -= numero;
        return true;
    }
    public boolean eliminarSombreros(int numero) {
        
        if (this.numeroSombreros < numero) {
            System.out.println("No hay existencias");
            return false;
        }
        this.numeroSombreros -= numero;
        return true;
    }
    public boolean eliminarCinturones(int numero) {
        if (this.numeroCinturones < numero) {
            System.out.println("No hay existencias");
            return false;
        }
        this.numeroCinturones -= numero;
        return true;
    }
    
    public String toString() {
        String str = "**** INFORMACIÓN DEL ALMACÉN ****\n";
        str += "Número de bolsos: "+ this.numeroBolsos + "\n";
        str += "Número de sombreros: " +  this.numeroSombreros + "\n";
        str += "Número de cinturones: " + this.numeroCinturones + "\n";
        str += "*********************************";
        return str;
    }

    // ++++++++++++++++++++++++++++++++



    public void mostrarInfoAlmacen(){
        System.out.print(toString());
    }
}
