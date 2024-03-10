package it.uniroma1.metodologie;
/**
 * La classe rappresenta una Costante di tipo Booleano
 * @author Federica Magliocca
 *
 */
public class Booleano extends Costante{
	private boolean valore;
	/**
	 * assegna il valore in input al campo dell'oggetto
	 * @param valore di tipo boolean
	 */
	public Booleano(boolean valore) {
		this.valore=valore;
	}
	/**
	 * @return il campo valore dell'oggetto
	 */
	public Boolean getValore() {
		return valore;
	}

}
