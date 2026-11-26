
/**
 * Write a description of class Poder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Poder
{
    private String nombre;
    private String tipo;
    private int potencia;
    private int energiaConsumida;

    public Poder(String nombre, String tipo, int potencia, int energiaConsumida){
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = potencia;
        this.energiaConsumida = energiaConsumida;
    }
    
    public Poder(String nombre, String tipo, int potencia){
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = potencia;
        this.energiaConsumida = potencia / 3;
    }
    public Poder(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = 25;
        this.energiaConsumida = 8;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public int getPotencia(){
        return potencia;    
    }
    
    public int getEnergiaConsumida(){
        return energiaConsumida;    
    }
    
    public void setPotencia(int nuevaPotencia){
        potencia = nuevaPotencia;
    }
    
    public void setEnergiaConsumida(int nuevaEnergia){
        energiaConsumida = nuevaEnergia;    
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("*** " + this.nombre + " ***\n");
        str.append("Tipo: " + this.tipo + "\n");
        str.append("Potencia: " + this.potencia + "\n");
        str.append("Energia: " + this.energiaConsumida + "\n");
        return str.toString();        
    }
}