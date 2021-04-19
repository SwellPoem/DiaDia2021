package it.uniroma3.diadia2021.ambienti;

import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class Labirinto {

	private Stanza stanzaVincente;
	private Stanza stanzaCorrente;
	
	public Labirinto() {
		this.creaStanze();
	}
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo grimaldello = new Attrezzo("grimaldello", 1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new StanzaBloccata("Atrio", "grimaldello", "ovest");
		Stanza aulaN11 = new StanzaBuia("Aula N11", "lanterna");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(grimaldello);

		// il gioco comincia nell'atrio
        this.stanzaCorrente = atrio;  
		this.stanzaVincente = biblioteca;
    }

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
    
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
	
}
