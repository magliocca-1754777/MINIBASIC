package it.uniroma1.metodologie;
/**
 * La classe estende la superclasse astratta Espressione
 * ed è estesa dalle sottoclassi Stringa,Intero e Booleano.
 * L'oggetto Costante rappresenta una costante con un valore di tipo Object
 * @author Federica Magliocca
 *
 */
abstract public class Costante extends Espressione{
	/**
	 * 
	 * @return il valore della costante
	 */
	abstract public Object getValore();

}
