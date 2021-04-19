package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;

public interface Comando {
	
	public void esegui(Partita partita);
	
	public void setParametro(String parametro);

	public void setIO(IO io);
	
	public String getNome();

	public String getParametro();
}
