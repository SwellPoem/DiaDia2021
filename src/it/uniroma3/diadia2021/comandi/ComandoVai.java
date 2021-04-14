package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;
	private IOConsole io;
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza;
		
		if(direzione==null) {
			this.io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		int cfu = partita.getPlayer().getCfu();
		partita.getPlayer().setCfu(--cfu);
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio("CFU rimasti: " +partita.getPlayer().getCfu());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

}
