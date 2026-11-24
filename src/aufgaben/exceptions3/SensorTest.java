package aufgaben.exceptions3;
// Uebung mit vielen catch-Blöcken
public class SensorTest {

    public static void main(String[] args) {
       
        SensorStation s = new SensorStation("TEMP-01");
        String[] testWerte = { "23.5", "115.0", "abc", null };
        
        for (String eingabe : testWerte) {
            System.out.printf("%n==================== Test mit Eingabe: %s ====================%n", eingabe);
            s.verbinden();
            try {
                double wert = s.parseUndPruefeMesswert(eingabe);
                System.out.printf("Erfolg: Messwert %.2f Grad akzeptiert.%n", wert);
            } catch (SensorWertAusserhalbException ex) {
                System.out.printf("FACHLICHER FEHLER: %s (Wert: %.2f)%n", ex.getMessage(), ex.getFehlerhafterWert());
            } catch (NumberFormatException ex) {
                System.out.printf("FORMAT-FEHLER: Text konnte nicht in Zahl gewandelt werden!%n");
            } catch (Exception ex) {
                System.out.printf("ALLGEMEINER FEHLER (%s): %s%n", ex.getClass().getSimpleName(), ex.getMessage());
            } finally {
                s.trennen(); // Garantiert aufraeumen!
            }
        }
    }
}
