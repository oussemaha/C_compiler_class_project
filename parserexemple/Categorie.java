package parserexemple;
public enum Categorie{
    EOF,
    VOID, MAIN, ID, INT, FLOAT, BOOL, STRING, IF, ELSE, FOR, SCANF, PUTS,
    SEMICOLON, COMMA, EQUALS, PLUS, MINUS, DIVIDE, MULTIPLY, OPEN_PAREN, CLOSE_PAREN, OPEN_BRACE,
    CLOSE_BRACE, OPEN_BRACKET, CLOSE_BRACKET, LESS_THAN, LESS_THAN_OR_EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, NOT_EQUAL, INCREMENT,
    RETURN, // Ajout pour la grammaire
    ;
      

    


/*La méthode java string toLowerCase () renvoie la chaîne en minuscules. En d'autres termes,
il convertit tous les caractères de la chaîne en minuscules. */


    public String toString() {
        return this.name().toLowerCase();
    }
    /*
La méthode equalsIgnoreCase() compare deux chaînes en ignorant les différences entre
minuscules et majuscules et renvoie « true » si les chaînes sont égales sinon renvoie « false ».
*/
    public static Categorie toCategorie(String s) {
        for(Categorie c:Categorie.values())
            if(c.toString().equalsIgnoreCase(s))
                return c;
        return null;
    }


    /*La méthode ordinal() permet de retrouver le numéro d'ordre d'un élément énuméré,
     dans la liste de tous les éléments d'une énumération. Le premier numéro d'ordre est 0.
    */
    public boolean estTerminal() {
        return ordinal()>=MIN && ordinal()<=MAX;
    }

    public boolean estNonTerminal() {
        return ordinal()>MAX;
    }
}




