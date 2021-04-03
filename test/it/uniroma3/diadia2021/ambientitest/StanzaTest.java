package it.uniroma3.diadia2021.ambientitest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia2021.ambienti.Stanza;
import it.uniroma3.diadia2021.attrezzi.Attrezzo;

public class StanzaTest {

	private static final String STANZA="stanzatest";
	private static final String ATTREZZO  = "attrezzotest";
	private static final String SUD="Sud";
	protected Stanza stanza;
	
	@Before
	public void setUp() {
		this.stanza = new Stanza(STANZA);
	}

	@Test
	public void testAdiacenteInesistente() {
		assertNull(this.stanza.getStanzaAdiacente(SUD));
	}
	
	@Test
	public void testHasAttrezzo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 2);
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzoNullo() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}

}
