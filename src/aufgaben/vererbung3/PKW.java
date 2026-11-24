package aufgaben.vererbung3;

public class PKW extends Fahrzeug {
    
    private final int sitzplaetze;
    private final boolean istElektro;
    // Konstruktoren
    public PKW(String kennzeichen, double grundpreisPorTag, int sitzplaetze, boolean istElektro) {
        super(kennzeichen, grundpreisPorTag);
        this.sitzplaetze = Integer.max(2, sitzplaetze);
        this.istElektro = istElektro;
    }
    public PKW(String kennzeichen, int sitzplaetze) {
        this(kennzeichen, 60.0, sitzplaetze, false);
    }
    // Objektmethoden
    @Override
    public String fahrzeugTyp() {
        return "PKW";
    }
    @Override
    public double berechneMietpreis(int tage) {
        if (tage <= 0)
            return 0.0;
        if (sitzplaetze > 5)
            return super.berechneMietpreis(tage) + 15.0 * tage;
        if (istElektro) 
            return super.berechneMietpreis(tage) * 0.9;
        return super.berechneMietpreis(tage);            
    }
    @Override
    public String toString() {
        String help = this.istElektro ? "ja" : "nein";
        return String.format("%s | %d Sitze, Elektro: %s", super.toString(), this.sitzplaetze, help);
    }
    @Override
    public boolean equals(Object obj) {
        // Wiederverwendung der equals()-Methode aus der Klasse Fahrzeug
        if(!super.equals(obj)) return false;
        // nur noch casten und Vergleiche der neuen Objektattribute der Klasse PKW
        PKW helpObj = (PKW) obj;
        return this.sitzplaetze == helpObj.sitzplaetze && this.istElektro == helpObj.istElektro;
    }
}
