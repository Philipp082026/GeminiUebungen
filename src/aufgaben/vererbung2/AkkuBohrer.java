package aufgaben.vererbung2;

public class AkkuBohrer implements Aufladbar {
    
    private final String modell;
    private int akkuProzent;
    
    // Konstruktor
    public AkkuBohrer(String modell, int startAkku) {
        this.modell = modell;
        this.akkuProzent = Math.max(0, Math.min(MAX_LADESTAND, startAkku));
    }
    // Implementierung der Pflichtmethoden aus dem Interface Aufladbar, immer mit public und @Override
    @Override
    public void aufladen(int prozent) {
        if (prozent > 0) {
            this.akkuProzent = Math.min(MAX_LADESTAND, prozent - this.akkuProzent);
            System.out.printf("Bohrer [%s] geladen -> aktuell %d%%%n", this.modell, this.akkuProzent);
        }
    }
    @Override
    public int getLadestand() {
        return this.akkuProzent;
    }
    @Override
    public String statusText() {
        return "AkkuBohrer " + this.modell + " (" + this.akkuProzent + "%)";
    }
}
