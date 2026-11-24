package aufgaben.uebung7;

public class Messwert {
	
	private static final double EPSILON = 1E-7; 	// Konstante für den Vergleich von Fließkommazahlen
	private final int stunde;				
	private final double temperatur;		// in Grad Celsius
	private final byte luftfeuchtigkeit;	// in Prozent
	
	// Konstruktoren
	public Messwert(int stunde, double temperatur, byte luftfeuchtigkeit) {
		if (stunde < 0)
			this.stunde = 0;
		else 
			this.stunde = stunde % 24;
		this.temperatur = temperatur;
		int gekappteFeuchte = Integer.min(100, Integer.max(0, luftfeuchtigkeit));
        this.luftfeuchtigkeit = (byte) gekappteFeuchte;
	}
	
	public Messwert(String stundeStr, String tempStr, String feuchteStr) {  	// neues Objekt wird über die Umwandlung von Strings in die jeweiligen primitven Datentypen initialisiert (parsen)
		this(Integer.parseInt(stundeStr), Double.parseDouble(tempStr), Byte.parseByte(feuchteStr));
	}
	public Messwert(double temperatur) {
		this(12, temperatur, (byte) 50);
	}
	public Messwert(Messwert m) { 	// Kopierkostruktor
		this(m.stunde, m.temperatur, m.luftfeuchtigkeit);
	}
	// Objektmethoden
	public int getStunde() {
		return this.stunde;
	}
	public double getTemperatur() {
		return this.temperatur;
	}
	public byte getLuftfeuchtigkeit() {
		return this.luftfeuchtigkeit;
	}
	public String tageszeit() {
		switch(this.stunde) {
		case 22, 23, 0 , 1, 2, 3, 4, 5 -> {return "Nacht";}
		case 6, 7, 8, 9, 10, 11 -> {return "Morgen";}
		case 12, 13, 14, 15, 16, 17 -> {return "Mittag";}
		default -> {return "Abend";}
		}
	}
	public Messwert korrigiereFeuchtigkeit(byte korrektur) {
		byte neueLuftfeuchtigkeit = (byte) (this.luftfeuchtigkeit + korrektur);
		return new Messwert(this.stunde, this.temperatur, neueLuftfeuchtigkeit);
	}
	public boolean hatGleicheTemperatur(Messwert m) {
		return (Math.abs(this.temperatur - m.temperatur) < EPSILON);
	}
	public String toString() {
		return String.format("[%02d:00 Uhr (%s): %.2f Grad, %d%% Feuchte]", this.stunde, this.tageszeit(), this.temperatur, this.luftfeuchtigkeit);
	}
}
