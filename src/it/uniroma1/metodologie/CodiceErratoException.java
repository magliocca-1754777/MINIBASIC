package it.uniroma1.metodologie;
/**
 * La classe estende la classe Exception
 * Segnala la presenza di un'eccezione su una riga di codice  
 * @author Computer
 *
 */
public class CodiceErratoException extends Exception{
	public CodiceErratoException() {
		super("codice errato");
		
	}
    
}
