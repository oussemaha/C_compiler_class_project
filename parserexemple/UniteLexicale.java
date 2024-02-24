package parserexemple;


public class UniteLexicale {
    private Categorie categorie;
    private Object lexeme;

    public UniteLexicale(Categorie categorie, Object lexeme) {
        this.categorie=categorie;
        this.lexeme=lexeme;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String toString() {
        return "<"+categorie.toString()+","+lexeme+">";
    }
}
