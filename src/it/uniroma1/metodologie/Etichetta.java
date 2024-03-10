package it.uniroma1.metodologie;
import java.util.ArrayList;
/**
 * La classe rappresenta un etichetta ed estende la superclasse astratta Istruzione
 * @author Computer
 *
 */
public class Etichetta extends Istruzione{
	/**
	 * lista delle etichette utilizzate
	 */
	private ArrayList<String> etichette=new ArrayList<>();
	/**
	 * lista degli indici delle righe di ogni etichetta 
	 */
	private ArrayList<Integer> riga=new ArrayList<>();
	public String nome;
	/**
	 * salva il nome dell'etichetta e la riga del file in cui è contenuta
	 * @param indice della riga
	 * @param nome dell'etichetta
	 */
	public Etichetta(int indice,String nome) {
		this.nome=nome.substring(0,nome.length()-1);
		etichette.add(this.nome);
	    riga.add(indice);
	}
	/**
	 * 
	 * @author Federica Magliocca
	 *
	 */
	public class Salto{
		/**
		 * indice della riga alla quale saltare
		 */
		private int rigaACuiSaltare;
		/**
		 * individua la riga dell'etichetta presa in input
		 * @param nomeEtichetta
		 */
		public Salto(String nomeEtichetta) {
			int k;
			if (etichette.contains(nomeEtichetta)) {
				k=etichette.indexOf(nomeEtichetta);
				rigaACuiSaltare=riga.get(k);
			}
		}
		/**
		 * 
		 * @return indice della riga alla quale saltare
		 */
		public int getRiga() {
			return rigaACuiSaltare;
		}
	}
	

}
