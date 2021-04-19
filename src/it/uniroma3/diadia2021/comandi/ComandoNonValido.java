package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;

public class ComandoNonValido implements Comando {

	private IO io;
	private String nonValido;
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("comando non valido");
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
		return this.nonValido;
	}

	@Override
	public String getParametro() {
		return null;
	}

}
