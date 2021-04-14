package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;

public class ComandoFine implements Comando {

	private IOConsole io;

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.io.mostraMessaggio("ciao");
	}

	@Override
	public void setParametro(String parametro) {
	}

	
}
