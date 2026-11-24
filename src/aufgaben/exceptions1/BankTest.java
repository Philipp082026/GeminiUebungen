package aufgaben.exceptions1;

public class BankTest {

    public static void main(String[] args) {

        Konto k = new Konto("Anna Schmidt", 150.0);
        System.out.printf("------------------ 1. Gueltige Abhebung ------------------%n");
        try {   
            k.abheben(50.0);    // Aufrufe von Methoden, die eine Checked Exception deklarieren, müssen in einen `try`\-Block gefasst werden. 
        } catch (GuhabenNichtAusreichendException ex) { // Tritt die Ausnahme auf, springt das Programm sofort in den passenden `catch`\-Block, liest die Fehlerursache aus und bricht nicht ab.
            System.err.println("Fehler: " + ex.getMessage());
        }
        System.out.printf("%n---------------- 2. Ungueltige Abhebung (Ueberziehung) ---------------------%n");
        try {   
            k.abheben(200.0);   // Aufrufe von Methoden, die eine Checked Exception deklarieren, müssen in einen `try`\-Block gefasst werden. 
        } catch (GuhabenNichtAusreichendException ex) {
            System.out.printf("GEFANGEN: %s%n", ex.getMessage());
            System.out.printf("Benoetigter Fehlbetrag: %.2f EUR%n", ex.getFehlbetrag());
        }
        System.out.printf("%nAktueller Kontostand am Ende: %.2f EUR%n", k.getGuthaben());
    }

}
