package aufgaben.uebung7;

public class Wetterstation {
	
	private static int gesamtMessungenAlleStationen = 0;
	private final String standort;
	private Messwert[] messungen; 	// Array zur Speicherung der Messwerte, jeder Speicherplatz des Arrays beinhaltet jeweils einen int für die Stunde, ein double für die Temperatur und ein byte für die Luftfeuchtigkeit
	private int anzahlMessungen; 	// Anzahl der bisher im Array gespeicherten Messwerte
	private Boolean istAktiv; 	// Die Variable istAktiv ist nicht vom Typ primitiven Datentyp, sondern ein Objekt der Wrapperklasse Boolean. Hier soll damit zum Ausdruck gebracht werden, wie der aktuelle Status der Wetterstation ist.
						// Es gibt hier 3 Zustände: Boolean.TRUE = aktiv, Boolean.FALSE = deaktiviert, null = Wartungsmodus. Der primitive boolean könnte den Zustand "Wartungsmodus" nicht darstellen.
	//Konstruktoren
	public Wetterstation(String standort, int kapazitaet) {
		this.standort = standort;
		this.messungen = new Messwert[Integer.max(1, kapazitaet)];
		this.anzahlMessungen = 0;
		this.istAktiv = Boolean.TRUE;
	}
	public Wetterstation(String standort) {
		this(standort, 5);
	}
	
	// Objektmethoden
	public static int getGesamtMessungenAlleStationen() {
		return Wetterstation.gesamtMessungenAlleStationen;
	}
	public void setStatus(Boolean aktiv) {
		this.istAktiv = aktiv;
	}
	public void messwertAufnehmen(Messwert m) {
		if (istAktiv == null || !istAktiv) { // Wetterstation ist deaktiviert oder im Wartungsmodus
			if (istAktiv == null) 
				System.out.printf("Station %S befindet sich im Wartungsmodus!%n", this.standort);
			else 
				System.out.printf("Station %s ist deaktiviert!%n", this.standort);
		}
		else {
			if (anzahlMessungen < messungen.length) {
				this.messungen[this.anzahlMessungen] = new Messwert(m);
				this.anzahlMessungen++;
				gesamtMessungenAlleStationen++;
				System.out.printf("Messwert fuer %s gespeichert (%d/%d).%n", this.standort, this.anzahlMessungen, this.messungen.length);
			}
			else 
				System.out.printf("Speicher der Station %s ist voll!%n", this.standort);			
		}
	}
	public void messwertAufnehmen(String stundeStr, String tempStr, String feuchteStr) { 	// Ein Messwert wird über String - Parameter aufgenommen. Der String-Konstruktor der Klasse Messwert muss aufgerufen werden.
		this.messwertAufnehmen(new Messwert(stundeStr, tempStr, feuchteStr));
	}
	public int findeErsteStundeUeber(double schwellwert) {	// Durchsucht das Array (aufgenommene Messungen) nach einer gespeicherten Temperatur, welche größer als schwellwert ist
		for (int i = 0; i < this.anzahlMessungen; i++) {
			if (this.messungen[i].getTemperatur() > schwellwert) {
				return this.messungen[i].getStunde();
			}
		}
		return -1;
	}
	public double berechneTagesDurchschnitt() { 	// Berchnet Tagesdurchschnittstemperatur
		double durchschnittsTemperatur = 0.0;
		int anzahlTemperaturwerte = 0;
		for (int i = 0; i < this.anzahlMessungen; ++i) {
			if (this.messungen[i].tageszeit() != "Nacht") {
				durchschnittsTemperatur = durchschnittsTemperatur + this.messungen[i].getTemperatur();
				anzahlTemperaturwerte++;
			}
		}
		return durchschnittsTemperatur/ (double) anzahlTemperaturwerte;
	}
	public Messwert findeExtremwert(boolean sucheMaximum) {
		if (this.anzahlMessungen == 0) 
            return null;
		Messwert extremtemperatur = this.messungen[0];
			for (int i = 1; i < this.anzahlMessungen; ++i) {
				if (sucheMaximum && this.messungen[i].getTemperatur() > extremtemperatur.getTemperatur()) 
					extremtemperatur = this.messungen[i];
				else if (!sucheMaximum && this.messungen[i].getTemperatur() < extremtemperatur.getTemperatur())
						extremtemperatur = this.messungen[i];
			}
		return extremtemperatur;
	}
	public void berichtAusgeben() {
		System.out.printf("=== Bericht Wetterstation %s (%d/%d) ===%n", this.standort, this.anzahlMessungen, gesamtMessungenAlleStationen);
		for (int i = 0; i < this.anzahlMessungen; ++i) {
			System.out.printf(" - [%02d:00 Uhr (%s): %.2f Grad, %d%% Feuchte]%n", this.messungen[i].getStunde(), this.messungen[i].tageszeit(), this.messungen[i].getTemperatur(), this.messungen[i].getLuftfeuchtigkeit());
		}
	}
}
