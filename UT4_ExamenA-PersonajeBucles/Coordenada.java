/**
 * Representa a una coordenada
 * en el espacio bidimensional
 * 
 */
public class Coordenada 
{
    private int x;
    private int y;

    /**
     * Constructor de la clase Coordenada
     */
    public Coordenada(int x, int y)   {
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
     *  Mutador para el valor de x
     *  
     */
    public void setX(int x)  {
        this.x = x;
    }

    /**
     * Mutador para el valor de y y
     *  
     */
    public void setY(int y)   {
        this.y = y;
    }

  
    /**
     * Devuelve una cadena con la representación de
     * la coordenada
     */
    public String toString()    {
        return "[" + x + " , " + y + "]";

    }

}