package it.uniroma1.metodologie;



import it.uniroma1.metodologie.Variabile.NomiVariabili;
/**
 * L'interfaccia Eseguibile definisce metodi che codificano e 
 * eseguono delle istruzioni scritte nel linguaggio MiniBASIC
 * @author Federica Magliocca
 *
 */
public interface Eseguibile {
	NomiVariabili[] nomiVariabili= NomiVariabili.values();
	/**
	 * Determina se la stringa in input è un intero
	 * @param s
	 * @return un valore di tipo boolean
	 */
	default boolean isIntero(String s) {
		boolean bool=true;
		for (int i=0;i<s.length();i++) {
			if (!Character.isDigit(s.charAt(i))) bool=false;
		}
		return bool;
	}
	/**
	 * il metodo determina se la stringa in input è una stringa
	 * @param s
	 * @return un valore di tipo booleano
	 */
	default boolean isStringa(String s) {
		return ((s.charAt(0)=='\"')&&(s.charAt(s.length()-1)=='\"'));
	}
	/**
	 * il metodo rimuove le virgolette all'inzio e alla fine della stringa in input
	 * @param s
	 * @return stringa s senza virgolette
	 */
	default String rimuoviVirgolette(String s) {
		if (isStringa(s)) s= s.substring(1,s.length()-1);
		return s;
	}
	/**
	 * il metodo stampa la stringa in input
	 * @param stringaDaStampare
	 * @param p
	 */
	 default void print(String stringaDaStampare,Programma p) {
		boolean bool=false;
		int index=0;
		for (int i=0;i<nomiVariabili.length;i++) {
			if (stringaDaStampare.equals(String.valueOf(nomiVariabili[i]))) {bool=true;index=i;}
		}
		if (!bool) {
			stringaDaStampare=rimuoviVirgolette(stringaDaStampare);
			new Print(new Stringa(stringaDaStampare));
			System.out.println();
		}
		else {
			bool=false;
			for (int j=0;j<p.variabili.size();j++) {
				if (stringaDaStampare.equals(p.variabili.get(j).getNome())) {
					new Print(p.variabili.get(j));
					System.out.println();
					bool=true;
				}
				
		    }
			if (!bool){
			    Variabile v=new Variabile(index);
			    p.variabili.add(v);
			    new Print(v);
			    System.out.println();
		    }
		}
	
	}
	 /**
	  * il metodo controlla il tipo dell'elemento in input
	  * @param elemento
	  * @param p
	  * @return costante inizializzata al valore dell'elemento
	  * @throws ElementoNonValidoException
	  */
	default Costante getCostante(String elemento,Programma p) throws ElementoNonValidoException{
		Costante costante=null;
		if(isIntero(elemento)) {
			try{
				costante=new Intero(Integer.valueOf(elemento));
			}
			catch(InteroNonPositivoException e) {
				System.out.print("non puoi inserire un numero negativo");
				return null;
			}
		}
		else if(isStringa(elemento)) {elemento=rimuoviVirgolette(elemento);costante=new Stringa(elemento);}
		else if (elemento.equals("true")) costante=new Booleano(true);
		else if (elemento.equals("false")) costante=new Booleano(false);
		else {
			boolean bool=false;
			int index=0;
			for (int i=0;i<nomiVariabili.length;i++) {
				if (elemento.equals(String.valueOf(nomiVariabili[i]))) {bool=true;index=i;}
			}
			if (!bool) {
				throw new ElementoNonValidoException();
				
			}
			else {
				bool=false;
				for (int j=0;j<p.variabili.size();j++) {
					if (elemento.equals(p.variabili.get(j).getNome())) {
						costante=p.variabili.get(j).valore;
						bool=true;
					}
					
			    }
				if (!bool){
				    Variabile v=new Variabile(index);
				    p.variabili.add(v);
				    costante=v.valore;
			    }
			}
		
		}
		
		return costante;
	}
	/**
	 * il metodo assegna alla variabile in input il valore della costante in input
	 * @param variabile
	 * @param valore
	 * @param p
	 * @throws ElementoNonValidoException
	 */
	default void assegna(String variabile,Costante valore,Programma p) throws ElementoNonValidoException{
		boolean bool=false;
		int index=0;
		for (int i=0;i<nomiVariabili.length;i++) {
			if (variabile.equals(String.valueOf(nomiVariabili[i]))) {bool=true;index=i;}
		}
		
		if (!bool) {
			throw new ElementoNonValidoException();
		}
		else {
			bool=false;
			for (int j=0;j<p.variabili.size();j++) {
				if (variabile.equals(p.variabili.get(j).getNome())) {
					new Assegnazione(p.variabili.get(j),valore);
					bool=true;
				}
				
				
		    }
			if (!bool){
				Variabile v=new Variabile(index);
				
				p.variabili.add(v);
				new Assegnazione(v,valore);
		    }
		}
	
	}
	/**
	 * il metodo somma gli elementi dell'array in input
	 * @param arrayElementiDaSommare
	 * @param p
	 * @return la somma degli elementi
	 */
	default Costante somma(String[] arrayElementiDaSommare,Programma p) {
		Costante primoElemento=null;
		try{
			primoElemento=getCostante(arrayElementiDaSommare[0],p);
		}
		catch(ElementoNonValidoException e) {
			return null;
		}
		if(arrayElementiDaSommare.length>1) {
			Costante elementoDaSommare=null;
			for(int i=0;i<arrayElementiDaSommare.length-1;i++) {
				try{
					elementoDaSommare=getCostante(arrayElementiDaSommare[i+1],p);
				}
				catch(ElementoNonValidoException e) {
					return null;
				}
				try{
					primoElemento=new Somma(primoElemento,elementoDaSommare).getRisultato();
				}
				catch(VariabileNonInizializzataException e) {
					return null;
				}
				
			}
		}
		return primoElemento;
	}
	/**
	 * il metodo determina il valore dell'espressione booleana in input
	 * @param espressioneBooleana
	 * @param p
	 * @return il valore dell'espressione booleana
	 * @throws ConfrontoNonValidoException
	 */
	default Booleano confronto(String espressioneBooleana,Programma p) throws ConfrontoNonValidoException {
		String[] stringaSpezzata=new String[2];
		String[] elementiDaSommare1;
		String[] elementiDaSommare2;
		String operatore="";
		for (int i=0;i<espressioneBooleana.length();i++) {
			if ((espressioneBooleana.charAt(i)=='=')&&(espressioneBooleana.charAt(i+1)=='=')) { 
				if(espressioneBooleana.split("==").length==2) {
					stringaSpezzata=espressioneBooleana.split(" == ");
					operatore="==";
					break;
				}
				else throw new ConfrontoNonValidoException();
			}
			else if (espressioneBooleana.charAt(i)=='<') {
				
				if (espressioneBooleana.charAt(i+1)=='=') {
					if(espressioneBooleana.split("<=").length==2) {
						stringaSpezzata=espressioneBooleana.split(" <= ");
						operatore="<=";break;
					}
					else throw new ConfrontoNonValidoException();
				}
				else if (espressioneBooleana.charAt(i+1)=='>') {
					
					if(espressioneBooleana.split("<>").length==2) {
						
						stringaSpezzata=espressioneBooleana.split(" <> ");
						
						operatore="<>";
						break;
					}
					else throw new ConfrontoNonValidoException();
				}
				else {	
					if(espressioneBooleana.split("<").length==2) {
						stringaSpezzata=espressioneBooleana.split(" < ");
					    operatore="<";break;
				    }
				    else throw new ConfrontoNonValidoException();
			    }
			}
			else if (espressioneBooleana.charAt(i)=='>') {
				if (espressioneBooleana.charAt(i+1)=='=') {
					if(espressioneBooleana.split(">=").length==2) {
						stringaSpezzata=espressioneBooleana.split(" >= ");
						operatore=">=";break;
					}
					else throw new ConfrontoNonValidoException();
				}
				
				else {	
					if(espressioneBooleana.split(">").length==2) {
						stringaSpezzata=espressioneBooleana.split(" > ");
					    operatore=">";break;
				    }
				    else throw new ConfrontoNonValidoException();
			    }
			}
			
		}
		
		elementiDaSommare1=stringaSpezzata[0].split(" \\+ ");
		if (elementiDaSommare1.length<=1) elementiDaSommare1=elementiDaSommare1[0].split("\\+");
		elementiDaSommare2=stringaSpezzata[1].split(" \\+ ");
		if (elementiDaSommare2.length<=1) elementiDaSommare2=elementiDaSommare2[0].split("\\+");
		Costante risultato1=somma(elementiDaSommare1,p);
		Costante risultato2=somma(elementiDaSommare2,p);
		
		try{
			Confronto c=new Confronto(risultato1,operatore,risultato2);
			return c.getRisultato();
		}
		catch(ElementoNonValidoException e) {
			return null;
		}
		catch(VariabileNonInizializzataException e) {
			return null;
		}
		catch(ConfrontoTipiDiversiException e) {
			return null;
		}
		
	}
	/**
	 * Determina il tipo di espressione in input e la esegue
	 * @param espressione
	 * @param p
	 * @return il risultato dell'espressione
	 */
	default Costante controllaTipoDiEspressione(String espressione,Programma p) {
		boolean bool=false;
		Costante risultato=null;
		String[] elementi;
		for (int i=0;i<espressione.length();i++) {
			if (espressione.charAt(i)=='+') {
				elementi=espressione.split(" \\+ ");
				if (elementi.length<=1) elementi=elementi[0].split("\\+");
				risultato=somma(elementi,p);
				bool=true;
			}
			else if ((espressione.charAt(i)=='=')&&(espressione.charAt(i+1)=='=')||
					(espressione.charAt(i)=='<')||(espressione.charAt(i)=='>')) { 
				try{
					risultato=confronto(espressione,p);
					bool=true;
				}
				catch(ConfrontoNonValidoException e) {
					System.out.print("puoi confrontare solo due espressioni");
					return null;
				}
			}
		}
		if(!bool) {
			try{
				risultato=getCostante(espressione,p);
			}
			catch(ElementoNonValidoException e) {
				return null;
			}
		}
		return risultato;
	}

}
