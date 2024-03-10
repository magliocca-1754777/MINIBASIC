package it.uniroma1.metodologie;
/**
 * La classe estende la superclasse astratta Espressione
 * @author Federica Magliocca
 *
 */
public class Somma extends Espressione{
	/**
	 * il risultato della somma
	 */
	private Costante somma;
	/**
	 * l'oggetto somma le costanti in input
	 * @param c1
	 * @param c2
	 * @throws VariabileNonInizializzataException
	 */
	public Somma(Costante c1,Costante c2) throws VariabileNonInizializzataException {
		if (c1==null||c2==null) {
			throw new VariabileNonInizializzataException();
		}
		else {
			if (c1.getClass().equals(c2.getClass())) {
				if (c1 instanceof Stringa) {
					String s3=((Stringa)c1).getValore()+((Stringa)c2).getValore();
				    somma=new Stringa(s3);
			    }
	            if (c1 instanceof Intero) {
	        	    int i3=((Intero)c1).getValore()+((Intero)c2).getValore();
	        	    try{
	        	    	somma=new Intero(i3);
	        	    }
	        	    catch(InteroNonPositivoException e) {
	        	    	return;
	        	    }
	            }
	            if (c1 instanceof Booleano) {
	        	    boolean b3=((Booleano)c1).getValore()||((Booleano)c2).getValore();
	        	    somma=new Booleano(b3);
		        }
		    }
		}
	}
	/**
	 * 
	 * @return il campo somma dell'oggetto
	 */
	public Costante getRisultato() {
		return somma;
	}
	
		
		
	

}
