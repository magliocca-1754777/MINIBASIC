package it.uniroma1.metodologie;
/**
 * La classe rappresenta una Costante di tipo Stringa
 * @author Federica Magliocca
 *
 */
public class Stringa extends Costante{
	private String valore;
	/**
	 * assegna il valore in input al campo dell'oggetto
	 * @param valore di tipo String
	 */
	public Stringa(String valore) {
		this.valore=valore;
	}
	/**
	 * @return valore del campo dell'oggetto
	 */
	public String getValore() {
		return valore;
	}

}
