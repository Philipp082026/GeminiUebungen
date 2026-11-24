package aufgaben.vererbung4;

public class Dienstwagen implements Buchbar, Klimatisierbar{
    
    private final String kennzeichen;
    private String fahrer;
    private double innenTemp;
    // Konstruktor
    public Dienstwagen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
        this.fahrer = null;
        this.innenTemp = STANDARD_TEMP;
    }
    // Objektmethoden
    @Override
    public boolean istFrei() {
        return this.fahrer == null;
    }
    @Override
    public boolean buchen(String nutzer) {
        if (!this.istFrei()) {
            System.out.printf("Buchung abgelehnt: Dienstwagen %s ist bereits vergeben!%n", this.kennzeichen);
            return false;
        }
        if (nutzer == null)
            return false;
        this.fahrer = nutzer;
        System.out.printf("Dienstwagen %s gebucht fuer %s.%n", this.kennzeichen, nutzer);
        return true;
    }
    @Override
    public void stornieren() {
        this.fahrer = null;
    }
    @Override
    public void regleTemperatur(double zielTemp) {
        this.innenTemp = Math.max(MIN_TEMP, Math.min(zielTemp, MAX_TEMP));
        System.out.printf("Klima Dienstwagen %s: Temperatur auf %.2f Grad eingestellt.%n", this.kennzeichen, innenTemp);
    }
    @Override
    public double getTemperatur() {
        return this.innenTemp;
    }
    @Override
    public String toString() {
        String belegt = this.istFrei() ? "FREI" : ("BELEGT (" + this.fahrer + ")");
        return String.format("Dienstwagen %s [%.2f Grad | Status: %s]%n", this.kennzeichen, this.innenTemp, belegt);
    }
}
