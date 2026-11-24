package aufgaben.exceptions4;

public class UngueltigeKundenDatenException extends BuchungException{ // Checked Exception
    
    public UngueltigeKundenDatenException(String detailMeldung) {
        super(detailMeldung, 102);
    }

}
