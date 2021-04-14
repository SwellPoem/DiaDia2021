package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;

public class ComandoNonValido implements Comando {

	private IOConsole io;
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("comando non valido");
	}

	@Override
	public void setParametro(String parametro) {
	}

}
