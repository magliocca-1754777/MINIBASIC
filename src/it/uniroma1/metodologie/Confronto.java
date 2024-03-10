package it.uniroma1.metodologie;
/**
 * La classe rappresenta un'espressione booleana 
 * ed estende la superclasse astratta Espressione
 * @author Federica Magliocca
 *
 */
public class Confronto extends Espressione {
	/**
	 * valore di tipo boolean dell'espressione
	 */
	private boolean confronto;
	/**
	 * confronta due oggetti di tipo Espressione
	 * @param e1
	 * @param operatore di confronto
	 * @param e2
	 * @throws ElementoNonValidoException
	 * @throws VariabileNonInizializzataException
	 * @throws ConfrontoTipiDiversiException
	 */
	public Confronto(Espressione e1,String operatore,Espressione e2) throws ElementoNonValidoException,VariabileNonInizializzataException,ConfrontoTipiDiversiException {
		if (e1==null||e2==null) {
			throw new VariabileNonInizializzataException();
		}
		else {
			if (e1.getClass().equals(e2.getClass())) {
				if (e1 instanceof Stringa) {
					switch(operatore) {
					case "==":confronto =(((Stringa) e1).getValore()).equals(((Stringa) e2).getValore());break;
				    case "<>":confronto =!(((Stringa) e1).getValore()).equals(((Stringa) e2).getValore());break;
				    }
			    }
			    else if (e1 instanceof Booleano) {
				    switch(operatore) {
				    case "==":confronto=((Booleano)e1).getValore()==((Booleano)e2).getValore();break;
				    case "<>":confronto=((Booleano)e1).getValore()!=((Booleano)e2).getValore();break;
				    }
			    }
			    else if (e1 instanceof Intero) {
				    switch(operatore) {
				    case "==":confronto=((Intero)e1).getValore()==((Intero)e2).getValore();break;
				    case "<>":confronto=((Intero)e1).getValore()!=((Intero)e2).getValore();break;
				    case ">":confronto=((Intero)e1).getValore()>((Intero)e2).getValore();break;
				    case ">=":confronto=((Intero)e1).getValore()>=((Intero)e2).getValore();break;
				    case "<":confronto=((Intero)e1).getValore()<((Intero)e2).getValore();break;
				    case "<=":confronto=((Intero)e1).getValore()<=((Intero)e2).getValore();break;
				    }
			    }
			    else throw new ElementoNonValidoException();
		    }
		    else throw new ConfrontoTipiDiversiException();
		}
	}
	/**
	 * 
	 * @return un oggetto di tipo Booleano che rappresenta il valore dell'espressione
	 */
	public Booleano getRisultato() {
		return new Booleano(confronto);
	}

}
