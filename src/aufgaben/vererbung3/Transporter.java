package aufgaben.vererbung3;

public class Transporter extends Fahrzeug {
    
    private final double maxZuladungTonnen;
    // Konstruktor
    public Transporter(String kennzeichen, double grundpreisProTag, double maxZuladungTonnen) {
        super(kennzeichen, grundpreisProTag);
        this.maxZuladungTonnen = Math.max(maxZuladungTonnen, 0.5);
    }
    // Objektmethoden
    @Override
    public String fahrzeugTyp() {
        return "Transporter";
    }
    @Override
    public double berechneMietpreis(int tage) {
        if (tage <= 0)
            return 0.0;
        return super.berechneMietpreis(tage) + tage * 25.0 * this.maxZuladungTonnen;
    }
    @Override
    public String toString() {
        return String.format("%s | Zuladung: %.2f t", super.toString(), this.maxZuladungTonnen);
    }
    @Override
    public boolean equals(Object obj) {
        // Wiedervendung der equals()-Methode der Klasse Fahrzeug
        if (!super.equals(obj)) return false;
        // casten und Vergleich des neuen Objektattributs der Klasse Transporter
        Transporter helpObj = (Transporter) obj;
        return Math.abs(this.maxZuladungTonnen - helpObj.maxZuladungTonnen) < EPSILON;
    }
}
