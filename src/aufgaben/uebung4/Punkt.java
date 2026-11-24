package aufgaben.uebung4;

public class Punkt {
	
	private final double X;
	private final double Y;
	
	// Konstruktoren
	public Punkt() {
		this(0.0, 0.0);
	}
	public Punkt( double x, double y) {
		this.X = x;
		this.Y = y;
	}
	public Punkt(Punkt p) {
		this(p.X, p.Y);
	}
	
	// Objektmethoden
	public double abstandZu(Punkt p) { 
		 return Math.sqrt(Math.pow(p.X - this.X, 2) + Math.pow(p.Y - this.Y, 2)); 	// Berechnung des euklidischen Abstands mithilfe des Satzes von Pythagoras
	}
	public Punkt verschieben(double dx, double dy) {
		return new Punkt(this.X + dx, this.Y + dy);
	}
	public Punkt mittelpunktZu(Punkt p) {
		return new Punkt((this.X + p.X) / 2.0, (this.Y + p.Y) /2.0);
	}
	public String toString() {
		return (String.format("(%.2f | %.2f)", this.X, this.Y));
	}
}
