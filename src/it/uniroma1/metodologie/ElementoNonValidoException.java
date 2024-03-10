package it.uniroma1.metodologie;
/**
 * La classe estende la classe Exception.
 * Segnala la presenza di un tipo di dato indefinito
 * @author Federica Magliocca
 *
 */
public class ElementoNonValidoException extends Exception {
	public ElementoNonValidoException() {
		super("tipo di dato indefinito");
	}

}
