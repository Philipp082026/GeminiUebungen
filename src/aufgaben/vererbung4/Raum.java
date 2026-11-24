package aufgaben.vererbung4;

public class Raum {
    
    private final String raumNr;
    private final int sitzplaetze;
    // Konstruktor
    public Raum(String raumNr, int sitzplaetze) {
        this.raumNr = raumNr;
        this.sitzplaetze = Integer.max(sitzplaetze, 1);
    }
    // Objektmethoden
    public String getRaumNr() {
        return this.raumNr;
    }
    public int getSitzplaetze() {
        return this.sitzplaetze;
    }
    @Override
    public String toString() {
        return String.format("Raum %s (%d Plaetze)", this.raumNr, this.sitzplaetze);
    }
    @Override
    public boolean equals(Object obj) {
        // 5-Schritte-Schema
        // Null-Akzeptanz
        if (obj == null) return false;
        // Reflexivität/ Referenzcheck
        if (obj == this) return true;
        // Laufzeittypcheck
        if (obj.getClass() != this.getClass()) return false;
        // typecast
        Raum helpObj = (Raum) obj;
        // eigentlicher Objektvergleich/ Vergleich der Attributswerte
        return (helpObj.raumNr.equals(this.raumNr) && (helpObj.sitzplaetze == this.sitzplaetze));
    }

}
