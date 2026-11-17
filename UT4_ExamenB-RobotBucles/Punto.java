/**
 * Representa a un punto 
 * en el espacio bidimensional
 * 
 */
public class Punto 
{
    private int x;
    private int y;

    /**
     * Constructor de la clase Punto
     */
    public Punto(int x, int y)   {
        this.x = x;
        this.y = y;
    }

    /**
     * Accesor para el atributo x
     *  
     */
    public int getX()  {
        return x;
    }

    /**
     * Accesor para el atributo y
     *  
     */
    public int getY()   {
        return y;
    }

    /**
     * 
     *  Mutador para la coordenada x
     *  
     */
    public void setX(int x)  {
        this.x = x;
    }

    /**
     * Mutador para la coordenada y
     *  
     */
    public void setY(int y)   {
        this.y = y;
    }

  
    /**
     * Devuelve una cadena con la representación del 
     *          punto
     */
    public String toString()    {
        return "[" + x + " , " + y + "]";

    }

}