package it.uniroma1.metodologie;

import java.util.Arrays;

/**
 * La classe estende la superclasse astratta Istruzione
 * @author Federica Magliocca
 * @see Eseguibile
 */
public class Iterazione extends Istruzione implements Eseguibile {
	/**
	 * il programma in esecuzione che richiama l'istruzione Iterazione
	 */
	private Programma programma;
	/**
	 * istruzioni da eseguire
	 */
	private String[] istruzioni;
	/**
	 * l'oggetto richiama il metodo eseguiIstruzioni finchè il valore dell'espressione
	 * booleana presa in input è true
	 * @param confronto
	 * @param istruzione
	 * @param p
	 */
	public Iterazione(String confronto,String istruzione,Programma p) {
		programma=p;
		
		try {
		    while(confronto(confronto,p).getValore()) {
		    	
		    	istruzioni=istruzione.split(" : ");
				for (int i=0;i<istruzioni.length;i++) {
					eseguiIstruzioni(istruzioni[i]);
			    }
				
		    }
		}
		catch(ConfrontoNonValidoException e) {
	    	System.out.print("puoi confrontare solo due espressioni");
	     }
	}
	/**
	 * esegue l'istruzione
	 * @param istruzione
	 */
	public void eseguiIstruzioni(String istruzione) {
		if (istruzione.length()>=5) {
			if (istruzione.substring(0,5).equals("PRINT")) {
				String[] DaStampare=istruzione.split("PRINT ");
				print(DaStampare[1],programma);
		    }
			else {
				String[] elementi=istruzione.split(" = ");
				Costante c=controllaTipoDiEspressione(elementi[1],programma);
				try{
					assegna(elementi[0],c,programma);
				}
				catch(ElementoNonValidoException e) {
					return;
				}
			}
		}
		else if (istruzione.length()>=4) {
			String[] elementi=istruzione.split(" = ");
			Costante c=controllaTipoDiEspressione(elementi[1],programma);
			try{
				assegna(elementi[0],c,programma);
			}
			catch(ElementoNonValidoException e) {
				return;
			}
			
		}
	}
}
