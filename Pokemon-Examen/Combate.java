import java.util.Random;
import java.util.Scanner;
/**
 * Clase Combate: enfrenta a dos pokemon por rondas hasta que uno de ellos
 * se queda sin vida.
 *
 * En cada ronda ataca primero el pokemon que tiene el turno y después el otro.
 * El daño es la potencia del poder del atacante (con el modificador de tipo)
 * menos la potencia del poder con el que se defiende el defensor.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Combate
{
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon ganador;
    private String turno;
    private Random random;
    private Scanner teclado;

    public Combate(Pokemon pokemon1, Pokemon pokemon2){
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.ganador = null;
        this.random = new Random();
        this.teclado = new Scanner(System.in);
        // Se sortea quién empieza
        if (random.nextInt(2) == 0){
            this.turno = pokemon1.getNombre();
        } else {
            this.turno = pokemon2.getNombre();
        }
    }
    //EXAMEN: Segundo constructor con parametros diferentes
    public Combate(String nombrePokemon1,String nombrePokemon2,String tipoPokemon1,String tipoPokemon2,int vidaPokemon1,int vidaPokemon2) {
        //EXAMEN: Parametros definen pokemon1 y pokemon2
        this.pokemon1 = new Pokemon(nombrePokemon1, tipoPokemon1, vidaPokemon1);
        this.pokemon2 = new Pokemon(nombrePokemon2, tipoPokemon2, vidaPokemon2);
        //EXAMEN: Los demas atributos son iguales
        this.ganador = null;
        this.random = new Random();
        this.teclado = new Scanner(System.in);
        // Se sortea quién empieza
        if (random.nextInt(2) == 0){
            this.turno = pokemon1.getNombre();
        } else {
            this.turno = pokemon2.getNombre();
        } 
    }

    /**
     * Comienza el combate. Se juegan rondas hasta que haya un ganador.
     * Cada evento avanza al pulsar intro.
     */
    public void comenzar(){
        System.out.println("¡Comienza el combate entre " + pokemon1.getNombre()
            + " (" + pokemon1.getTipo() + ") y " + pokemon2.getNombre()
            + " (" + pokemon2.getTipo() + ")!");
        mostrarEstado();
        mostrarPoderes(pokemon1);
        mostrarPoderes(pokemon2);
        System.out.println("Empieza " + turno + ".");
        esperarIntro();

        int ronda = 1;
        while (ganador == null){
            System.out.println("========== RONDA " + ronda + " ==========");
            // Primer turno de la ronda
            jugarTurno();
            // Segundo turno de la ronda (si nadie ha ganado todavía)
            if (ganador == null){
                jugarTurno();
            }
            ronda++;
        }

        System.out.println("**********************************");
        System.out.println("¡" + ganador.getNombre() + " gana el combate!");
        System.out.println("**********************************");
    }

    /**
     * Juega el turno del pokemon que tiene el turno: ataca a su contrincante.
     * Al final, el turno pasa al otro pokemon.
     */
    public void jugarTurno(){
        Pokemon atacante = getPokemonConTurno();
        Pokemon defensor = getPokemonSinTurno();

        System.out.println("Turno de " + atacante.getNombre() + ".");
        atacar(atacante, defensor);
        mostrarEstado();

        if (defensor.estaDebilitado()){
            System.out.println(defensor.getNombre() + " se ha quedado sin vida.");
            ganador = atacante;
        }
        esperarIntro();
        cambiarTurno();
    }

    /**
     * El atacante ataca al defensor con un poder elegido al azar entre los que
     * puede pagar con su energía. El defensor se defiende igual.
     */
    public void atacar(Pokemon atacante, Pokemon defensor){
        Poder poderAtaque = elegirPoder(atacante);

        // Si no puede usar ningún poder, pasa el turno y gana energía
        if (poderAtaque == null){
            int energiaGanada = random.nextInt(21) + 15; // entre 15 y 35
            atacante.ganarEnergia(energiaGanada);
            System.out.println(atacante.getNombre() + " no tiene energía suficiente para ningún poder.");
            System.out.println(atacante.getNombre() + " pasa el turno y recupera " + energiaGanada + " de energía.");
            return;
        }

        atacante.consumirEnergia(poderAtaque.getEnergiaConsumida());
        double modificador = calcularModificador(atacante.getTipo(), defensor.getTipo());
        int potenciaAtaque = (int) (poderAtaque.getPotencia() * modificador);

        System.out.println(atacante.getNombre() + " usa " + poderAtaque.getNombre()
            + " (potencia " + poderAtaque.getPotencia() + ", gasta "
            + poderAtaque.getEnergiaConsumida() + " de energía).");
        mostrarEfectividad(modificador);
        if (modificador != 1.0){
            System.out.println("Potencia final del ataque: " + potenciaAtaque + ".");
        }

        // El defensor intenta defenderse con uno de sus poderes
        int potenciaDefensa = 0;
        Poder poderDefensa = elegirPoder(defensor);
        if (poderDefensa == null){
            System.out.println(defensor.getNombre() + " no tiene energía para defenderse.");
        } else {
            defensor.consumirEnergia(poderDefensa.getEnergiaConsumida());
            potenciaDefensa = poderDefensa.getPotencia();
            System.out.println(defensor.getNombre() + " se defiende con " + poderDefensa.getNombre()
                + " (potencia " + potenciaDefensa + ", gasta "
                + poderDefensa.getEnergiaConsumida() + " de energía).");
        }

        // Cálculo del daño: solo si la diferencia es mayor que cero
        int danio = potenciaAtaque - potenciaDefensa;
        if (danio > 0){
            defensor.recibirDanio(danio);
            System.out.println(defensor.getNombre() + " recibe " + danio + " puntos de daño.");
        } else {
            System.out.println("¡" + defensor.getNombre() + " bloquea el ataque y no recibe daño!");
        }
    }
    

    /**
     * Elige al azar uno de los poderes que el pokemon puede usar con su energía.
     * Devuelve null si no puede usar ninguno.
     */
    public Poder elegirPoder(Pokemon pokemon){
        // Guardamos en orden los poderes que puede usar (como máximo 3)
        Poder disponible1 = null;
        Poder disponible2 = null;
        Poder disponible3 = null;
        int cantidad = 0;

        if (puedeUsar(pokemon, pokemon.getPoder1())){
            disponible1 = pokemon.getPoder1();
            cantidad++;
        }
        if (puedeUsar(pokemon, pokemon.getPoder2())){
            if (cantidad == 0){
                disponible1 = pokemon.getPoder2();
            } else {
                disponible2 = pokemon.getPoder2();
            }
            cantidad++;
        }
        if (puedeUsar(pokemon, pokemon.getPoder3())){
            if (cantidad == 0){
                disponible1 = pokemon.getPoder3();
            } else if (cantidad == 1){
                disponible2 = pokemon.getPoder3();
            } else {
                disponible3 = pokemon.getPoder3();
            }
            cantidad++;
        }

        if (cantidad == 0){
            return null;
        }

        // Elegimos al azar uno de los poderes disponibles
        int elegido = random.nextInt(cantidad);
        if (elegido == 0){
            return disponible1;
        } else if (elegido == 1){
            return disponible2;
        } else {
            return disponible3;
        }
    }

    /**
     * Indica si el pokemon tiene energía suficiente para usar el poder.
     */
    public boolean puedeUsar(Pokemon pokemon, Poder poder){
        return poder != null && pokemon.getEnergia() >= poder.getEnergiaConsumida();
    }

    /**
     * Modificador de potencia según la tabla de tipos de Pokémon
     * (solo Agua, Fuego y Tierra):
     *   - Agua contra Fuego o Tierra: x2 (muy eficaz)
     *   - Agua contra Agua: x0.5 (poco eficaz)
     *   - Fuego contra Agua o Fuego: x0.5 (poco eficaz)
     *   - Fuego contra Tierra: x1
     *   - Tierra contra Fuego: x2 (muy eficaz)
     *   - Tierra contra Agua o Tierra: x1
     */
    public double calcularModificador(String tipoAtacante, String tipoDefensor){
        switch (tipoAtacante){
            case "Agua":
                if (tipoDefensor.equals("Fuego") || tipoDefensor.equals("Tierra")){
                    return 2.0;
                }
                if (tipoDefensor.equals("Agua")){
                    return 0.5;
                }
                break;
            case "Fuego":
                if (tipoDefensor.equals("Agua") || tipoDefensor.equals("Fuego")){
                    return 0.5;
                }
                break;
            case "Tierra":
                if (tipoDefensor.equals("Fuego")){
                    return 2.0;
                }
                break;
        }
        return 1.0;
    }

    /**
     * Muestra por consola un mensaje según la efectividad del ataque.
     */
    public void mostrarEfectividad(double modificador){
        if (modificador > 1.0){
            System.out.println("¡Es muy eficaz! (x" + modificador + ")");
        } else if (modificador < 1.0){
            System.out.println("No es muy eficaz... (x" + modificador + ")");
        }
    }

    /**
     * Muestra la vida y la energía de los dos pokemon.
     */
    public void mostrarEstado(){
        System.out.println("   " + pokemon1.getNombre() + " -> Vida: " + pokemon1.getVida()
            + " | Energía: " + pokemon1.getEnergia());
        System.out.println("   " + pokemon2.getNombre() + " -> Vida: " + pokemon2.getVida()
            + " | Energía: " + pokemon2.getEnergia());
    }

    /**
     * Espera a que el usuario pulse intro para continuar.
     */
    public void esperarIntro(){
        System.out.println("(Pulsa intro para continuar)");
        teclado.nextLine();
    }

    /**
     * Pasa el turno al otro pokemon.
     */
    public void cambiarTurno(){
        if (turno.equals(pokemon1.getNombre())){
            turno = pokemon2.getNombre();
        } else {
            turno = pokemon1.getNombre();
        }
    }

    public Pokemon getPokemonConTurno(){
        if (turno.equals(pokemon1.getNombre())){
            return pokemon1;
        }
        return pokemon2;
    }

    public Pokemon getPokemonSinTurno(){
        if (turno.equals(pokemon1.getNombre())){
            return pokemon2;
        }
        return pokemon1;
    }

    public String getTurno(){
        return turno;
    }

    public Pokemon getGanador(){
        return ganador;
    }
    
    public void mostrarPoderes(Pokemon pokemon){
        System.out.println("Poderes de " + pokemon.getNombre());
        if (pokemon.getPoder1() != null){
            System.out.println(pokemon.getPoder1().toString());
        }
        if (pokemon.getPoder2() != null){
            System.out.println(pokemon.getPoder2().toString());
        }
        if (pokemon.getPoder3() != null){
            System.out.println(pokemon.getPoder3().toString());
        }
    }
}
