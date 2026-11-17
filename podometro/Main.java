
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        Podometro uno = new Podometro("Ding");
        uno.configurar(167,'M');
        uno.registrarCaminata(2000,3,1714,1815);
        uno.printEstadisticas();
    }
}