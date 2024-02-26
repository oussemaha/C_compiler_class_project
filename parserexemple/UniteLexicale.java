package parserexemple;


public class UniteLexicale {
    public Categorie categorie;
    public Object lexeme;
    public int idVar=-1;
    public UniteLexicale(Categorie categorie, Object lexeme, int idVar) {
        this.categorie=categorie;
        this.lexeme=lexeme;
        this.idVar=idVar;
    }
    public UniteLexicale(Categorie categorie, Object lexeme) {
        this.categorie=categorie;
        this.lexeme=lexeme;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String toString() {
        if (idVar==-1)
            return categorie.toString()+"\t"+lexeme;
        return categorie.toString()+"\t"+lexeme+"\t"+idVar+"#";
    }

}
