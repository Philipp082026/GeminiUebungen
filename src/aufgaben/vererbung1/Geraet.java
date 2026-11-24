package aufgaben.vererbung1;

public class Geraet {
    
    private final String hersteller;
    private int baujahr;
    //Konstruktor
    public Geraet(String hersteller, int baujahr) {
        this.hersteller = hersteller;
        this.baujahr = Math.max(2000, baujahr);
    }
    // Objektmethoden
    public String getHersteller() {
        return this.hersteller;
    }
    public int getBaujahr() {
        return this.baujahr;
    }
    @Override
    public String toString() {
        return String.format("Geraet [Hersteller: %s, Baujahr: %d]%n", this.hersteller, this.baujahr);
    }
    @Override
    public boolean equals(Object obj) {
        // 5-Schritte-Schema
        // Nulltyp-Check
        if(obj == null) return false;
        // Referenzcheck / Reflexivitaet
        if(this == obj) return true;
        // Laufzeittypcheck
        if(this.getClass() != obj.getClass()) return false;
        // Typecast
        Geraet anderes = (Geraet) obj;
        // Attributsvergleich
        return this.baujahr == anderes.baujahr && this.hersteller.equals(anderes.hersteller); // Vergleich von Strings immer mit equals()
    }

}
