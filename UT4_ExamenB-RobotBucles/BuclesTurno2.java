import java.util.Random;
/**
 *  
 * @author - 
 *  
 */
public class BuclesTurno2
{

    /**
     * Constructor  
     */
    public BuclesTurno2()    {

    }

    
    /**
     *  Devuelve una cadena formada por n asteriscos
     *  Asumimos n positivo
     *  Hacer con for
     */
    public String generarAsteriscos(int n)   {
        //TODO
        String asteriscosPrint = "*";
        for (int i = 0; i <= n ; i++){
            asteriscosPrint = asteriscosPrint.concat("*");
        }
        return asteriscosPrint;
    }
    
    
    
    
    /**
        genera nºs aleatorios en el intervalo [min, max]  (incluidos).
        El proceso termina cuando sale el valor min o cuando se han generado un máximo de 20 valores.
        Al lado de cada nº se escribe una cadena con tantos asteriscos como indique el número de múltiplos de 3 que existan entre el min y él incluidos.
        En la tercera columna se deberá mostrar la suma de estos múltiplos de 3.
        Entre columnas se deberá tabular.
        Usa bucles while.
     */
    
    public void generarAleatorios(int min, int max)    {
        //TODO
        System.out.println("Aleatorios entre "+ min + " y " + max);
        Random rng = new Random();
        int num;
        int i = 1;
        int l;
        
        while(i <= 20) {
            num = rng.nextInt((max-min)+1)+min;
            System.out.print(num + "\t");
            l = num;
            int c = 0;
            while (l > min) {
                if (l%3==0) {
                    System.out.print("*");
                    c += l;
                }
                l--;
            }
            System.out.println("\t" + c );
            if (num == min) {
                break;
            }
            i++;
        }
    }

    
}
