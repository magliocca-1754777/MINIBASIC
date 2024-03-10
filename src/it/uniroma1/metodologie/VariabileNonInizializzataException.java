package it.uniroma1.metodologie;
/**
 * La classe estende la superclasse Exception.
 * Segnala l'utilizzo di una variabile non inizializzata
 * @author Federica Magliocca
 *
 */
public class VariabileNonInizializzataException extends Exception{
	public VariabileNonInizializzataException() {
		super("variabile non inizializzata");
	}

}
