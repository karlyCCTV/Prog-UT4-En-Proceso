
/**
 * @author - 
 * 
 * Un objeto de esta clase representa a un personaje situado en una
 * determinada coordenada en un escenario bidimensional
 * 
 * El personaje se mueve solo hacia arriba o hacia la derecha
 * 
 * Cada vez que se mueve avanza una distancia según el
 * sentido del movimiento que tenga 
 *   
 *  
 */

public class Personaje
{    
    private String nombre;   
    private Coordenada posicion;   
    private Movimiento movimiento;   

    /**
     * Constructor - crea el personaje con el nombre  indicado 
     * como parámetro.
     * La posición inicial es (0, 0) y la 
     * dirección inicial de movimiento siempre es DERECHA
     *
     */
    public Personaje(String nombre)   {
        //TODO
        this.nombre = nombre;
        this.posicion = new Coordenada(0,0);
        this.movimiento = new Movimiento();
    }

    /**
     * Constructor - crea el personaje con el nombre  indicado 
     * como parámetro. La posición inicial es la coordenada (x, y) y la 
     * dirección inicial de movimiento la que indica el parámetro
     *
     */
    public Personaje(String nombre, int x, int y, Movimiento movimiento)    {
        //TODO
        this.nombre = nombre;
        this.posicion = new Coordenada(x,y);
        this.movimiento = movimiento;
    }

    /**
     * Accesor para el nombre
     */
    public  String getNombre()   {
        return  nombre;
    }

    /**
     * Mutador para el nombre
     */
    public void setNombre(String nombre)   {
        this.nombre = nombre;
    }

    /**
     * Accesor para la posición del personaje
     */
    public Coordenada getPosicion()   {
        return  this.posicion;
    }

    /**
     * Mutador para la posición del personaje
     */
    public  void setPosicion(Coordenada posicion)   {
        this.posicion = posicion;
    }

    /**
     * Accesor para la dirección de movimiento
     * del personaje
     */
    public  Movimiento getMovimiento()   {
        return  this.movimiento;
    }

    /**
     * Mutador para cambiar la dirección de movimiento del
     * personaje
     *  
     */
    public  void cambiarMovimiento()   {
        //TODO
        movimiento.cambiarMovimiento();
    }

    /**
     *  El personaje se mueve de la siguiente manera:
     *  - si va hacia la derecha avanza tantas posiciones como indique su coordenada x
     *  - si va hacia arriba avanza solo de 2 en 2 posiciones
     *  
     *  
     *  Habrá   que   actualizar   el   estado   del   personaje
     *  adecuadamente (su posición)
     *  
     *  Muestra en pantalla un mensaje indicando la dirección de movimiento y 
     *  distancia que se va a avanzar -  
     */
    public  void mover()    {
        //TODO
        if(movimiento.esDerecha()) {
            System.out.println("Avanzando hacia la derecha " + posicion.getX() + " posiciones");
            posicion.setX(posicion.getX() * 2);
        }else {
            posicion.setY(posicion.getY() + 2);
            System.out.println("Avanzando hacia arriba 2 posiciones");
        }
    }


    /**
     * Representación textual del personaje
     * Se indica la dirección de movimiento en la que se mueve y posición actual
     * (ver resultados ejecución)
     */
    public  String toString()   {
        //TODO
        String str = "Nombre: " + this.nombre + "\n";
        str += "Movimiento: " + movimiento.toString() + "\n";
        str += "Posición: " + posicion.toString();
        return str;

    }
}
