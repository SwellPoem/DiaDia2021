package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;

public class ComandoFine implements Comando {

	private IO io;
	private String fine;

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		this.io.mostraMessaggio("ciao");
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return this.fine;
	}

	@Override
	public String getParametro() {
		return null;
	}

	
}
