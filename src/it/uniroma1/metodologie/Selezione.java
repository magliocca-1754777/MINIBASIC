package it.uniroma1.metodologie;
/**
 * La classe estende la superclasse astratta Istruzione
 * @author Federica Magliocca
 * @see Eseguibile
 */

public class Selezione extends Istruzione implements Eseguibile{
	/**
	 * istruzioni da eseguire
	 */
	private String[] istruzioni;
	/**
	 * il programma in esecuzione che richiama l'istruzione Selezione
	 */
	private Programma programma;
	/**
	 * l'oggetto seleziona le istruzioni da eseguire in base al valore del Booleano in input
	 * @param confronto
	 * @param istruzione1
	 * @param istruzione2
	 * @param p
	 */
	public Selezione(Booleano confronto,String istruzione1,String istruzione2,Programma p) {
		this.programma=p;
		if (confronto.getValore()) istruzioni=istruzione1.split(" : ");
		else istruzioni=istruzione2.split(" : ");
		for (int i=0;i<istruzioni.length;i++) {
			eseguiIstruzioni(istruzioni[i]);
		}
	}
	/**
	 * l'oggetto esegue l'istruzione in input se il valore del Booleano in input è true
	 * @param confronto
	 * @param istruzione
	 * @param p 
	 */
	public Selezione(Booleano confronto,String istruzione,Programma p) {
		programma=p;
		if (confronto.getValore()) {
			istruzioni=istruzione.split(" : ");
		    for (int i=0;i<istruzioni.length;i++) {
		    	eseguiIstruzioni(istruzioni[i]);
		    }
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
			else if (istruzione.substring(0,3).equals("END")) {
				programma.i=programma.istruzioni.size();
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
		else if (istruzione.length()>=3) {
			if (istruzione.substring(0,3).equals("END")) {
				programma.i=programma.istruzioni.size();
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
	}




}
