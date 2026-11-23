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
            switch(opcion) {
                case 1:
                    verAlmacen(accesoria);
                    break;
                case 2:
                    venderAccesorios(accesoria);
                    break;
                case 3:
                    recibirCargamento(accesoria);
                    break;
                case 4:
                    verFacturacion(accesoria);
                    break;
                case 5:
                    verIVA(accesoria);
                    break;
                case 6:
                    verDatosVentas(accesoria);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    break;
            }
            //**********************************

        }
        while (opcion != 7);
    }

        /* TODO ****************************
    DESARROLLE LOS METODOS QUE SE PIDEN
     */
    //1
    private static void verAlmacen(Tienda tienda) {
        tienda.getAlmacen().mostrarInfoAlmacen();
    }
    //2
    private static void venderAccesorios(Tienda tienda) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de bolsos a vender");
        int bolsos = teclado.nextInt();
        System.out.println("Introduce el número de sombreros a vender");
        int sombreros = teclado.nextInt();
        System.out.println("Introduce el número de cinturones a vender");
        int cinturones = teclado.nextInt();
        
        tienda.realizarVenta(new Accesorios(bolsos,sombreros,cinturones));
    }
    //3
    private static void recibirCargamento(Tienda tienda) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de bolsos a cargar en el almacén");
        int bolsos = teclado.nextInt();
        System.out.println("Introduce el número de sombreros a cargar en el almacén");
        int sombreros = teclado.nextInt();
        System.out.println("Introduce el número de cinturones a cargar en el almacén");
        int cinturones = teclado.nextInt();
        
        tienda.cargarAccesorios(new Accesorios(bolsos,sombreros,cinturones));
    }
    //4
    private static void verFacturacion(Tienda tienda) {
        System.out.println("Facturación de la tienda: " + tienda.getCaja().getFacturacion() + "€");
    }
    //5
    private static void verIVA(Tienda tienda) {
        System.out.println("IVA generado en la tienda: " + tienda.getCaja().obtenerIVAAcumulado() + "€");
    }
    //6
    private static void verDatosVentas(Tienda tienda) {
        String str = "++++ DATOS DE VENTAS ++++\n";
        str += "Bolsos vendidos: " + tienda.getCaja().getNumeroBolsosVendidos() + "\n";
        str += "Sombreros vendidos: " + tienda.getCaja().getNumeroSombrerosVendidos() + "\n";
        str += "Cinturones vendidos: " + tienda.getCaja().getNumeroCinturonesVendidos() + "\n";
        str += "++++++++++++++++++++++++";
        System.out.println(str);
    }    
    


    //**************************************

    private static void realizarVariasVentas(Tienda tienda){
        tienda.realizarVenta(new Accesorios(12, 22, 15));
    }

}