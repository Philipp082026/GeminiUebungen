package aufgaben.exceptions1;

public class Konto {

    private final String kontoinhaber;
    private double guthaben;
    
    public Konto(String kontoinhaber, double guthaben) {
        this.kontoinhaber = kontoinhaber;
        this.guthaben = Math.max(0.0, guthaben);
    }
    // Objektmethoden
    public String getKontoinhaber() {
        return this.kontoinhaber;
    }
    public double getGuthaben() {
        return this.guthaben;
    }
    public void einzahlen(double betrag) {
        if (betrag > 0)
            this.guthaben = this.guthaben + betrag;
    }
    // Exceptionmethode mit throws
    public void abheben(double betrag) throws GuhabenNichtAusreichendException { // Da GuthabenNicht... eine Checked Exception ist, muss im Methodenkopf deklariert werden, dass man Ausnahmen werfen kann
        if (betrag > this.guthaben) {
            double fehl = betrag - this.guthaben;
            throw new GuhabenNichtAusreichendException("Auszahlung fehlgeschlagen: Deckung unzureichend!", fehl); // Excpetions werden immer mit "throw new" geworfen.
        }
       this.guthaben = this.guthaben - betrag;
       System.out.printf("Erfolgreich %.2f EUR abgehoben. Neues Guthaben: %.2f EUR%n", betrag, this.guthaben);          
    }
}
