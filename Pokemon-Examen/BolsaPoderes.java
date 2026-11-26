/*
 * EXAMEN:
 * Clase llamada BolsaPoderes con los parametros poder1, poder2 y poder3 de la clase Poder
 * junto a su constructor, sus getters y sus setters
 */
public class BolsaPoderes {
    private Poder poder1;
    private Poder poder2;
    private Poder poder3;
    
    public BolsaPoderes(Poder poder1, Poder poder2, Poder poder3) {
        this.poder1 = poder1;
        this.poder2 = poder2;
        this.poder3 = poder3;
    }
    public Poder getPoder1() {
        return poder1;
    }
    public Poder getPoder2() {
        return poder2;
    }
    public Poder getPoder3() {
        return poder3;
    }
    public void setPoder1(Poder poder) {
        poder1 = poder;
    }
    public void setPoder2(Poder poder) {
        poder2 = poder;
    }
    public void setPoder3(Poder poder) {
        poder3 = poder;
    }
}