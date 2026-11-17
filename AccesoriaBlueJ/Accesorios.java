public class Accesorios {
    private int numBolsos;
    private int numCinturones;
    private int numSombreros;

    public Accesorios(int numBolsos, int numSombreros, int numCinturones){
        this.numBolsos = numBolsos;
        this.numSombreros = numSombreros;
        this.numCinturones = numCinturones;
    }

    public int getNumBolsos() {
        return numBolsos;
    }

    public int getNumCinturones() {
        return numCinturones;
    }

    public int getNumSombreros() {
        return numSombreros;
    }
}
