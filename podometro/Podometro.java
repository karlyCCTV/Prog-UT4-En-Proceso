import java.lang.Math;
/**
 * Write a description of class Podometro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Podometro{
    //Constantes
    private static final char HOMBRE = 'H';
    private static final char MUJER = 'M';
    private static final double ZANCADA_HOMBRE = 0.45;
    private static final double ZANCADA_MUJER = 0.41;
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;
    //Atributos
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborales;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;
    //Constructor
    public Podometro(String miMarca){
        this.marca = miMarca; //UNICO VALOR QUE NO ES POR DEFECTO
        this.altura = 0;
        this.sexo = 'M';
        this.longitudZancada = 0;
        this.totalPasosLaborales = 0;
        this.totalPasosSabado = 0;
        this.totalPasosDomingo = 0;
        this.totalDistanciaSemana = 0;
        this.totalDistanciaFinSemana = 0;
        this.tiempo = 0;
        this.caminatasNoche = 0;
    }
    //getter
    public String getMarca(){
        return this.marca;
    }
    public void configurar(double queAltura, char queSexo){
        this.altura = queAltura;
        this.sexo = queSexo;
        if (queSexo == 'M'){
            this.longitudZancada = Math.floor(queAltura * ZANCADA_MUJER);
        }else if (queSexo == 'H') {
            this.longitudZancada = Math.ceil(queAltura * ZANCADA_HOMBRE);
        }else{
            System.out.println("Sexo no aceptado");
        }
    }
    public void registrarCaminata(int pasos, int dia, int horaInicio, int horaFin) {
        switch (dia){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                this.totalPasosLaborales += pasos;
                break;
            case 6:
                this.totalPasosSabado += pasos;
                this.totalDistanciaFinSemana += (pasos * this.longitudZancada) / 100000;
                break;
            case 7:
                this.totalPasosDomingo += pasos;
                this.totalDistanciaFinSemana += (pasos * this.longitudZancada) / 100000;
            }
        //Transforma la diferencia de tiempos en formato hhmm a minutos
        //Transforma horaFin y horaInicio → los 2 primeros digitos (hh)
        //a minutos y se le suman los segundos digitos
        //Luego se resta horaInicio transformado a horaFin transformado
        this.tiempo += ((int)((horaFin/100)*60)+(horaFin%100))-((int)((horaInicio/100)*60)+(horaInicio%100));
        //es una mierda
        this.totalDistanciaSemana += (pasos * this.longitudZancada) / 100000;
        if (horaInicio > 2100) {
            this.caminatasNoche++;
        }
    }
    public void printConfiguración() {
        System.out.println("Configuración del podómetro");
        System.out.println("***************************");
        System.out.println("");
        System.out.println("Altura : " + (this.altura/100) + " mtos");
        if(this.sexo == 'M') {
            System.out.println("Sexo: MUJER");
        } else if (this.sexo == 'H') {
            System.out.println("Sexo: HOMBRE");
    }
    System.out.println("Longitud zancada : " + (this.longitudZancada)/100 + " mtos");
    }
    public void printEstadisticas() {
        System.out.println("Estadísticas");
        System.out.println("***************************");
        System.out.println();
        System.out.println("Distancia recorrida toda la semana: " + this.totalDistanciaSemana + " Km");
        System.out.println("Distancia recorrida fin de semanaa: " + this.totalDistanciaFinSemana + " Km");
        System.out.println("");
        System.out.println("");
        System.out.println("Nº pasos días laborales: " + this.totalPasosLaborales);
        System.out.println("Nº pasos SÁBADO: " + this.totalPasosSabado);
        System.out.println("Nº pasos DOMINGO: " + this.totalPasosDomingo);
        System.out.println("");
        System.out.println("");
        System.out.println("Nº caminatas realizadas a partir de las 21: " + this.caminatasNoche);
        System.out.println("");
        System.out.println("");
        System.out.println("Tiempo total caminado en la semana: " + (this.tiempo/60) + "h. y " + (this.tiempo%60) + "m.");
        System.out.println("Dias/s con más pasos caminados: " + diaMayorNumeroPasos());
    }
    public String diaMayorNumeroPasos() {
        if (totalPasosLaborales > totalPasosSabado && totalPasosLaborales > totalPasosDomingo){
            return "LABORALES";
        }else if (totalPasosSabado > totalPasosDomingo) {
            return "SÁBADO";
        }else{
            return "DOMINGO";
        } 
    }
    public void reset() {
        this.altura = 0;
        this.sexo = 'M';
        this.longitudZancada = 0;
        this.totalPasosLaborales = 0;
        this.totalPasosSabado = 0;
        this.totalPasosDomingo = 0;
        this.totalDistanciaSemana = 0;
        this.totalDistanciaFinSemana = 0;
        this.tiempo = 0;
        this.caminatasNoche = 0;
    }
}