package aufgaben.exceptions4;

public class BuchungException extends Exception{ // Checked Exception
    
    private final int fehlerCode;
    
    public BuchungException(String nachricht, int fehlerCode) {
        super(nachricht);
        this.fehlerCode = fehlerCode;
    }
    public int getFehlerCode() {
        return this.fehlerCode;
    }

}
