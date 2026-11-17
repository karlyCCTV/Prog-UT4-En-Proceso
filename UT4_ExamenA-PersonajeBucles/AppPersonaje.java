
/**
 *  Punto de entrada a la aplicación
 * 
 * @author - 
 *  
 */
public class AppPersonaje
{

    /**
     *      • crea un Personaje de nombre “Super Mario·, posición inicial (15,40) y movimiento hacia arriba.
     *      • muestra el estado del personaje
     *      • mueve el personaje 2 veces 
     *      • muestra el estado del personaje
     *      • cambia la dirección de movimiento del personaje
     *      • mueve el personaje otras 2 veces  
     *      • muestra el estado del personaje
     *      •  
     *      • crea una copia del personaje actual y muéstrala
     */
    public static void main(String[] args)
    {
        //TODO
        Movimiento movimiento = new Movimiento(2);
        Personaje supermario = new Personaje("Super Mario",15,40,movimiento);
        System.out.println("Antes de empezar a moverse");
        System.out.println("");
        
        System.out.println(supermario.toString());
        System.out.println("");
        
        supermario.mover();
        supermario.mover();
        System.out.println(supermario.toString());
        System.out.println("");
        
        supermario.cambiarMovimiento();
        supermario.mover();
        supermario.mover();
        System.out.println(supermario.toString());
    }
}
