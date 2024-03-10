package it.uniroma1.metodologie;
/**
 * La classe estende la superclasse astratta Istruzione
 * @author Federica Magliocca
 *
 */

public class Assegnazione extends Istruzione {
	/**
	 * l'oggetto assegna il valore della costante alla variabile
	 * @param v
	 * @param c
	 */
	public Assegnazione(Variabile v,Costante c) {
		if (c instanceof Stringa) {
			v.valore=(Stringa)v.valore;
			v.valore=((Stringa) c);
		}
		else if (c instanceof Intero) {
			v.valore=(Intero)v.valore;
			v.valore=((Intero) c);
		}
		else {
			v.valore=(Booleano)v.valore;
			v.valore=((Booleano) c);
		}
		
	}
	

}
