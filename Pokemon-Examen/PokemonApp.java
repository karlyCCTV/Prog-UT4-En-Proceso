/**
 * Clase principal de la aplicación. Crea dos pokemon, un combate entre
 * ellos y lo comienza.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PokemonApp
{
    public static void main(String[] args){
        Pokemon pokemon1 = new Pokemon("Squirtle", "Agua");
        Pokemon pokemon2 = new Pokemon("Charmander", "Fuego");

        Combate combate = new Combate(pokemon1, pokemon2);
        combate.comenzar();
    }
}
