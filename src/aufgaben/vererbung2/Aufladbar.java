package aufgaben.vererbung2;

public interface Aufladbar {
    
    // Konstante, jede Variable ist in einem Interface automatisch public static final, auch wenn man diese Schlüsselwörter weglässt
    public static final int MAX_LADESTAND = 100;
    
    // Methodenköpfe, im Intercae ohne geschweifte Klammern, haben automatisch die Schlüsselwörter public und abstract, auch wenn man diese weglässt
    public abstract void aufladen(int prozent);
    public abstract int getLadestand();
    public abstract String statusText();
}
