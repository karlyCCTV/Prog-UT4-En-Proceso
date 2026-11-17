import java.util.Scanner;

public class Ejecucion {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Creando almacen nuevo...");
        Tienda accesoria = new Tienda(18, 32, 22);

        realizarVariasVentas(accesoria);

        int opcion = 0;
        do{
            System.out.println("********* MENÚ ACCESORIA *******");
            System.out.println("1 - Ver almacen");
            System.out.println("2 - Vender accesorios");
            System.out.println("3 - Recibir cargamento");
            System.out.println("4 - Ver facturación");
            System.out.println("5 - Ver IVA");
            System.out.println("6 - Ver datos de ventas");
            System.out.println("7 - Salir");
            System.out.println("********************************");

            opcion = teclado.nextInt();

              /* TODO **************************
            DESARROLLE A CONTINUACION LA LOGICA QUE SE PIDE
            */

            //**********************************

        }
        while (opcion != 7);
    }

        /* TODO ****************************
    DESARROLLE LOS METODOS QUE SE PIDEN
     */


    //**************************************

    private static void realizarVariasVentas(Tienda tienda){
        tienda.realizarVenta(new Accesorios(12, 22, 15));
    }

}