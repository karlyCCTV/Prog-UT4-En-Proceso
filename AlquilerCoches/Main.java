public class Main
{
    public static void main(String[] args) {
        Cliente cliente = new Cliente("energerildo","67U");
        cliente.alquilarCoche(67);
        System.out.println(cliente.calcularMulta(2));
    }
}