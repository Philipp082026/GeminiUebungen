package aufgaben.exceptions4;

public class KinoTest {
    
    public static void main(String[] args) {
        
        KinoSaal kino = new KinoSaal("Inception", 5);

        // 1. Gueltige Buchung
        try {
            kino.reservieren(3, "Max Mustermann", 25);
        } catch (BuchungException ex) {
            System.out.printf("Fehler [%d]: %s%n", ex.getFehlerCode(), ex.getMessage());
        }

        // 2. Doppelte Buchung (spezifischer Catch)
        try {
            kino.reservieren(3, "Erika Musterfrau", 30);
        } catch (PlatzNichtVerfuegbarException ex) {
            System.out.printf("SPEZIFISCH [Code %d]: Platz %d nicht frei!%n", ex.getFehlerCode(), ex.getPlatzNummer());
        } catch (BuchungException ex) {
            System.out.printf("ALLGEMEINE BUCHUNGSAUSNAHME [Code %d]: %s%n", ex.getFehlerCode(), ex.getMessage());
        }

        // 3. Ungueltige Kundendaten (polymorph über Basisklasse BuchungException abgefangen)
        try {
            kino.reservieren(1, "", 20);
        } catch (BuchungException ex) {
            System.out.printf("BUCHUNG ABGELEHNT [Code %d]: %s%n", ex.getFehlerCode(), ex.getMessage());
            System.out.println(ex.getClass().getSimpleName());
        }

        // 4. Ungueltiges Alter
        try {
            kino.reservieren(2, "Timmy", 4);
        } catch (BuchungException ex) {
            System.out.printf("BUCHUNG ABGELEHNT [Code %d]: %s%n", ex.getFehlerCode(), ex.getMessage());
            System.out.println(ex.getClass().getSimpleName());
        }               
    }
}
