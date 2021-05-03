package it.uniroma3.diadia2021.comanditest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.ambienti.Labirinto;
import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;
import it.uniroma3.diadia2021.comandi.Comando;
import it.uniroma3.diadia2021.comandi.ComandoPosa;

public class ComandoPosaTest {
	
	private static final String ATTREZZO = "attrezzo da posare";
	private Comando comandoPosa;
	private Partita partita;
	private Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		this.comandoPosa = new ComandoPosa();
		this.comandoPosa.setIO(new IOConsole());
		this.partita = new Partita(this.labirinto);
		Attrezzo attrezzoDaPosare = new Attrezzo(ATTREZZO, 1);
		this.partita.getPlayer().getSatchel().addAttrezzo(attrezzoDaPosare);
	}

	
	@Test
	public void testEseguiAttrezzoNonInBorsa() {
		String assente = "attrezzoNonInBorsa";
		this.comandoPosa.setParametro(assente);
		this.comandoPosa.esegui(partita);
		assertFalse(this.partita.getLabirinto().getStanzaIniziale().hasAttrezzo(assente));
		assertFalse(this.partita.getPlayer().getSatchel().hasAttrezzo(assente));
		assertTrue(this.partita.getPlayer().getSatchel().hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testEseguiAttrezzoInBorsa() {
		this.comandoPosa.setParametro(ATTREZZO);
		this.comandoPosa.esegui(partita);
		assertTrue(this.partita.getLabirinto().getStanzaIniziale().hasAttrezzo(ATTREZZO));
		assertFalse(this.partita.getPlayer().getSatchel().hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testEseguiStanzaPiena() {
		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaIniziale();
		for(int i=0; i<Stanza.NUMERO_MASSIMO_ATTREZZI; i++) {
			stanzaCorrente.addAttrezzo(new Attrezzo("attrezzo" +1, 1));
		}
		this.comandoPosa.setParametro(ATTREZZO);
		this.comandoPosa.esegui(partita);
		assertFalse(stanzaCorrente.hasAttrezzo(ATTREZZO));
		//assertTrue(this.partita.getPlayer().getSatchel().hasAttrezzo(ATTREZZO));
	}

}
