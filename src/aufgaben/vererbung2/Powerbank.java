package aufgaben.vererbung2;

public class Powerbank implements Aufladbar {
    
    private final int kapazitaetMah; // in mAh (Milli-Ampere-Stunde)
    private int akkuProzent;
    
    // Konstruktor
    public Powerbank(int kapazitaetMah) {
        this.kapazitaetMah = kapazitaetMah;
        this.akkuProzent = 0;
    }
    // Pflichtmethoden aus dem Interface Aufladbar
    @Override
    public void aufladen(int prozent) {
        if (prozent > 0) {
            this.akkuProzent = Math.min((int) Math.round(prozent * 0.9) + this.akkuProzent, MAX_LADESTAND);
            System.out.printf("Powerbank [%d mAh] geladen -> aktuell %d%%%n", this.kapazitaetMah, this.akkuProzent);
        }
    }
    @Override
    public int getLadestand() {
        return this.akkuProzent;
    }
    @Override
    public String statusText() {
        return "Powerbank " + this.kapazitaetMah + " mAh (" + this.akkuProzent + "%)";
    }

}
