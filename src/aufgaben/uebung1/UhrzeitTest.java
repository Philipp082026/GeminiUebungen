package aufgaben.uebung1;

public class UhrzeitTest {
	
	public static void main(String[] args) {
		
		Uhrzeit u1 = new Uhrzeit(8, 5);
		Uhrzeit u2 = new Uhrzeit(14, 45);
		Uhrzeit u3 = new Uhrzeit(23, 50);
		Uhrzeit u4 = new Uhrzeit();
		Uhrzeit u5 = new Uhrzeit(u1);
		Uhrzeit u6 = new Uhrzeit(25, 130);
		
		System.out.printf("%n%n------------------------- Uhrzeiten & Rechnen ---------------------------%n%n");
		System.out.printf("u1: %s (in Mintuen: %d)%n", u1.toString(), u1.inMinuten());
		System.out.printf("u4 (Standard): %s%n", u4.toString());
		System.out.printf("u5 (Kopie von u1): %s%n", u5.toString());
		System.out.printf("u6 (Normalisiert aus 25h 130m): %s%n", u6.toString());
		System.out.printf("%s + 70 Min. = %s%n", u1.toString(), u1.plusMinuten(70).toString());
		System.out.printf("%s + 25 Min. = %s%n", u3.toString(), u3.plusMinuten(25).toString());
		System.out.printf("Differenz %s zu %s = %s%n", u1.toString(), u2.toString(), u1.differenz(u2).toString());
		System.out.printf("Differenz %s zu %s = %s%n", u2.toString(), u1.toString(), u2.differenz(u1).toString());
		
		System.out.printf("%n%n------------------------- Vergleichen -----------------------------------%n%n");
		System.out.printf("%s < %s ? %b%n", u1.toString(), u2.toString(), u1.istFrueherAls(u2));
		System.out.printf("%s >  %s ? %b%n", u1.toString(), u2.toString(), u1.istSpaeterAls(u2));
		System.out.printf("%s == %s ? %b%n", u1.toString(), u2.toString(), u1.istGleich(u2));
		System.out.printf("%s == %s ? %b%n", u1.toString(), u5.toString(), u1.istGleich(u5));
	}
}
