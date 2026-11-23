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
 * Consejo: implementa los métodos en el orden en que aparecen, de los más
 * sencillos a los más complejos.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Combate{
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon ganador;
    private String turno;
    private Random random;
    private Scanner teclado;

    /**
     * Constructor: recibe los dos pokemon que se van a enfrentar.
     */
    public Combate(Pokemon pokemon1, Pokemon pokemon2){
        // TODO: guarda los dos pokemon en sus atributos.
        // TODO: deja el ganador a null.
        // TODO: crea el objeto Random y el objeto Scanner (new Scanner(System.in)).
        // TODO: sortea quién empieza y guarda su NOMBRE en el atributo turno.
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.ganador = null;
        this.random = new Random();
        this.teclado = new Scanner(System.in);
        if(random.nextInt(2) == 0) {
            this.turno = pokemon1.getNombre();
        }else{
            this.turno = pokemon2.getNombre();
        }
    }
    
    public String getTurno(){
        // TODO: devuelve el nombre del pokemon que tiene el turno.
        return this.turno;
    }

    public Pokemon getGanador(){
        // TODO: devuelve el ganador (o null si aún no hay).
        return this.ganador;
    }

    /**
     * Devuelve el pokemon que tiene el turno.
     */
    public Pokemon getPokemonConTurno(){
        // TODO: si turno es igual al nombre de pokemon1, devuelve pokemon1.
        //       Si no, devuelve pokemon2.
        //       Recuerda: los String se comparan con equals, nunca con ==.
        if (this.turno.equals(pokemon1.getNombre())){
            return pokemon1;
        }
        return pokemon2;
    }

    /**
     * Devuelve el pokemon que NO tiene el turno.
     */
    public Pokemon getPokemonSinTurno(){
        // TODO: devuelve el otro pokemon (el contrario que getPokemonConTurno).
        if (this.turno.equals(pokemon2.getNombre())){
            return pokemon1;
        }
        return pokemon2;
    }

    /**
     * Pasa el turno al otro pokemon.
     */
    public void cambiarTurno(){
        // TODO: si el turno es de pokemon1, pásalo a pokemon2, y al revés.
        if(getPokemonConTurno()==pokemon1){
        this.turno = pokemon2.getNombre();
        }else{
            this.turno = pokemon1.getNombre();
        }
    }

    /**
     * Espera a que el usuario pulse intro para continuar.
     */
    public void esperarIntro(){
        System.out.println("(Pulsa intro para continuar)");
        teclado.nextLine();
    }
    
    /**
     * Muestra la vida y la energía de los dos pokemon.
     */
    public void mostrarEstado(){
        // TODO: muestra una línea por pokemon con este formato:
        //          Squirtle -> Vida: 100 | Energía: 80
        System.out.println(pokemon1.getNombre() + " -> Vida: " + pokemon1.getVida() + " | Energía: " + pokemon1.getEnergia());
        System.out.println(pokemon2.getNombre() + " -> Vida: " + pokemon2.getVida() + " | Energía: " + pokemon2.getEnergia());
    }
    
    /**
     * Devuelve el modificador de potencia según el tipo del atacante y el
     * tipo del defensor.
     */
    public double calcularModificador(String tipoAtacante, String tipoDefensor){
        // TODO: devuelve el modificador según esta tabla:
        //
        //       Atacante \ Defensor |  Agua  | Fuego  | Tierra
        //       --------------------+--------+--------+--------
        //       Agua                |  0.5   |  2.0   |  2.0
        //       Fuego               |  0.5   |  0.5   |  1.0
        //       Tierra              |  1.0   |  2.0   |  1.0
        //
        //       Pista: usa un switch sobre tipoAtacante y, dentro, if con tipoDefensor.
        switch(tipoAtacante) {
            case "Agua":
                if (tipoDefensor.equals("Agua")) {
                    return 0.5;
                }
                return 2;
            case "Fuego":
                if (tipoDefensor.equals("Tierra")) {
                    return 1;
                }
                return 0.5;
            case "Tierra":
                if (tipoDefensor.equals("Fuego")) {
                    return 2.0;
                }
                return 1;
            default:
                System.out.println("Tipo no valido");
        }
        return 1;
    }
    
    /**
     * Muestra por consola un mensaje según la efectividad del ataque.
     */
    public void mostrarEfectividad(double modificador){
        // TODO: si el modificador es mayor que 1, muestra "¡Es muy eficaz! (x2.0)".
        // TODO: si es menor que 1, muestra "No es muy eficaz... (x0.5)".
        // TODO: si es 1, no muestres nada.
        if((int)modificador == 1) {
            return;
        }
        if(modificador > 1){
            System.out.println("¡Es muy eficaz!");
        }else{
            System.out.println("No es muy eficaz...");
        }
    }
    
    /**
     * Indica si el pokemon tiene energía suficiente para usar el poder.
     */
    public boolean puedeUsar(Pokemon pokemon, Poder poder){
        // TODO: devuelve true si el poder NO es null y la energía del pokemon es
        //       mayor o igual que la energía que consume el poder.
        return poder!=null&&pokemon.getEnergia() >= poder.getEnergiaConsumida();
    }
    
    /**
     * Elige al azar uno de los poderes que el pokemon puede usar con su energía.
     * Devuelve null si no puede usar ninguno.
     */
    public Poder elegirPoder(Pokemon pokemon){
        // TODO: declara tres variables Poder (disponible1, disponible2, disponible3)
        //       iniciadas a null y un contador int cantidad = 0.
        //       Recuerda: NO se pueden usar arrays. Aún no los hemos enseñado.
        // TODO: revisa los tres poderes del pokemon con puedeUsar. Cada poder que se
        //       pueda usar guárdalo en el primer hueco libre y suma 1 a cantidad.
        // TODO: si cantidad es 0, devuelve null.
        // TODO: sortea un número con random.nextInt(cantidad) y devuelve
        //       disponible1 si sale 0, disponible2 si sale 1 o disponible3 si sale 2.
        Poder disponible1 = null;
        Poder disponible2 = null;
        Poder disponible3 = null;
        int cantidad = 0;
        if (puedeUsar(pokemon,pokemon.getPoder1())) {
            disponible1 = pokemon.getPoder1();
            cantidad++;
        }
        
        if (puedeUsar(pokemon,pokemon.getPoder2())) {
            if (disponible1 != null) {
                disponible1 = pokemon.getPoder2();
            }else {
                disponible2 = pokemon.getPoder2();
            }
            cantidad++;
        }
        
        if (puedeUsar(pokemon,pokemon.getPoder3())) {
            if (disponible1 != null) {
                disponible1 = pokemon.getPoder3();
            } else if (disponible2 != null) {
                disponible2 = pokemon.getPoder3();
            } else {
                disponible3 = pokemon.getPoder3();
            }
            cantidad++;
        }
        if (cantidad==0){
            return null;
        }
        switch(random.nextInt(cantidad)) {
            case 0:
                return disponible1;
            case 1:
                return disponible2;
            case 2:
                return disponible3;
        }
        return null;
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
     * Juega el turno del pokemon que tiene el turno: ataca a su contrincante.
     * Al final, el turno pasa al otro pokemon.
     */
    public void jugarTurno(){
        // TODO: obtén el atacante (getPokemonConTurno) y el defensor (getPokemonSinTurno).
        // TODO: muestra "Turno de ..." con el nombre del atacante.
        // TODO: llama a atacar y después a mostrarEstado.
        // TODO: si el defensor está debilitado, muestra que se ha quedado sin vida
        //       y guarda al atacante como ganador.
        // TODO: llama a esperarIntro y después a cambiarTurno.
        Pokemon atacante = getPokemonConTurno();
        Pokemon defensor = getPokemonSinTurno();
        System.out.println("Turno de " + atacante.getNombre());
        atacar(atacante,defensor);
        mostrarEstado();
        if(defensor.estaDebilitado()){
            this.ganador = atacante;
            System.out.println(defensor.getNombre() + " se ha quedado sin vida");
        }
        esperarIntro();
        cambiarTurno();
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
    
    public void mostrarPoderes(Pokemon pokemon){
       /* TODO: Muestra por consola los poderes del pokemon. 
        * Pista: Usar toString() de Poder. 
           Se deberá tener en cuenta si alguno/s de los 
           poderes del pokemon es vacío (nulo)
        */
       
    }
}

