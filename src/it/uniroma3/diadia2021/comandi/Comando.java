package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;

public interface Comando {
	
	public void esegui(Partita partita);
	
	public void setParametro(String parametro);

}
