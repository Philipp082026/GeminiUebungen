package aufgaben.exceptions3;

public class SensorStation {
    
    private final String sensorId;
    private boolean verbindungGeoeffnet;
    
    public SensorStation(String sensorId) {
        this.sensorId = sensorId;
        this.verbindungGeoeffnet = false;
    }
    // Objektmethoden
    public void verbinden() {
        this.verbindungGeoeffnet = true;
        System.out.printf("Sensor [%s]: Verbindung hergestellt.%n", this.sensorId);
    }
    public void trennen() {
        this.verbindungGeoeffnet = false;
        System.out.printf("Sensor [%s]: Verbindung sauber getrennt.%n", this.sensorId);
    }
    public double parseUndPruefeMesswert(String rohWert) throws SensorWertAusserhalbException { // da Checked Exception -> zwingend throws + ExceptionsKlassenname
        if (!verbindungGeoeffnet)
            throw new IllegalStateException("Sensor nicht verbunden!");
        if (rohWert == null)
            throw new NullPointerException("Rohwert darf nicht null sein!");
        double helpRohWert = Double.parseDouble(rohWert); // wirft bei Tippfehlern (String rohwert ist nicht in ein double umwandelbar zB: "12a") automatisch eine NumberFormatException (Unchecked Exception), braucht kein throw new, muss aber trotzdem mit try-catch gefangen werden
        if (helpRohWert < -50.0 || helpRohWert > 80.0)
            throw new SensorWertAusserhalbException("Messwert ausserhalb des Messbereichs!", helpRohWert);
        return helpRohWert;
    }
}
