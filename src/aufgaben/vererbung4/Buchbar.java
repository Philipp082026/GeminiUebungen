package aufgaben.vererbung4;

public interface Buchbar {
    
 // Methodenköpfe, im Intercae ohne geschweifte Klammern, haben automatisch die Schlüsselwörter public und abstract, auch wenn man diese weglässt
    public abstract boolean buchen(String nutzer);
    public abstract void stornieren();
    public abstract boolean istFrei();
}
