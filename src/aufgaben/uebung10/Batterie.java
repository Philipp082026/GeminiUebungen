package aufgaben.uebung10;

public class Batterie {
    
    public static final short STANDARD_KAPAZITAET = 500; // öffentliche Klassenkonstante in Wh
    private static final double EPSILON = 1E-7;
    // Objektvariablen
    private short maxKapazitaetWh;  // Nennkapazitaet in Wh
    private double ladestandWh;     // aktuell gespeicherte Energie
    private byte gesundheitProzent; // Batteriezustand
    
    // Konstruktoren
    // Hauptkonstruktor
    public Batterie(short maxKapazitaet, double ladestandWh, byte gesundheitProzent) {
        if (maxKapazitaet < 100)
            this.maxKapazitaetWh = STANDARD_KAPAZITAET;
        else 
            this.maxKapazitaetWh = maxKapazitaet;
        this.gesundheitProzent = (byte) Integer.max(1, Integer.min(maxKapazitaet, 100));
        this.ladestandWh = this.effektiveMaxKapazitaet();
    }
    // String Konstruktor
    public Batterie(String kapazitaetStr, String gesundheitStr) {
        this(Short.parseShort(kapazitaetStr), (double) Short.parseShort(kapazitaetStr) * ((double) Byte.parseByte(gesundheitStr)/100.0), Byte.parseByte(gesundheitStr));        
    }
    public Batterie() {
        this(STANDARD_KAPAZITAET, (double) STANDARD_KAPAZITAET, (byte) 100);
    }
    // Kopierkonstruktor
    public Batterie(Batterie b) {
        this(b.maxKapazitaetWh, b.ladestandWh, b.gesundheitProzent);
    }
    
    // Objektmethoden
    public short getMaxKapazitaetWh() {
        return this.maxKapazitaetWh;
    }
    public double getLadestandWh() {
        return this.ladestandWh;
    }
    public byte getGesundheitProzent() {
        return this.gesundheitProzent;
    }
    public double effektiveMaxKapazitaet() {
        return (double) this.maxKapazitaetWh * ((double) this.gesundheitProzent /100.0);
    }
    public byte ladestandInProzent() {  // Verhältnis von ladestandWh zur effektiveMaxKapazitaet() in Prozent
        return (byte) Math.round(effektiveMaxKapazitaet()/ladestandWh);     // Math.round: gibt den dem Argument am nächsten liegenden `long`-Wert zurück
    }
    
    

}
