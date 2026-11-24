package aufgaben.vererbung4;

public class Hoersaal extends Raum implements Buchbar, Klimatisierbar {
    
    private final boolean hatBeamer;
    private String gebuchtVon;
    private double temperatur;
    // Konsturktoren
    public Hoersaal(String raumNr, int sitzplaetze, boolean hatBeamer) {
        super(raumNr, sitzplaetze);
        this.hatBeamer = hatBeamer;
        this.gebuchtVon = null;
        this.temperatur = STANDARD_TEMP;
    }
    public Hoersaal(String raumNr, int sitzplaetze) {
        this(raumNr, sitzplaetze, true);        
    }
    // Objektmethoden
    @Override
    public boolean istFrei() {
        return this.gebuchtVon == null;
    }
    @Override
    public boolean buchen(String nutzer) {
        if (!this.istFrei()) {
            System.out.printf("Buchung abgelehnt: Hoersaal %s ist bereits belegt!%n", this.getRaumNr());
            return false;
        }
        if (nutzer.equals(null)) 
            return false;
        this.gebuchtVon = nutzer;
        System.out.printf("Hoersaal %s gebucht fuer %s.%n", this.getRaumNr(), nutzer);
        return true;
    }
    @Override
    public void stornieren() {
        this.gebuchtVon = null;
    }
    @Override
    public void regleTemperatur(double zielTemp) {
        this.temperatur = Math.max(MIN_TEMP, Math.min(zielTemp, MAX_TEMP));
        System.out.printf("Klima Hoersaal %s: Temperatur auf %.2f Grad eingestellt.%n", this.getRaumNr(), this.temperatur);
    }
    @Override
    public double getTemperatur() {
        return this.temperatur; 
    }
    @Override
    public String toString() {
        String beamer = this.hatBeamer ? "ja" : "nein";
        String raumFrei = this.istFrei() ? "FREI" : ("BELEGT (" + this.gebuchtVon + ")");
        return super.toString() + String.format(" [Hoersaal | Beamer: %s | %.2f Grad | Status: %s]", beamer, this.temperatur, raumFrei);
    }
    @Override
    public boolean equals(Object obj) {
        // 3-Schritte-Schema bei vererbten Klassen
        // Wiederverwendung der equals()-Methode aus der Klasse Fahrzeug
        if (!super.equals(obj)) return false;
        // typecast
        Hoersaal helpObj = (Hoersaal) obj;
        // Attributsvergleich der neuangelgten Attribute in der Klasse Haersaal (hier nur hatBeamer)
        return helpObj.hatBeamer == this.hatBeamer;
    }

}
