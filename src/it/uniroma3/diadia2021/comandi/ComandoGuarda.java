package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;

public class ComandoGuarda implements Comando {

	private IOConsole io;
	
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio("inventario: " + partita.getPlayer().getSatchel().getContenuto());
		this.io.mostraMessaggio("peso della borsa: " + partita.getPlayer().getSatchel().getPeso() + "kg");
	}

	@Override
	public void setParametro(String parametro) {
	}

}
