package aufgaben.exceptions2;
// Unchecked Exception
public class UngueltigeKapazitaetException extends RuntimeException { // Wenn man von der RuntimeException erbt, müssen Methoden, die diese Exception werfen, keine "throws" im Methodenkopf notieren. 
                                                                      // Der Compiler zwingt einen nicht, die Exception mit einem try-catch zu fangen, man kann aber dennoch die Ausnahme abfangen.
    // Konstruktoren
    public UngueltigeKapazitaetException(String meldung) {
        super(meldung);
    }
    public UngueltigeKapazitaetException(int fehlerhafteKapazitaet) {
        super("Ungueltige Kapazitaet angegeben: " + fehlerhafteKapazitaet);
    }
    
    

}
