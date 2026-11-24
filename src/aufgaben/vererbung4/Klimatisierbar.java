package aufgaben.vererbung4;

public interface Klimatisierbar {
    
    // Konstante, jede Variable ist in einem Interface automatisch public static final, auch wenn man diese Schlüsselwörter weglässt
    public static final double STANDARD_TEMP = 21.0;
    public static final double MIN_TEMP = 16.0;
    public static final double MAX_TEMP = 26.0;
    
    // Methodenköpfe, im Intercae ohne geschweifte Klammern, haben automatisch die Schlüsselwörter public und abstract, auch wenn man diese weglässt
    public abstract void regleTemperatur(double zielTemp);
    public abstract double getTemperatur();
}
