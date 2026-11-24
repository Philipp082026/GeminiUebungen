package aufgaben.exceptions3;

public class SensorWertAusserhalbException extends Exception { // Checked Exception
    
    private final double fehlerhafterWert;
    
    public SensorWertAusserhalbException(String nachricht, double fehlerhafterWert) {
        super(nachricht);
        this.fehlerhafterWert = fehlerhafterWert;
    }
    public double getFehlerhafterWert() {
        return this.fehlerhafterWert;
    }
}
