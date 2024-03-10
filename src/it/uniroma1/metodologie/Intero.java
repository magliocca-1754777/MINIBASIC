package it.uniroma1.metodologie;
/**
 * La classe rappresenta una Costante di tipo Intero
 * @author Federica Magliocca
 *
 */
public class Intero extends Costante {
	private int valore;
	/**
	 * assegna il valore in input al campo dell'oggetto
	 * @param valore di tipo int
	 * @throws InteroNonPositivoException
	 */
	public Intero(int valore) throws InteroNonPositivoException{
		if (valore>=0) this.valore=valore;
		else throw new InteroNonPositivoException();
	}
	/**
	 * @return il campo valore dell'oggetto
	 */
	public Integer getValore() {
		return valore;
	}

}
