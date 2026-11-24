package aufgaben.vererbung3;

public class FuhrparkTest {
    
    public static void main(String[] args) {
    
        Fahrzeug f1 = new Fahrzeug("L-AB 100");
        PKW p1 = new PKW("L-PK 200", 60.0, 5, true);
        PKW p2 = new PKW("L-PK 300", 60.0, 7, false);
        Transporter t1 = new Transporter("L-TR 400", 80.0, 3.5);

        Fahrzeug[] fuhrpark = { f1, p1, p2, t1 };

        System.out.printf("%n--------------------- Fuhrpark-Uebersicht (Gesamt: %d Fahrzeuge) -----------------%n", Fahrzeug.getAnzahlFahrzeuge());
        double gesamtUmsatz = 0.0;
        for (Fahrzeug f : fuhrpark) {
            double preis3Tage = f.berechneMietpreis(3);
            gesamtUmsatz += preis3Tage;
            System.out.printf("%s%n   -> Typ: %-11s | Mietpreis fuer 3 Tage: %6.2f EUR%n",
                    f.toString(), f.fahrzeugTyp(), preis3Tage);
        }
        System.out.printf("Gesamtumsatz bei 3 Tagen Vermietung: %.2f EUR%n", gesamtUmsatz);

        System.out.printf("%n--- Gleichheitstests mit equals() ---%n");
        PKW p1Kopie = new PKW("L-PK 200", 60.0, 5, true);
        PKW p1AndereSitze = new PKW("L-PK 200", 60.0, 4, true);
        Fahrzeug fMitPkwKennzeichen = new Fahrzeug("L-PK 200", 60.0);

        System.out.printf("p1.equals(p1Kopie):             %b%n", p1.equals(p1Kopie));
        System.out.printf("p1.equals(p1AndereSitze):       %b%n", p1.equals(p1AndereSitze));
        System.out.printf("p1.equals(fMitPkwKennzeichen):  %b%n", p1.equals(fMitPkwKennzeichen));
    }
}
