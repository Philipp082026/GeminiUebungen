package aufgaben.uebung7;

public class WetterTest {

	public static void main(String[] args) {
		
		Messwert m1 = new Messwert(8, 15.5, (byte) 60);
		Messwert m2 = new Messwert(2, 9.2, (byte) 85);
		Messwert m3 = new Messwert(19, 18.7, (byte) 110);
		Messwert m4 = new Messwert(15.5);
		Messwert mRundung = new Messwert(10, 0.1 + 0.2, (byte) 50);
		Messwert mExakt = new Messwert(10, 0.3, (byte) 50);
		
		System.out.printf("%n%n------------------------- Einzelne Messwerte ----------------------------%n%n");
		System.out.printf("m1: %s%n", m1.toString());
		System.out.printf("m1 korrigiert (-15%%): %s%n", m1.korrigiereFeuchtigkeit((byte) -15).toString());
		System.out.printf("m3 (Feuchte gekappt): %s%n", m3.toString());
		System.out.printf("m1 gleiche Temp. wie m4? %b%n", m1.hatGleicheTemperatur(m4));
		System.out.printf("0.1+0.2 gleiche Temp. wie 0.3? %b%n", mRundung.hatGleicheTemperatur(mExakt));
		
		System.out.printf("%n%n------------------------- Wetterstation ---------------------------------%n%n");
		Wetterstation ws = new Wetterstation("Leipzig-Zentrum", 4);
		System.out.printf("Tagesdurchschnitt (leer): %s%n", Double.toString(ws.berechneTagesDurchschnitt()));

		ws.messwertAufnehmen(m2);
		ws.messwertAufnehmen(m1);
		ws.messwertAufnehmen("14", "24.8", "45");

		ws.setStatus(null);
		ws.messwertAufnehmen(m3);

		ws.setStatus(Boolean.FALSE);
		ws.messwertAufnehmen(m3);

		ws.setStatus(Boolean.TRUE);
		ws.messwertAufnehmen(m3);
		ws.messwertAufnehmen(m4);

		System.out.printf("%n");
		ws.berichtAusgeben();

		System.out.printf("Tagesdurchschnitt (ohne Nacht): %.2f Grad%n", ws.berechneTagesDurchschnitt());
		System.out.printf("Erste Stunde ueber 18,0 Grad:   %d Uhr%n", ws.findeErsteStundeUeber(18.0));
		System.out.printf("Erste Stunde ueber 30,0 Grad:   %d%n", ws.findeErsteStundeUeber(30.0));
		System.out.printf("Waermster Messwert: %s%n", ws.findeExtremwert(true).toString());
		System.out.printf("Kaeltester Messwert: %s%n", ws.findeExtremwert(false).toString());
		System.out.printf("Gesamtmessungen aller Stationen: %d%n", Wetterstation.getGesamtMessungenAlleStationen());
	}

}
