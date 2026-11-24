package aufgaben.vererbung1;

public class Smartphone extends Geraet {
    
    private int speicherGb;
    // Konstruktoren
    public Smartphone(String hersteller, int baujahr, int speicherGb) {
        super(hersteller, baujahr);
        this.speicherGb = Math.max(64,speicherGb);
    }
    public Smartphone(String hersteller) {
        this(hersteller, 2024, 128);
    }
    // Objektmethoden
    @Override
    public String toString() {
        return String.format(super.toString() + " -> Smartphone [%d GB]%n", this.speicherGb);
    }
    @Override
    public boolean equals(Object obj) {
        // Wiederverwendung der equals() Methode von der Klasse Geraet
        if (!super.equals(obj)) return false; // alle Vergleiche aus equals() aus Klasse Geraet werden hier angewendet
        // nur noch cast nach Smartphone und Vergleich der speicherGb nowendig
        Smartphone helpObj = (Smartphone) obj; // Typecast
        return (this.speicherGb == helpObj.speicherGb);        
    }

}
