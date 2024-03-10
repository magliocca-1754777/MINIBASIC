package it.uniroma1.metodologie;
/**
 * La classe estende la classe Exception.
 * Segnala la presenza di un'eccezione su un'espressione booleana
 * se costituita da espressioni di tipo diverso
 * @author Federica Magliocca
 *
 */
public class ConfrontoTipiDiversiException extends Exception {
	public ConfrontoTipiDiversiException() {
		super("non è possibile confrontare tipi diversi");
	}

}
