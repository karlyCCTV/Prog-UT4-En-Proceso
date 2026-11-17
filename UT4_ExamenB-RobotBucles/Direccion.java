
/**
 *  Un objeto de esta clase representa 
 *  la dirección de movimiento de un robot
 *   
 */
public class Direccion
{

    private final int NORTE = 1;  
    private final int SUR = 2;  
    private int direccion; 

    /**
     * Constructor  
     */
    public Direccion()    {
        direccion = NORTE;

    }

    /**
     * Constructor  
     */
    public Direccion(int direccion)   {
        this.direccion = direccion;

    }


    /**
     *  accesor para la direccion
     */
    public int getDireccion()   {
        return direccion;
    }

    /**
     *  devuelve true si la dirección es NORTE, false en otro caso
     */
    public boolean esNorte()   {
        return direccion == NORTE;
    }

    /**
     * Mutador para la dirección
     * Cambia la dirección 
     *  
     *  
     */
    public  void cambiarDireccion()   {
        if (direccion == NORTE)  {
            direccion = SUR;
        }
        else   {
            direccion = NORTE;
        }
    }

    /**
     * Representación textual de la dirección
     *  
     */
    public  String toString()
    {
        String strDireccion = "Dirección: ";
        if (direccion == NORTE)  {
            strDireccion = "NORTE";
        }
        else   {
            strDireccion = "SUR";
        }
        return  strDireccion ;
    }
}
