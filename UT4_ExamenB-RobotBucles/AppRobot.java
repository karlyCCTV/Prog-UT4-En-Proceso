
/**
 *  
 * Punto de entrada a la aplicación
 * 
 * @author -  
 */
public class AppRobot
{

    /**
     *      • crea un robot de nombre “R2D2·, posición inicial (50,50) y dirección sur.
     *      • muestra el estado del robot
     *      • mueve el robot una distancia de 12
     *      • mueve el robot una distancia de 10
     *      • cambia la dirección del robot
     *      • mueve el robot una distancia de 7, 2 y 3
     *      • muestra el estado final del robot
     *      • crea una réplica del robot y muéstrala
     */
    public static void main(String[] args)
    {
         //TODO
         
         BuclesTurno2 bucle = new BuclesTurno2();
         bucle.generarAleatorios(13,33);    
         /*
          * System.out.println("Antes de empezar a moverse");
         System.out.println("");
         //crea un robot de nombre “R2D2·, posición inicial (50,50) y dirección sur
         Direccion direccion = new Direccion(2);
         Robot R2D2 = new Robot("R2D2",50,50,direccion);
         //muestra el estado del robot
         System.out.println(R2D2.toString());
         System.out.println("");
         //mueve el robot una distancia de 12
         //mueve el robot una distancia de 10
         R2D2.mover(12);
         R2D2.mover(10);
         //cambia la dirección del robot
         R2D2.cambiarDireccion();
         //mueve el robot una distancia de 7, 2 y 3
         R2D2.mover(7);
         R2D2.mover(2);
         R2D2.mover(3);
         System.out.println("");
         System.out.println("Situación final");
         //muestra el estado final del robot
         System.out.println(R2D2.toString());
         System.out.println("");
         System.out.println("");
         System.out.println("Réplica del robot");
         //crea una réplica del robot y muéstrala
         System.out.println(R2D2.obtenerReplica().toString());
        */
    }
}
