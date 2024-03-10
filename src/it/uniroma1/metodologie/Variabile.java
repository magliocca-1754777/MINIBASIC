package it.uniroma1.metodologie;
/**
 * La classe estende la superclasse Espressione
 * @author Federica Magliocca
 *
 */
public class Variabile extends Espressione{
	/**
	 * enumera i nomi delle variabili
	 * @author Federica Magliocca
	 *
	 */
	public enum NomiVariabili{
		$0,$1,$2,$3,$4,$5,$6,$7,$8,$9;
	}
	private NomiVariabili nome;
	public Costante valore;
	/**
	 * array di nomi delle variabili
	 */
	private NomiVariabili[] nomiVariabili=NomiVariabili.values();
	/**
	 * L'oggetto rappresenta una variabile.
	 * assegna al campo nome il nome della variabile
	 * ottenuto dall'array nomiVariabili in base all'indice in input
	 * @param indice dell'array
	 */
	public Variabile(int indice) {
		nome=nomiVariabili[indice];
	}
	/**
	 * 
	 * @return valore della variabile
	 */
	public Costante getValore() {
		return valore;
	}
	/**
	 * 
	 * @return nome della variabile
	 */
	public String getNome() {
		return String.valueOf(nome);
	}

}
