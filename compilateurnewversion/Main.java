package compilateurnewversion;






import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import TPIF3PARSER.parserIF3;
import TPIF3PARSER.anallex;


public class Main {
    public static void main(String[] args) {
    	
    	anallex anaLex=new anallex();
		anaLex.lecture();
		
		 /*  System.out.println("remplissage du tableaullll");
		 for( int i=0; i<anaLex.fluxCaracteres.size();i++)
		       	
		       	System.out.println(" " + 
		       			anaLex.fluxCaracteres.get(i));*/
		System.out.println("***********************Analyse lexical*************************");
		 int taille= anaLex.fluxCaracteres.size();
    	String tab[]= new String[taille];
    	String ss=" ";
    	 for( int i=0; i<anaLex.fluxCaracteres.size();i++)
    		// if (!tab[i].equals(ss))
    		 tab[i]= anaLex.fluxCaracteres.get(i);
    	 
    	 for( int i=0; i<taille;i++)
		       	
		       	System.out.println(tab[i]);
    	 System.out.println("***********************Analyse Syntaxique*************************");	 
    	 
		 parsernew test22 = new parserIF3();
    	
        
        test22.analyzeSLnew(tab);
        
    }
}

