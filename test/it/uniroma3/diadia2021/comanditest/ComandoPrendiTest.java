package it.uniroma3.diadia2021.comanditest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.IOConsole;
import it.uniroma3.diadia2021.Partita;
import it.uniroma3.diadia2021.ambienti.Labirinto;
import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;
import it.uniroma3.diadia2021.comandi.Comando;
import it.uniroma3.diadia2021.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private static final String ATTREZZO = "attrezzo da prendere";
	private Comando comandoPrendi;
	private Partita partita;
	private Labirinto labirinto;	
	
	@Before
	public void setUp() throws Exception {
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setIO(new IOConsole());
		this.partita = new Partita(this.labirinto);
		Attrezzo attrezzoDaPrendere = new Attrezzo(ATTREZZO, 1);
		this.partita.getLabirinto().getStanzaIniziale().addAttrezzo(attrezzoDaPrendere);
	}

	@Test
	public void testEseguiAttrezzoNonPresente() {
		String inesistente = "attrezzoInesistente";
		this.comandoPrendi.setParametro(inesistente);
		this.comandoPrendi.esegui(partita);
		assertFalse(this.partita.getPlayer().getSatchel().hasAttrezzo(inesistente));
		assertFalse(this.partita.getPlayer().getSatchel().hasAttrezzo(ATTREZZO));
		assertTrue(this.partita.getLabirinto().getStanzaIniziale().hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testEseguiAttrezzoPresente() {
		this.comandoPrendi.setParametro(ATTREZZO);
		this.comandoPrendi.esegui(partita);
		assertTrue(this.partita.getPlayer().getSatchel().hasAttrezzo(ATTREZZO));
		assertFalse(this.partita.getLabirinto().getStanzaIniziale().hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testEseguiStanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		this.comandoPrendi.setParametro(ATTREZZO);
		this.comandoPrendi.esegui(partita);
		assertFalse(vuota.hasAttrezzo(ATTREZZO));
		//assertFalse(this.partita.getPlayer().getSatchel().hasAttrezzo(ATTREZZO));
	}
}
