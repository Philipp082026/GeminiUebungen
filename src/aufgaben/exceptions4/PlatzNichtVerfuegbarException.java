package aufgaben.exceptions4;

public class PlatzNichtVerfuegbarException extends BuchungException { // Checked Exception
    
    private final int platzNummer;
    
    public PlatzNichtVerfuegbarException(int platzNummer) {
        super("Platz " + platzNummer + " ist leider bereits belegt!", 101);
        this.platzNummer = platzNummer;
    }
    public int getPlatzNummer() {
        return this.platzNummer;
    }
}
