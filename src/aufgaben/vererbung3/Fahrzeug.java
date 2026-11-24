package aufgaben.vererbung3;

public class Fahrzeug {
    
    public final static double EPSILON = 1E-7;
    private static int anzahlFahrzeuge = 0;
    private final String kennzeichen;
    private final double grundpreisProTag;
    
    //Konstruktoren
    public Fahrzeug(String kennzeichen, double grundpreisProTag) {
        this.kennzeichen = kennzeichen;
        this.grundpreisProTag = Math.max(20.0, grundpreisProTag);
        anzahlFahrzeuge++;
    }
    public Fahrzeug(String kennzeichen) {
        this(kennzeichen, 50.0);
    }
    // Objektvariablen
    public static int getAnzahlFahrzeuge() {
        return anzahlFahrzeuge;
    }
    public String getKennzeichen() {
        return this.kennzeichen;
    }
    public double getGrundpreisProTag() {
        return this.grundpreisProTag;
    }
    public String fahrzeugTyp() {
        return "Fahrzeug";
    }
    public double berechneMietpreis(int tage) {
        if (tage <= 0) 
            return 0.0;
        return tage * this.grundpreisProTag;
    }
    @Override
    public String toString() {
        return String.format("[%s] %s (Grundpreis: %.2f EUR/Tag)", this.fahrzeugTyp(), this.kennzeichen, this.grundpreisProTag);
    }
    @Override
    public boolean equals(Object obj) {
        // 5-Schritte-Schema
        // Nulltyp-Check
        if (obj == null) return false;
        // Reflexivität/ Referenzcheck
        if (obj == this) return true;
        // Laufzeittypcheck
        if (obj.getClass() != this.getClass()) return false; 
        // Typecast
        Fahrzeug helpObj = (Fahrzeug) obj;
        // Attributsvergleich
        return this.kennzeichen.equals(helpObj.kennzeichen) && Math.abs(this.grundpreisProTag - helpObj.grundpreisProTag) < EPSILON;
    }
}
