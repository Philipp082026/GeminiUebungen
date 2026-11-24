package aufgaben.uebung1;

public class Uhrzeit {
	
	// Objektvariablen
	private int stunden;
	private int minuten;
	
	// mehrere Konstruktoren
	public Uhrzeit() {
		this(12, 0);
	}
	public Uhrzeit(int stunden, int minuten) {
		this.stunden = (stunden + minuten/60) %24;
		this.minuten = minuten%60;
	}
	public Uhrzeit(Uhrzeit u) {
		this(u.stunden, u.minuten);
	}
	
	// Objektmethoden
	public int inMinuten() {
		return (this.stunden * 60 + this.minuten);
	}
	public Uhrzeit plusMinuten(int min) {
		return new Uhrzeit(this.stunden, this.minuten + min);  	// da hier der Konstruktor Uhrzeit(int stunden, int minuten) aufgerufen wird und ein neues Objekt somit erzeugt wird
	}															// braucht man hier keine komplizierte Rechnung durchführen, das macht ja schon der Konstruktor.
	public Uhrzeit differenz(Uhrzeit u) {
		int diff = this.inMinuten() - u.inMinuten();
		if (diff < 0)
			diff = -diff;
		return new Uhrzeit(diff / 60, diff % 60);		
	}
	public String toString() {
		return (String.format("%02d:%02d", this.stunden, this.minuten) + " Uhr");
	}
	// Vergleichsmethoden
	public boolean istFrueherAls(Uhrzeit u) {
		return (this.inMinuten() < u.inMinuten());
	}
	public boolean istSpaeterAls(Uhrzeit u) {
		return (this.inMinuten() > u.inMinuten());
	}
	public boolean istGleich(Uhrzeit u) {
		return (this.inMinuten() == u.inMinuten());
	}
}
