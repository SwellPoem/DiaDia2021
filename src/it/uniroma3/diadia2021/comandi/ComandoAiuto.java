package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;

public class ComandoAiuto implements Comando {

	public String aiuto = "aiuto";
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO io;

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio(" ");
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
		return this.aiuto;
	}

	@Override
	public String getParametro() {
		return null;
	}

}
