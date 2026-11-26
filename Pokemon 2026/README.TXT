------------------------------------------------------------------------
Este es el fichero README del proyecto. Aquí se describe el proyecto
para que cualquier persona que no lo conozca sepa de qué trata y cómo
utilizarlo.
------------------------------------------------------------------------

PROJECT TITLE: Combate Pokémon

PURPOSE OF PROJECT:
Practicar la programación orientada a objetos en Java: clases, atributos,
constructores, métodos, relaciones entre clases (un Pokemon tiene Poderes,
un Combate tiene Pokemons), condicionales, bucles y el uso de las clases
Random y Scanner del paquete java.util.

IPJADSJFOASIJDFAOSDIFASDF

El proyecto simula un combate por turnos entre dos pokemon. Tiene cuatro clases:

  - PokemonApp: clase principal con el método main. Crea dos pokemon y un
    combate entre ellos, y lo comienza.

  - Poder: un ataque con nombre, tipo, potencia y la energía que consume
    al usarlo.

  - Pokemon: tiene nombre, tipo (Agua, Fuego o Tierra), vida, energía y
    tres poderes. Al crearse, recibe tres poderes de su tipo con una
    potencia aleatoria.

  - Combate: enfrenta a dos pokemon y guarda quién tiene el turno y quién
    es el ganador.

REGLAS DEL COMBATE:
  - Se sortea qué pokemon empieza. El combate va por rondas y, en cada
    ronda, cada pokemon ataca una vez a su contrincante.
  - En su turno, el atacante elige al azar uno de los poderes que puede
    pagar con su energía. El defensor también elige al azar un poder para
    defenderse. Los dos gastan la energía de su poder.
  - Daño = potencia del ataque (con el modificador de tipo)
           - potencia de la defensa.
    Solo se resta vida al defensor si el daño es mayor que 0.
  - Si el defensor no tiene energía para ningún poder, se defiende con
    potencia 0.
  - Si el atacante no tiene energía para ningún poder, pasa el turno y
    recupera entre 5 y 15 puntos de energía (al azar).
  - Gana el primer pokemon que deja a su rival sin vida.

  Modificadores de tipo (según la tabla de tipos de Pokémon):

      Atacante \ Defensor |  Agua  | Fuego  | Tierra
      --------------------+--------+--------+--------
      Agua                |  x0.5  |  x2    |  x2
      Fuego               |  x0.5  |  x0.5  |  x1
      Tierra              |  x1    |  x2    |  x1

VERSION or DATE: 23/10/2026

HOW TO START THIS PROJECT:
  Opción A (más rápida):
  1. Abre el proyecto en BlueJ y pulsa "Compilar".
  2. Haz clic derecho sobre la clase PokemonApp y ejecuta
     void main(String[] args). Se crea un combate entre Squirtle (Agua) y
     Charmander (Fuego) y comienza automáticamente.

  Opción B (creando los objetos a mano):
  1. Abre el proyecto en BlueJ y pulsa "Compilar".
  2. Crea dos objetos Pokemon (clic derecho sobre la clase Pokemon), por
     ejemplo:
         new Pokemon("Squirtle", "Agua")
         new Pokemon("Charmander", "Fuego")
  3. Crea un objeto Combate pasándole los dos pokemon del banco de objetos.
  4. Haz clic derecho sobre el objeto Combate y ejecuta el método comenzar().

AUTHORS:

USER INSTRUCTIONS:
  - El combate se muestra en la ventana del terminal de BlueJ. Pulsa intro
    en el terminal para avanzar a cada evento.
  - Los tipos válidos son "Agua", "Fuego" y "Tierra" (con la primera letra
    en mayúscula).
  - Los dos pokemon deben tener nombres distintos, porque el turno se guarda
    con el nombre del pokemon.
  - Cada pokemon solo puede combatir una vez: al terminar se queda con la
    vida y la energía que le quedaron. Para otro combate, crea pokemon
    nuevos.




TEST TEST TEST TEST TEST TEST
GIT BRANCH TEST
