
/**
 * @author - 
 * 
 * Un objeto de esta clase representa a un robot situado en una
 * determinada posición en un espacio bidimensional
 * 
 * El robot se mueve solo en vertical  
 * 
 * Cada vez que se mueve avanza una distancia según la
 * dirección que tenga 
 *   
 *  
 */

public class Robot
{    
    private String nombre;  // nombre del robot
    private Punto posicion;  // posición del robot en el escenario   
    private Direccion direccion;  // dirección actual de movimiento del robot

    /**
     * Constructor - crea el robot con el nombre  indicado 
     * como parámetro.
     * La posición inicial es (0, 0) y la 
     * dirección inicial siempre es NORTE
     *
     */
    public Robot(String nombre)   {
        this.nombre = nombre;
        this.posicion = new Punto(0,0);
        this.direccion = new Direccion();
    }

    /**
     * Constructor - crea el robot con el nombre  indicado 
     * como parámetro. La posición inicial es (x, y) y la 
     * dirección inicial la que indica el parámetro
     *
     */
    public Robot(String nombre, int x, int y, Direccion direccion)    {
        //TODO
        this.nombre = nombre;
        this.posicion = new Punto(x,y);
        this.direccion = direccion;
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
     * Accesor para la posición del robot
     */
    public Punto getPosicion()   {
        return  posicion;
    }

    /**
     * Mutador para la posición del robot
     */
    public  void setPosicion(Punto posicion)   {
        this.posicion = posicion;
    }

    /**
     * Accesor para la dirección
     */
    public  Direccion getDireccion()   {
        return  direccion;
    }

    /**
     * Mutador para la dirección
     * Cambia la dirección de movimiento del robot
     *  
     */
    public  void cambiarDireccion()   {
        //TODO
        getDireccion().cambiarDireccion();
    }

    /**
     *  El robot se mueve avanzando la distancia indicada
     *  
     *  Habrá   que   actualizar   el   estado   del   robot
     *  adecuadamente (su posición)
     *  
     *  Muestra en pantalla un mensaje indicando la dirección y 
     *  distancia que se va a avanzar -  
     */
    public void mover(int distancia)
    {
        //TODO
        int direccionChange;
        String direccionPrint;
        if (getDireccion().esNorte()){
            direccionChange = 1;
            direccionPrint = "norte";
        }else {
            direccionChange = -1;
            direccionPrint = "sur";
        }
        getPosicion().setY(getPosicion().getY() + (direccionChange*distancia));
        System.out.println("Avanzando hacia el " + direccionPrint + " " + distancia);
    }

    /**<
     *   Devuelve un robot nuevo, réplica del actual
     *   (mismo nombre, posición y dirección)
     */
    public Robot obtenerReplica() {
        //TODO
     Robot replica = new Robot(nombre,posicion.getX(),posicion.getY(),direccion);
     return replica;
    }

    /**
     * Representación textual del robot
     * Se indica la dirección en la que se mueve y posición actual
     * (ver resultados ejecución)
     */
    public  String toString()   {
        //TODO
        return "Nombre: " + getNombre() + System.lineSeparator() +"Direccion: "+ getDireccion().toString() + System.lineSeparator() + "Posición: " + getPosicion().toString();

    }
}
