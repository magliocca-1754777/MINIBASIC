package it.uniroma1.metodologie;
/**
 * La classe estende la classe Exception.
 * Segnala la presenza di un intero non positivo
 * @author Federica Magliocca
 *
 */
public class InteroNonPositivoException extends Exception {
	public InteroNonPositivoException() {
		super("l'intero deve essere positivo");
	}

}
