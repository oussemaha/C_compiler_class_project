package parserexemple;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*La ArrayListclasse est un tableau redimensionnable , qui peut être trouvé dans le java.utilpackage.

La différence entre un tableau intégré et un tableau ArrayListen Java,
est que la taille d'un tableau ne peut pas être modifiée (si vous voulez ajouter ou supprimer des éléments dans / d'un tableau,
 vous devez en créer un nouveau).
Alors que des éléments peuvent être ajoutés et supprimés d'un ArrayListfichier quand vous le souhaitez.
*/

public class Scanner {
    public ArrayList<Character> fluxCaracteres;
    private int indiceCourant;
    private char caractereCourant;
    public boolean eof;
    private String[] vars={};

    public Scanner() {
        this("");
    }

    public Scanner(String nomFich) {
        BufferedReader f=null;
        int car=0;
        fluxCaracteres=new ArrayList<Character>();
        indiceCourant=0;
        eof=false;
        try {
            f=new BufferedReader(new FileReader(nomFich));
        }
        catch(IOException e) {
            System.out.println("taper votre texte ci-dessous (ctrl+z pour finir)");
            f=new BufferedReader(new InputStreamReader(System.in));
        }

        try {
            while((car=f.read())!=-1)
                fluxCaracteres.add((char)car);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void caractereSuivant() {
        if(indiceCourant<fluxCaracteres.size())
            caractereCourant=fluxCaracteres.get(indiceCourant++);
        else
            eof=true;
    }

    public void reculer() {
        if(indiceCourant>0)
            indiceCourant--;
    }

   public UniteLexicale lexemeSuivant() {
		caractereSuivant();
		
		while(eof || Character.isWhitespace(caractereCourant)) { 
			if (eof)
				return new UniteLexicale(Categorie.EOF, "0");
			caractereSuivant();
		}
		
		if(Character.isLetter(caractereCourant))
			return get_Word();
		
		if(Character.isDigit(caractereCourant))
			return getNombre();
		
		if(caractereCourant==':')
			return getOPPAff();
		
		if(caractereCourant==';')
			return new UniteLexicale(Categorie.PONCTUATION, ";");
               
		if(caractereCourant=='<' || caractereCourant=='>' ||caractereCourant=='=')
			return getOPRel();
		switch (caractereCourant) {
            case '(':
                return new UniteLexicale(Categorie.PONCTUATION,caractereCourant);
            case ')':
                return new UniteLexicale(Categorie.PONCTUATION,caractereCourant);
            case '{':
                return new UniteLexicale(Categorie.PONCTUATION,caractereCourant);
            case '}':
                return new UniteLexicale(Categorie.PONCTUATION,caractereCourant);
            case ',':
                return new UniteLexicale(Categorie.PONCTUATION,caractereCourant);
            case '\'':
                return new UniteLexicale(Categorie.PONCTUATION,caractereCourant);
            case '*':
                return new UniteLexicale(Categorie.OPARITH,"*");
            case '/':
                return new UniteLexicale(Categorie.OPARITH,"/");
            case '+':
                caractereSuivant();
                if (caractereCourant=='+') return new UniteLexicale(Categorie.OPARITH,"++");
                return new UniteLexicale(Categorie.OPARITH,"+");
        }
		
		return null;
	}
	
	public UniteLexicale get_Word() {
		int etat=0;
		StringBuffer sb=new StringBuffer();
		while(true) {
			switch(etat) {
				case 0 : etat=1; 
						 sb.append(caractereCourant); 
						 break;
				case 1 : caractereSuivant();
						 if(eof)
							 etat=3;
						 else
							 if(Character.isLetterOrDigit(caractereCourant)) 
								 sb.append(caractereCourant);
							 else
								 etat=2;
						 break;
				case 2 : reculer();
						 return detectWord(sb.toString());
				case 3 : return detectWord(sb.toString());
			}
		}
	}
	public UniteLexicale detectWord( String word){
        switch(word){
            case "void":
                return new UniteLexicale(Categorie.INST,word);
            case "main":
                return new UniteLexicale(Categorie.INST, word);
            case "if":
                return new UniteLexicale(Categorie.INST, word);
            case "else":
                return new UniteLexicale(Categorie.INST, word);
            case "for":
                return new UniteLexicale(Categorie.INST, word);
            case "int":
                return new UniteLexicale(Categorie.TYPE_VAR, word);
            case "float":
                return new UniteLexicale(Categorie.TYPE_VAR, word);
            case "bool":
                return new UniteLexicale(Categorie.TYPE_VAR, word);
            case "string":
                return new UniteLexicale(Categorie.TYPE_VAR, word);
            case "puts":
                return new UniteLexicale(Categorie.INST, word);
            case "scanf":
                return new UniteLexicale(Categorie.INST, word);
            case "d":
                return new UniteLexicale(Categorie.Format, word);
            case "f":
                return new UniteLexicale(Categorie.Format, word);
            case "s":
                return new UniteLexicale(Categorie.Format, word);
            default:
                return treatID(word);
        }

    }
    public UniteLexicale treatID(String name){
        int index=findIndexInStringArray( name);
        if(index!=-1){
            return new UniteLexicale(Categorie.ID,name,index);
        }
        addItemToStringArray(name);
        return new UniteLexicale(Categorie.ID,name,vars.length-1);
    } 
    public void addItemToStringArray( String newItem){ 
        String[] vars1 = new String[vars.length + 1];

        for (int i = 0; i < vars.length; i++) {
            vars1[i] = vars[i];
        }
        vars1[vars.length]=newItem;
       vars=vars1;
    }
    public  int findIndexInStringArray( String item) {
        for (int i = 0; i < vars.length; i++) {
            if (vars[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
	public UniteLexicale getNombre() {
		int etat=0;
		StringBuffer sb=new StringBuffer();
		while(true) {
			switch(etat) {
			case 0 : etat=1; 
					 sb.append(caractereCourant); 
					 break;
			case 1 : caractereSuivant();
					 if(eof)
						 etat=3;
					 else
						 if(Character.isDigit(caractereCourant)) 
							 sb.append(caractereCourant);
						 else
							 etat=2;
					 break;
			case 2 : reculer();
					 return new UniteLexicale(Categorie.NB, sb.toString());
			case 3 : return new UniteLexicale(Categorie.NB, sb.toString());
			}
		}
		
	}
   

public UniteLexicale getOPPAff() {
        int etat = 0;
        StringBuffer sb = new StringBuffer();
        while (true) {
            switch (etat) {
                case 0:
                    if (eof)
                        break;
                    else if (caractereCourant == ':') {
                        sb.append(caractereCourant);
                        caractereSuivant();
                        etat = 1;

                    } else
                        break;

                case 1:
                    if (eof)
                        break;
                    else if (caractereCourant == '=') {
                        sb.append(caractereCourant);
                        caractereSuivant();
                        etat = 2;
                        
                    } else
                        break;
                
                case 2:
                    if (eof)
                        etat = 3;
                    else
                        etat = 5;
                case 3:
                   
                    return new UniteLexicale(Categorie.OPARITH, sb.toString());
                case 4:
                    reculer();
                    return new UniteLexicale(Categorie.OPARITH, sb.toString());
                
                     

            }

        }
}


public UniteLexicale getOPRel() {
        int etat = 0;
        StringBuffer sb = new StringBuffer();
        while (true) {
            switch (etat) {
                case 0:
                    if (eof)
                        break;
                    else if (caractereCourant == '=') {
                        sb.append(caractereCourant);
                        caractereSuivant();
                         etat = 1;
                         break;

                          } else if (caractereCourant == '>') {
                               sb.append(caractereCourant);
                               caractereSuivant();
                               
                               etat = 2;
                               break;
                           }
                          else if (caractereCourant == '<') {
                               sb.append(caractereCourant);
                               caractereSuivant();
                               etat = 3;
                               break;
                           }
                        else 
                        break;


                case 1:
                    if (eof){
                        return new UniteLexicale(Categorie.OPREL, "=");
                        }
                    else {
                        reculer();
                        return new UniteLexicale(Categorie.OPREL, "=");
                    }
                    
                
                case 2:
                    if (eof)
                        break;
                    else if (caractereCourant == '=') {
                        sb.append(caractereCourant);
                        caractereSuivant();
                        etat = 4 ;
                          } 
                         else
                             etat =5;
                            break;

                case 3:
                     if (eof)
                         break;
                    else if (caractereCourant == '=') {
                        sb.append(caractereCourant);
                        caractereSuivant();
                        etat = 6 ;
                        break;
                          } 


                 case 4:
                    if (eof){
                        return new UniteLexicale(Categorie.OPREL, ">=");
                        }
                    else {
                        reculer();
                        return new UniteLexicale(Categorie.OPREL, ">=");}
               case 5:
                    if (eof){
                        return new UniteLexicale(Categorie.OPREL, ">");
                        }
                    else {
                        reculer();
                        return new UniteLexicale(Categorie.OPREL, ">");}

                case 6:
                    if (eof){
                        return new UniteLexicale(Categorie.OPREL, "<=");
                        }
                    else{ 
                        reculer();
                        return new UniteLexicale(Categorie.OPREL, "<=");}
            }

        }
}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fluxCaracteres.toString();
	}
	
	
}
