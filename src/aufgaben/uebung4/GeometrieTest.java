package aufgaben.uebung4;

public class GeometrieTest {

	public static void main(String[] args) {
		
		Punkt p1 = new Punkt(3.0, 4.0);
		Punkt p2 = new Punkt();
		
		System.out.printf("%n%n------------------------- Punkte ----------------------------------------%n%n");
		System.out.printf("p1: %s | p2: %s%n", p1.toString(), p2.toString());
		System.out.printf("Abstand p1 zu p2: %.2f%n", p1.abstandZu(p2));
		System.out.printf("Mitte zwischen p1 und p2: %s%n", p1.mittelpunktZu(p2).toString());
		
		System.out.printf("%n%n------------------------- Kreise ----------------------------------------%n%n");
		System.out.printf("Bisher erstellte Kreise: %d%n", Kreis.getAnzahlKreise());
		
		Kreis k1 = new Kreis(p1, 5.0);
		Kreis k2 = new Kreis(-3.0, -4.0, 2.0);
		Kreis k3 = new Kreis(0.5); // zu kleiner Radius -> wird auf MIN_RADIUS (1.0) gesetzt
		Kreis k4 = new Kreis();
		
		System.out.printf("k1: %s%n", k1.toString());
		System.out.printf("k2: %s%n", k2.toString());
		System.out.printf("k3: %s%n", k3.toString());
		System.out.printf("k4: %s%n", k4.toString());
		System.out.printf("Bisher erstellte Kreise: %d%n", Kreis.getAnzahlKreise());
		
		System.out.printf("%nLiegt %s in k1? %b%n", p2.toString(), k1.enthaeltPunkt(p2));
		System.out.printf("Liegt %s in k2? %b%n", p2.toString(), k2.enthaeltPunkt(p2));
		
		Kreis k1Verschoben = k1.verschieben(-3.0, -4.0);
		Kreis k2Skaliert = k2.skalieren(2.5);
		System.out.printf("k1 verschoben: %s%n", k1Verschoben.toString());
		System.out.printf("k2 skaliert:   %s%n", k2Skaliert.toString());
		System.out.printf("Bisher erstellte Kreise: %d%n", Kreis.getAnzahlKreise());
		
		System.out.printf("%n%n------------------------- Zusatz: Kreisbeziehungen ----------------------%n%n");
		System.out.printf("Schneiden sich k1 und k2? %b%n", k1.beruehrtOderSchneidet(k2));
		System.out.printf("Schneiden sich k1 und k3? %b%n", k1.beruehrtOderSchneidet(k3));
		Kreis kVerbindung = k1.verbindungsKreis(k2);
		System.out.printf("Verbindungskreis aus k1 und k2: %s%n", kVerbindung.toString());
		System.out.printf("Bisher erstellte Kreise: %d%n", Kreis.getAnzahlKreise());
	}

}
