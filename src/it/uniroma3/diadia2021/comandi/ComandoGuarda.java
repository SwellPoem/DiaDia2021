package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;

public class ComandoGuarda implements Comando {

	private IO io;
	private String guarda;
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaIniziale().getDescrizione());
		this.io.mostraMessaggio("inventario: " + partita.getPlayer().getSatchel().getContenuto());
		this.io.mostraMessaggio("CFU rimasti: " + partita.getPlayer().getCfu());
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
		return this.guarda;
	}

	@Override
	public String getParametro() {
		return null;
	}

}
