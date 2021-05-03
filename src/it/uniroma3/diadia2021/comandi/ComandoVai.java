package it.uniroma3.diadia2021.comandi;

import it.uniroma3.diadia2021.IO;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.ambienti.Stanza;

public class ComandoVai implements Comando {

	private String direzione;
	private IO io;
	final private String VAI = "vai";
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaIniziale();
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
		partita.getLabirinto().setStanzaIniziale(prossimaStanza);
		int cfu = partita.getPlayer().getCfu();
		partita.getPlayer().setCfu(--cfu);
		this.io.mostraMessaggio("sei in: " + partita.getLabirinto().getStanzaIniziale().getNome());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
		
	}

	@Override
	public String getNome() {
		return this.VAI;
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}

}
