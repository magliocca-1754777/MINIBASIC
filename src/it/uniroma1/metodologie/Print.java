package it.uniroma1.metodologie;
/**
 * La classe estende la superclasse astratta Istruzione
 * @author Federica Magliocca
 *
 */
public class Print extends Istruzione{
	/**
	 * l'oggetto stampa la stringa in input
	 * @param stringa
	 */
	public Print(Stringa stringa) {
		System.out.print(stringa.getValore());
	}
	/**
	 * l'oggetto stampa il valore della variabile in input
	 * @param variabile
	 */
	public Print(Variabile variabile) {
		if (variabile.getValore()==null) System.out.print("null");
		else System.out.print(variabile.getValore().getValore());
	}
	

}
