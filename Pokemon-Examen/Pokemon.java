import java.util.Random;
/**
 * Write a description of class Pokemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pokemon
{
    private String nombre;
    private String tipo;
    private int vida;
    private int energia;
    //EXAMEN: Sustitución de poder1, poder2 y poder3 por bolsaPoderes de la clase BolsaPoderes
    /*
    private Poder poder1;
    private Poder poder2;
    private Poder poder3;
    */
    private BolsaPoderes bolsaPoderes;
    
    public Pokemon(String nombre, String tipo, int vida, int energia){
        this.nombre = nombre;
        this.tipo = tipo;
        this.energia = energia;
        this.vida = vida;
        obtenerPoderes();
    }
    
    public Pokemon(String nombre, String tipo, int vida){
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.energia = 4 * vida / 5;
        obtenerPoderes();
    }
    
    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = 100;
        this.energia = 80;        
        obtenerPoderes();
    }
    //EXAMEN: Cambiado poderN por new BolsaPoderes(Poder poder1, Poder poder2, Poder poder3)
    public void obtenerPoderes(){
        Random random = new Random();
        switch (this.tipo){
            case "Fuego":
                bolsaPoderes = new BolsaPoderes(new Poder("Llamarada", "Fuego", random.nextInt(50) + 51)
                ,new Poder("Lanzallamas", "Fuego", random.nextInt(30) + 71)
                ,new Poder("Lluvia Ígnea", "Fuego", random.nextInt(15) + 86));
                break;
            case "Agua":
                bolsaPoderes = new BolsaPoderes(new Poder("Empapar", "Agua", random.nextInt(50) + 51)
                ,new Poder("Chorro de vapor", "Agua", random.nextInt(30) + 71)
                ,new Poder("Hidrocañón", "Agua", random.nextInt(15) + 86));
                break;
            case "Tierra":
                bolsaPoderes = new BolsaPoderes(new Poder("Ataque arena", "Tierra", random.nextInt(50) + 51)
                ,new Poder("Disparo lodo", "Tierra", random.nextInt(30) + 71)
                ,new Poder("Bomba fango", "Tierra", random.nextInt(15) + 86));
                break;
            default:
                System.out.println("Error al encontrar el tipo de pokemon:");
                System.out.println("El tipo " + tipo + " no se encuentra disponible en nuestra base de datos.");
        }

    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public int getVida(){
        return vida;
    }

    public int getEnergia(){
        return energia;
    }
    //EXAMEN: Cambiado poderN por bolsaPoderes.getPoderN()
    public Poder getPoder1(){
        return bolsaPoderes.getPoder1();
    }

    public Poder getPoder2(){
        return bolsaPoderes.getPoder2();
    }

    public Poder getPoder3(){
        return bolsaPoderes.getPoder3();
    }

    /**
     * Resta vida al pokemon. La vida nunca baja de 0.
     */
    public void recibirDanio(int danio){
        vida = vida - danio;
        if (vida < 0){
            vida = 0;
        }
    }

    /**
     * Resta al pokemon la energía que consume el poder usado.
     */
    public void consumirEnergia(int cantidad){
        energia = energia - cantidad;
    }

    /**
     * Suma energía al pokemon.
     */
    public void ganarEnergia(int cantidad){
        energia = energia + cantidad;
    }

    /**
     * Devuelve true si el pokemon se ha quedado sin vida.
     */
    public boolean estaDebilitado(){
        return vida <= 0;
    }
    //EXAMEN: Metodo toString() para devolver una cadena especifica
    public String toString() {
        String str = "*** "+ nombre + " -- " + tipo + " ***\n";
        str += "Vida: " + vida + "\n";
        str += "Energía: " + energia + "\n\n";
        
        str += "Poderes de " + nombre + "\n";
        /*
         * EXAMEN:  Debido a que mostrarPoderes() de la clase Combate tiene una estructura igual a la cadena pedida
         *          he añadido los mismos checkeos para ver si el poder existe antes de mostrarlo por pantalla
         */
        if (bolsaPoderes.getPoder1() != null){
            str += bolsaPoderes.getPoder1().toString() + "\n";
        }
        if (bolsaPoderes.getPoder2() != null){
            str += bolsaPoderes.getPoder2().toString() + "\n";
        }
        if (bolsaPoderes.getPoder3() != null){
            str += bolsaPoderes.getPoder3().toString();
        }
        
        return str;
    }
}