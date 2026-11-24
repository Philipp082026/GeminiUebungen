package aufgaben.uebung2;

public class Elektroauto {
	
	private String modell;
	private double akkustand; 	// aktueller Ladestand in kWh
	private double maxKapazitaet;	// maximale Batteriegröße in kWh
	private double verbrauch;	// Stromverbrauch in kWh pro 100 km
	private double kilometerstand; 
	
	public Elektroauto(String modell, double maxKapazitaet, double verbauch) {
		this.modell = modell;
		this.maxKapazitaet = maxKapazitaet;
		this.verbrauch = verbauch;
		this.akkustand = 0.0;
		this.kilometerstand = 0.0;
	}
	
	public void laden(double kwh) {
		if (kwh <= 0.0) 
			System.out.println("Ungueltiger Ladewert");
		else {
			if (this.akkustand + kwh >= this.maxKapazitaet) {
				double geladen = maxKapazitaet - this.akkustand;
				this.akkustand = this.akkustand + geladen;
				System.out.printf("Es wurden %.2f kWh geladen (Akku  ist jetzt voll). %n", geladen);
			} else {
				this.akkustand = this.akkustand + kwh;
				System.out.printf("Es wurden %.2f kWh geladen. %n", kwh);
			}
		}	
	}
	public void status() {
		double reichweite = (this.akkustand / this.verbrauch) * 100;
		System.out.printf("Modell: %s | Akkustand: %.2f / %.2f kWh | Reichweite: %.2f km %n", this.modell, this.akkustand, this.maxKapazitaet, reichweite);
	}
	public void fahren(double streckeKm) {
		double benoetigteEnergie = (streckeKm / 100) * this.verbrauch;
		if (this.akkustand < benoetigteEnergie) 
			System.out.printf("Nicht genug Energie fuer %.2f km! %n", streckeKm);
		else {
			this.akkustand = this.akkustand - benoetigteEnergie;
			System.out.printf("Sie sind %.2f gefahren (Verbrauch: %.2f kWh)! %n", streckeKm, benoetigteEnergie);
			this.kilometerstand = this.kilometerstand + streckeKm;
		}
	}
	public void schnellladen(int minuten) {
		final double LADELEISTUNG_KW = 150.0; // entspricht 150 kwh
		this.laden(((double) minuten / 60) * LADELEISTUNG_KW);
	}
	public void wartungPruefen() {
		if (this.kilometerstand >= 1000.0) 
			System.out.printf("Kilometerstand: %.2f km -> Wartung faellig! %n", this.kilometerstand);
		else 
			System.out.printf("Kilometerstand: %.2f km -> Keine Wartung noetig. %n", this.kilometerstand);
	}
}
