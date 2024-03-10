package it.uniroma1.metodologie;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * La classe rappresenta un programma eseguibile
 * @author Federica Magliocca
 * @see Eseguibile
 */
public class Programma implements Eseguibile{
	/**
	 * lista di istruzioni da eseguire
	 */
	public ArrayList<String> istruzioni=new ArrayList<>();
	/**
	 * lista di variabili utilizzate nel codice del programma eseguito
	 */
	public ArrayList<Variabile> variabili=new ArrayList<>();
	/**
	 * indice riga
	 */
	public int i;
	/**
	 * legge il file
	 * @param nomeFile
	 */
	public Programma(String nomeFile) {
		try(BufferedReader br=Files.newBufferedReader(Paths.get(nomeFile))){
			while(br.ready()) {
				String line=br.readLine();
				istruzioni.add(line);
			}
		}
		catch(IOException e) {
			System.out.print("File inesistente");
			i=istruzioni.size();
		}
	}
	/**
	 * 
	 * @param nomeFile
	 * @return un'istanza di programma
	 */
	public static Programma fromFile(String nomeFile) {
		return new Programma(nomeFile);
	}
	/**
	 * il metodo esegue le righe di codice del file
	 */
	public void eseguiProgramma() throws CodiceErratoException{
		String[] arrayIstruzioni=new String[istruzioni.size()];
		arrayIstruzioni=istruzioni.toArray(arrayIstruzioni);
		Etichetta etichetta=null;
		while (i<arrayIstruzioni.length) {
			boolean istruzioneEseguita=false;
			arrayIstruzioni[i]=arrayIstruzioni[i].substring(0, arrayIstruzioni[i].length());
			arrayIstruzioni[i]=arrayIstruzioni[i].trim();
			if (arrayIstruzioni[i].equals("")) istruzioneEseguita=true;
			if (arrayIstruzioni[i].length()>=3){
				if (arrayIstruzioni[i].substring(0,3).equals("REM")) 
					istruzioneEseguita=true;
				else if (arrayIstruzioni[i].substring(0,3).equals("END")) { 
					i=arrayIstruzioni.length;
					istruzioneEseguita=true;
				}	
			}
			if (arrayIstruzioni[i].length()>=5){
				if (arrayIstruzioni[i].substring(0,5).equals("PRINT")) {
					String[] rigaDaStampare=arrayIstruzioni[i].split("PRINT ");
				    print(rigaDaStampare[1],this);
				    istruzioneEseguita=true;
			    }
				else if (arrayIstruzioni[i].substring(0,5).equals("WHILE")) {
				    String[] s2=arrayIstruzioni[i].split("WHILE ");
				    String[] s3=s2[1].split(" DO ");
				    
				    new Iterazione(s3[0],s3[1],this);
				    istruzioneEseguita=true;
				}
			}
			if (arrayIstruzioni[i].length()>=4){
				if (arrayIstruzioni[i].substring(0,4).equals("GOTO")) {
					String[] nome=arrayIstruzioni[i].split("GOTO ");
					i=etichetta.new Salto(nome[1]).getRiga()-1;
					istruzioneEseguita=true;
			    }
			    else if (arrayIstruzioni[i].substring(0,1).equals("$")) {
			    	String[] s1=arrayIstruzioni[i].split(" = ");
			    	Costante c=controllaTipoDiEspressione(s1[1],this);
				    
				    try{
						assegna(s1[0],c,this);
					}
					catch(ElementoNonValidoException e) {
						return;
					}
				    istruzioneEseguita=true;
			    }
			}
			if (arrayIstruzioni[i].length()>=2){
				if (arrayIstruzioni[i].substring(0,2).equals("IF")) {
					String[] s2=arrayIstruzioni[i].split("IF ");
				    String[] s3=s2[1].split(" THEN ");
				    String[] s4=s3[1].split(" ELSE ");
				    if (s4.length>1) {
				    	try{
				    		new Selezione(confronto(s3[0],this),s4[0],s4[1],this);
				    		istruzioneEseguita=true;
				    	}
				        catch(ConfrontoNonValidoException e) {
				    	    System.out.print("puoi confrontare solo due espressioni");
				    	    return;
				        }
				    }
				    else {
				    	try{
			    		    new Selezione(confronto(s3[0],this),s4[0],this);
			    		    istruzioneEseguita=true;
			    	    }
			            catch(ConfrontoNonValidoException e) {
			    	        System.out.print("puoi confrontare solo due espressioni");
			    	        return;
			            }
			        }
				    
				}
				else if (arrayIstruzioni[i].substring(arrayIstruzioni[i].length()-1).equals(":")) {
					etichetta=new Etichetta(i,arrayIstruzioni[i]);
					istruzioneEseguita=true;
				}
			}
			if (!istruzioneEseguita) {
				throw new CodiceErratoException();
			}
			i++;
			
		}
		
	}
	/**
	 * esegue il programma programmaticamente
	 * @param istruzioni
	 */
	public static void of(Istruzione[] istruzioni) {
		Etichetta e=null;
		int riga=0;
		int indice=0;
		for (int c=0;c<istruzioni.length;c++) {
			if (istruzioni[c] instanceof Etichetta)
				e=(Etichetta)istruzioni[c];
			if (istruzioni[c].getClass().equals(e.new Salto("").getClass())) {
				riga=(e.new Salto(e.nome)).getRiga();
				Istruzione[] array=new Istruzione[istruzioni.length-riga];
				for (int j=riga;j<istruzioni.length;j++) {
					array[indice++]=istruzioni[j];
				}
				of(array);
			}
		}
	}

}
