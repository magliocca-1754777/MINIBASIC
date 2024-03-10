package it.uniroma1.metodologie;
/**
 * La classe estende la classe Exception.
 * Segnala la presenza di un'eccezione su un espressione booleana
 * se costiutita da più di 2 espressioni
 * @author Federica Magliocca
 *
 */
public class ConfrontoNonValidoException extends Exception{
	public ConfrontoNonValidoException() {
		super("confronto non valido");
	}

}
