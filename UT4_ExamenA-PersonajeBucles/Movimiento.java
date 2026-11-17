
/**
 *  Un objeto de esta clase representa 
 *  la dirección de movimiento de un personaje
 *   
 */
public class Movimiento
{

    private final int DERECHA = 1;  
    private final int ARRIBA = 2;  
    private int movimiento; 

    /**
     * Constructor  
     */
    public Movimiento()    {
        this.movimiento = DERECHA;

    }

    /**
     * Constructor  
     */
    public Movimiento(int movimiento)   {
        this.movimiento = movimiento;

    }


    /**
     *  accesor para la dirección de movimiento
     */
    public int getMovimiento()   {
        return this.movimiento;
    }

    /**
     *  devuelve true si la dirección es DERECHA, false en otro caso
     */
    public boolean esDerecha()   {
        return this.movimiento == DERECHA;
    }

    /**
     * Mutador para la dirección de movimiento
     * 
     */
    public  void cambiarMovimiento()   {
        if (this.movimiento == DERECHA)  {
            this.movimiento = ARRIBA;
        }
        else   {
            this.movimiento = DERECHA;
        }
    }

    /**
     * Representación textual del movimiento
     *  
     */
    public  String toString()
    {
        String strDireccion = "Hacia ";
        if (this.movimiento == DERECHA)  {
            strDireccion += "la DERECHA";
        }
        else   {
            strDireccion += "ARRIBA";
        }
        return  strDireccion ;
    }
}
