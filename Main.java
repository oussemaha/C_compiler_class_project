
import anaLex.Scanner;
import anaLex.UniteLexicale;
import anaSyn.anaSLR;

public class Main {
	static String  ch[]= {};
    public static void main(String[] args) {
    	UniteLexicale temp;
    	Scanner anaLex=new Scanner();
		
		   /*System.out.println("remplissage du tableaullll");
		 for( int i=0; i<anaLex.fluxCaracteres.size();i++)
		       	
		       	System.out.println(" " + 
		       			anaLex.fluxCaracteres.get(i));*/
		System.out.println("***********************Analyse lexical*************************");
		 int taille= anaLex.fluxCaracteres.size();
    	 for( int i=0; i<taille & !anaLex.eof;i++){
			temp=anaLex.lexemeSuivant();
    		System.out.println(temp.toString());
			if ( temp.categorie.toString().equals("id") ){
				addItemToStringArray("id");
			}
			else if ( temp.categorie.toString().equals("nb") ){
				addItemToStringArray("nb");
			}
			else if ( temp.categorie.toString().equals("ch") ){
				addItemToStringArray("ch");
			}
			else addItemToStringArray(temp.lexeme.toString());
		 }
		 ch[ch.length-1]="$";
    	System.out.println("***********************Analyse Syntaxique*************************");	 
    	 
		 anaSLR analSyn = new anaSLR(ch);
    	
        
        analSyn.analyzeSLnew();
        
    }
	public static void addItemToStringArray( String newItem){ 
        String[] ch1 = new String[ch.length + 1];

        for (int i = 0; i < ch.length; i++) {
            ch1[i] = ch[i];
        }
        ch1[ch.length]=newItem;
       ch=ch1;
    }
}