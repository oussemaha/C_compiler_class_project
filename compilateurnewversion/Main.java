package compilateurnewversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import parserexemple.Scanner;


public class Main {
    public static void main(String[] args) {
    	
    	Scanner anaLex=new Scanner();
		
		   /*System.out.println("remplissage du tableaullll");
		 for( int i=0; i<anaLex.fluxCaracteres.size();i++)
		       	
		       	System.out.println(" " + 
		       			anaLex.fluxCaracteres.get(i));*/
		System.out.println("***********************Analyse lexical*************************");
		 int taille= anaLex.fluxCaracteres.size();
    	String tab[]= new String[taille];
    	String ss="";
    	 for( int i=0; i<taille & !anaLex.eof;i++)
			    		// if (!tab[i].equals(ss))
    		System.out.println(anaLex.lexemeSuivant().toString());
    	 
    	 /* System.out.println("***********************Analyse Syntaxique*************************");	 
    	 
		 parserIF3 test22 = new parserIF3();
    	
        
        test22.analyzeSLnew(tab);*/
        
    }
}

