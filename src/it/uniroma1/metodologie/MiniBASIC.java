package it.uniroma1.metodologie;
/**
 * La classe rappresenta l'interprete del linguaggio di programmazione MiniBASIC
 * @author Federica Magliocca
 *
 */
public class MiniBASIC {
	/**
	 * esegue il programma in input
	 * @param p
	 */
	public void esegui(Programma p) {
		try{
			p.eseguiProgramma();
		}
		catch(CodiceErratoException e) {
			System.out.print("CODICE ERRATO!");
			System.exit(0);
		}
	}
	
	
	

}
