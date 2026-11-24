package aufgaben.vererbung1;

public class GeraetTest {

    public static void main(String[] args) {

        Geraet g1 = new Geraet("Samsung", 2024);
        Smartphone s1 = new Smartphone("Samsung", 2024, 128);
        Smartphone s2 = new Smartphone("Samsung");
        Smartphone s3 = new Smartphone("Samsung", 2024, 256);
        
         /* Geraet g4 = new Smartphone("Nokia", 2002, 16);
        Smartphone helpS5 = (Smartphone) g4; // expliziter Typecast
        g1 = new Smartphone(g1.getHersteller(), g1.getBaujahr(), 64); // g1 zeigt nicht auf Smartphone, sondern auf Geraet, deshalb muss zuerst ein Objekt Smartphone (spezielleres Objekt) erstellt werden, damit ein expliziter Typecast funktioniert
        Smartphone helpS6 = (Smartphone) g1; // expliziter TYpecast
        Geraet helpG2 = s1; // impliziter Typecast
        System.out.println(helpS5.toString()); // toString() von der Klasse Smartphone wird aufgerufen
        System.out.println(helpS6.toString()); // toString() von der Klasse Smartphone wird aufgerufen
        System.out.println(helpG2.toString()); // toString() von der Klasse Geraet wird aufgerufen
        System.out.println(helpS5.getClass().getSimpleName());
        System.out.println(helpG2.getClass().getSimpleName());
        System.out.println(g4.getClass());
        System.out.println(g4.getClass().getSimpleName());
        System.out.println(g4 instanceof Geraet);
        System.out.println(g4 instanceof Smartphone);
        System.out.println(s3 instanceof Geraet);
        System.out.println(s3 instanceof Smartphone);
        System.out.println(g1 instanceof Geraet);
        System.out.println(g1 instanceof Smartphone); */
        
        System.out.printf("%n----------- Ausgabe mit toString() & getClass() ---------------%n");
        System.out.printf("g1 (%s): %s%n", g1.getClass().getSimpleName(), g1.toString());
        System.out.printf("s1 (%s): %s%n", s1.getClass().getSimpleName(), s1.toString());
        System.out.printf("s2 (%s): %s%n", s2.getClass().getSimpleName(), s2.toString()); 
        
        System.out.printf("%n------------------- Vergleiche mit == vs. equals() ---------------------------%n");
        System.out.printf("s1 == s2 (Referenzvergleich):     %b%n", (s1 == s2));
        System.out.printf("s1.equals(s2) (gleiche Werte):    %b%n", s1.equals(s2));
        System.out.printf("s1.equals(s3) (anderer Speicher): %b%n", s1.equals(s3));
        System.out.printf("g1.equals(s1) (andere Klasse):    %b%n", g1.equals(s1));
    }

}
