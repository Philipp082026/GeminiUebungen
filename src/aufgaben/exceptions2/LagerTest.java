package aufgaben.exceptions2;

public class LagerTest {

    public static void main(String[] args) {
        
        System.out.printf("--------------------- 1. Ungueltiges Regal erzeugen ---------------%n"); 
        try { 
            Lagerregal fehlerRegal = new Lagerregal(99, -5); 
        } catch (UngueltigeKapazitaetException ex) { 
            System.out.printf("Abgefangen: %s%n", ex.getMessage()); 
        } 
        
        System.out.printf("%n------------------------ 2. Gueltiges Regal & Fehlerfaelle beim Einlagern -------------------------%n"); 
        Lagerregal regal = new Lagerregal(1, 10); 
        regal.artikelEinlagern(6); 
        
        try { 
            regal.artikelEinlagern(-2); // IllegalArgumentException 
        } catch (IllegalArgumentException ex) { 
            System.out.printf("Parameter-Fehler: %s%n", ex.getMessage()); 
        } 
        
        try { 
            regal.artikelEinlagern(6); // IllegalStateException (da 6 + 6 > 10) 
        } catch (IllegalStateException ex) { 
            System.out.printf("Zustands-Fehler: %s%n", ex.getMessage()); 
        } 
        System.out.printf("%nFreie Plaetze im Regal #1: %d%n", regal.getFreiePlaetze());
    }
}
