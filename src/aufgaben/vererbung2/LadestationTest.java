package aufgaben.vererbung2;

public class LadestationTest {

    public static void main(String[] args) {
        
        Aufladbar[] ladestation = new Aufladbar[3];
        ladestation[0] = new AkkuBohrer("Bosch GSR", 40);
        ladestation[1] = new Powerbank(20000);
        ladestation[2] = new AkkuBohrer("Makita DDF", 85);
        
        System.out.printf("%n--------------- 1. Ladevorgang (+50%%) fuer alle Geraete ----------------%n");
        for (Aufladbar geraet : ladestation) {
            geraet.aufladen(50);
        }
        System.out.printf("%n----------------- Status-Uebersicht an der Ladestation -------------------%n");
        for (int i = 0; i < ladestation.length; i++) {
            System.out.printf("Platz %d: %s (Voll geladen? %b)%n",
                    i + 1,
                    ladestation[i].statusText(),
                    ladestation[i].getLadestand() == Aufladbar.MAX_LADESTAND);
        }
    }
}
