public class Cliente
{
    //atributos
    private final int TARIFADIARIA = 40;
    
    private String nombre;
    private String dni;
    private boolean cocheAlquilado;
    private int diasAlquiler;
    private int pendientePago;
    
    //constructor
    public Cliente(String miNombre, String miDni) {
        this.nombre = miNombre;
        this.dni = miDni;
        cocheAlquilado = false;
        diasAlquiler = 0;
        pendientePago = 0;
    }
    //setters
    public void setCocheAlquilado(boolean value) {
        this.cocheAlquilado = value;
    }
    public void setDiasAlquiler(int value) {
        this.diasAlquiler = value;
    }
    public void setPendientePago(int value) {
        this.pendientePago = value;
    }
    //getters
    public String getNombre() {
        return this.nombre;
    }
    public String getDni() {
        return this.dni;
    }
    public boolean getCocheAlquilado() {
        return this.cocheAlquilado;
    }
    public int getDiasAlquiler() {
        return this.diasAlquiler;
    }
    public int getPendientePago() {
        return this.pendientePago;
    }
    public int getTarifaDiaria() {
        return this.TARIFADIARIA;
    }
    //funciones
    public void alquilarCoche(int dias) {
        if (this.cocheAlquilado) {
            System.out.println("Error: Ya tiene un coche alquilado");
            return;
        }
        if (this.pendientePago > 0) {
            System.out.println("Error: Aun hay pagos pendientes");
            return;
        }
        setDiasAlquiler(dias);
        setPendientePago(dias*getTarifaDiaria());
        setCocheAlquilado(true);
    }
    public int calcularMulta(int diasRetraso) {
        return (diasRetraso +1) /2 * 100;
        /*if (diasRetraso == 0) {
            return 0;
        }
        double multa;
        if (diasRetraso%2==0){
            multa = (diasRetraso/2) * 100;
        }else {
            multa = ((diasRetraso+1)/2) * 100;
        }
        if (multa > 500) {
            multa = 500;
        }
        return multa;
        */
    }
    public void devolverCoche(int diasRetraso) {
        setCocheAlquilado(false);
        setDiasAlquiler(0);
        setPendientePago(getPendientePago() + (int)calcularMulta(diasRetraso));
    }
    public void mostrarPagosPendientes() {
        System.out.println("---------------------");
        System.out.println("PAGOS PENDIENTES");
        System.out.println("*********************");
        System.out.println("Cliente: " + getDni());
        System.out.println("Pagos pendientes: " + getPendientePago() + "€");
        System.out.println("*********************");
    }
    public void consultarEstadoAlquiler() {
        System.out.println("---------------------");
        System.out.println("ESTADO DEL ALQUILER");
        System.out.println("*********************");
        System.out.println("Estado: " + getCocheAlquilado());
        System.out.println("Dias alquilados: " + getDiasAlquiler());
        System.out.println("*********************");
    }
    public void pagarFactura() {
        setPendientePago(0); //pendientePago = 0;
    }
}