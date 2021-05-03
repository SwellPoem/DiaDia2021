package it.uniroma3.diadia2021.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto labirinto;
	private Map<String, Stanza> mappa;
	private Stanza aggiunta;

	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.mappa = new HashMap<String, Stanza>();
	}
	
	public void aggiungiAllaMappa(Stanza stanza) {
		this.aggiunta = stanza;
		this.mappa.put(stanza.getNome(), stanza);
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza iniziale = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaIniziale(iniziale);
		this.aggiungiAllaMappa(iniziale);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza vincente = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(vincente);
		this.aggiungiAllaMappa(vincente);
		return this;
	}
	
	public LabirintoBuilder addAdiacente(String corrente, String adiacente, String direzione) {
		Stanza stanzaCorrente = this.mappa.get(corrente);
		Stanza stanzaAdiacente = this.mappa.get(adiacente);
		stanzaCorrente.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		this.aggiunta.addAttrezzo(attrezzo);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza = new Stanza(nomeStanza);
		this.aggiungiAllaMappa(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanzaMagica) {
		Stanza stanzaMagica = new StanzaMagica(nomeStanzaMagica);
		this.aggiungiAllaMappa(stanzaMagica);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanzaBloccata, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza stanzaBloccata = new StanzaBloccata(nomeStanzaBloccata, attrezzoSbloccante, direzioneBloccata);
		this.aggiungiAllaMappa(stanzaBloccata);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanzaBuia, String attrezzoLuminoso) {
		Stanza stanzaBuia = new StanzaBuia(nomeStanzaBuia, attrezzoLuminoso);
		this.aggiungiAllaMappa(stanzaBuia);
		return this;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
}
