package aufgaben.exceptions2;

public class Lagerregal {
    
    private final int regalNummer;
    private final int maxPlaetze;
    private int belegtePlaetze;
    
    public Lagerregal(int regalNummer, int maxPlaetze) {
        if (maxPlaetze <= 0)
            throw new UngueltigeKapazitaetException(maxPlaetze); // Excpetions werden immer mit "throw new" geworfen.
        else {
            this.regalNummer = regalNummer;
            this.maxPlaetze = maxPlaetze;
            this.belegtePlaetze = 0;
        }
    }
    // Objektmethoden
    public void artikelEinlagern(int anzahl) {
        if (anzahl <= 0)
            throw new IllegalArgumentException("Anzahl muss positiv sein"); // bereits in Java vorprogrammierte Exceptionsklassen kann man jederzeit aufrufen und verwenden.
        if (this.belegtePlaetze + anzahl > this.maxPlaetze) 
            throw new IllegalStateException("Regal voll! Nicht genug freie Plaetze.");
        this.belegtePlaetze =+ anzahl;
        System.out.printf("Regal #%d: %d Artikel eingelagert (Status: %d/%d).%n", this.regalNummer, anzahl, this.belegtePlaetze, this.maxPlaetze);
    }
    public int getFreiePlaetze() {
        return this.maxPlaetze - this.belegtePlaetze;
    }
}
