package aufgaben.vererbung4;

public class CampusTest {

    public static void main(String[] args) {
       
        Hoersaal h1 = new Hoersaal("A-101", 120);
        Hoersaal h2 = new Hoersaal("B-202", 80, false);
        Dienstwagen dw1 = new Dienstwagen("L-UNI 1");

        System.out.printf("%n----------------------- 1. Buchungsvorgaenge ueber Interface Buchbar -------------------%n");
        Buchbar[] buchbareObjekte = { h1, h2, dw1 };
        buchbareObjekte[0].buchen("Prof. Mueller");
        buchbareObjekte[0].buchen("Prof. Weber"); // Abgelehnt, da schon belegt!
        buchbareObjekte[2].buchen("Dr. Schmidt");

        int freieObjekte = 0;
        for (Buchbar b : buchbareObjekte) {
            if (b.istFrei()) {
                freieObjekte++;
            }
        }
        System.out.printf("Aktuell noch frei buchbare Objekte: %d von %d%n", freieObjekte, buchbareObjekte.length);

        System.out.printf("%n-------------------------- 2. Klimatisierung ueber Interface Klimatisierbar ------------------------%n");
        Klimatisierbar[] klimaObjekte = { h1, h2, dw1 };
        klimaObjekte[0].regleTemperatur(19.5);
        klimaObjekte[1].regleTemperatur(12.0); // Zu kalt -> wird auf MIN_TEMP (16,00) begrenzt
        klimaObjekte[2].regleTemperatur(28.5); // Zu warm -> wird auf MAX_TEMP (26,00) begrenzt

        System.out.printf("%n---------------------- 3. Gesamtstatus & baulicher Vergleich (equals) ---------------------------%n");
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(dw1.toString());

        Hoersaal h1Nachbau = new Hoersaal("A-101", 120, true);
        System.out.printf("Ist h1 baulich gleich h1Nachbau (trotz Buchung/Klima)? %b%n", h1.equals(h1Nachbau));
        System.out.printf("Ist h1 gleich dw1?                                     %b%n", h1.equals(dw1));
    }

}
