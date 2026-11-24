package aufgaben.exceptions1;

public class GuhabenNichtAusreichendException extends Exception { // Da von der Klasse Exception geerbt wird, ist die Klasse GuthabenNicht... eine Checked Exception, die der Compiler zwingend überwacht
    
    private final double fehlbetrag;
    
    public GuhabenNichtAusreichendException(String nachricht, double fehlbetrag) {
        super(nachricht); // Damit wird der Fehlertext an die Basisklasse Throwable übergeben -> Abfrage über die Standardmethode getMessage()
        this.fehlbetrag = fehlbetrag;        
    }
    public double getFehlbetrag() {
        return this.fehlbetrag;
    }
}
