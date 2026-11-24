package aufgaben.exceptions4;

public class KinoSaal {
    
    private final String filmTitel;
    private boolean[] sitze; // Kapazität mit false = frei und true = belegt
    
    public KinoSaal(String filmTitel, int kapazität) {
        this.filmTitel = filmTitel;
        this.sitze = new boolean[kapazität];
    }
    // Objektmethoden
    public void reservieren(int platzNummer, String kundenName, int alter) throws BuchungException {
        if (kundenName == null || kundenName.equals(""))
            throw new UngueltigeKundenDatenException("Bitte tragen Sie einen Namen ein!");
        if (alter < 6)
            throw new UngueltigeKundenDatenException("Dieser Film hat eine Alterbeschränkung von 6 Jahren!");
        if (platzNummer < 1 || platzNummer > sitze.length)
            throw new UngueltigeKundenDatenException("Platznummer existiert nicht" + platzNummer);
        if (sitze[platzNummer - 1])
            throw new PlatzNichtVerfuegbarException(platzNummer);
        sitze[platzNummer - 1] = true;
        System.out.printf("Erfolg: Platz %d fuer %s reserviert (%s).%n", platzNummer, kundenName, this.filmTitel);
    }
   
}
