package aufgaben.uebung4;

public class Kreis {
	
	public static final double MIN_RADIUS = 1.0;
	private static int anzahlKreise = 0;
	private Punkt mittelpunkt;
	private double radius;
	
	// Konstruktoren
	public Kreis(Punkt mittelpunkt, double radius) {
		this.mittelpunkt = new Punkt(mittelpunkt);
		this.radius = Math.max(radius,  MIN_RADIUS);
		anzahlKreise++;
	}
	public Kreis(double x, double y, double radius) {
		this(new Punkt(x, y), radius);
	}
	public Kreis(double radius) {
		this(new Punkt(), radius);
	}
	public Kreis() {
		this(MIN_RADIUS);
	}
	
	// Objektmethoden
	public static int getAnzahlKreise() {
		return anzahlKreise;
	}
	public double flaeche() {
		return Math.PI * Math.pow(this.radius, 2);
	}
	public double umfang() {
		return 2 * Math.PI * this.radius;
	}
	public boolean enthaeltPunkt(Punkt p) {
		return (this.mittelpunkt.abstandZu(p) <= this.radius);
	}
	public Kreis verschieben(double dx, double dy) {
		return new Kreis(this.mittelpunkt.verschieben(dx, dy), this.radius);
	}
	public Kreis skalieren(double faktor) { 	// gibt ein neues Kreis-Objekt am selben Mittelpunkt zurück, dessen Radius mit faktor multipliziert wurde.
		return new Kreis(this.mittelpunkt, this.radius * faktor);
	}
	public String toString() {
		return (String.format("Kreis [M=%s, r=%.2f, A=%.2f, U=%.2f", this.mittelpunkt.toString(), this.radius, this.flaeche(), this.umfang()));
	}
	public boolean beruehrtOderSchneidet(Kreis k) {
		return (this.mittelpunkt.abstandZu(k.mittelpunkt) <= this.radius + k.radius);
	}
	public Kreis verbindungsKreis(Kreis k) {
		return new Kreis(new Punkt(this.mittelpunkt.mittelpunktZu(k.mittelpunkt)), this.mittelpunkt.abstandZu(k.mittelpunkt) / 2.0);
	}
}
